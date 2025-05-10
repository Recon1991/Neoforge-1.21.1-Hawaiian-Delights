import os
import json
import re
import argparse
import pygame
from colorama import Fore, Style, init
from collections import defaultdict
from datetime import datetime
import csv

# Initialize console colors and pygame sound mixer
init(autoreset=True)
pygame.mixer.init()


def play_sound(path, volume=0.5):
    if not path or not os.path.exists(path):
        return
    try:
        sound = pygame.mixer.Sound(path)
        sound.set_volume(volume)
        sound.play()
    except Exception as e:
        print(f"(⚠️ Failed to play sound: {path} — {e})")


def title_case(name):
    return name.replace("_", " ").title()


def extract_keys_from_file(filepath, patterns):
    with open(filepath, "r", encoding="utf-8") as file:
        content = file.read()
    keys = []
    for pattern in patterns:
        keys.extend(re.findall(pattern, content))
    return keys


def load_config(config_path):
    with open(config_path, "r", encoding="utf-8") as f:
        return json.load(f)


def print_diff_preview(new_entries, merged, max_width=60):
    for key in sorted(new_entries):
        val = merged[key]
        lhs = f'"{key}":'.ljust(max_width)
        rhs = f'"{val}"'
        print(Fore.GREEN + lhs + Fore.WHITE + rhs)


def check_config_structure(config):
    errors = []

    # Top-level keys
    required_top_keys = ["groups", "output_file"]
    for key in required_top_keys:
        if key not in config:
            errors.append(f"Missing required top-level key: '{key}'")

    # Group entries
    if "groups" in config:
        if not isinstance(config["groups"], list):
            errors.append("'groups' must be a list.")
        else:
            for i, group in enumerate(config["groups"]):
                for required_key in ["type", "registry_dir", "registry_prefix"]:
                    if required_key not in group:
                        errors.append(f"Group #{i + 1} is missing '{required_key}'")

    # Optional path checks
    for path_key in ["existing_lang_file", "startup_sound", "success_sound"]:
        path = config.get(path_key)
        if path and not os.path.exists(path):
            errors.append(f"File not found: {path_key} → {path}")

    return errors


def sort_lang_entries_grouped(lang_dict, prefix_order=("item", "tooltip")):
    grouped = defaultdict(dict)

    for key, val in lang_dict.items():
        parts = key.split(".")
        if len(parts) >= 3:
            key_type, _, base_name = parts[0], parts[1], ".".join(parts[2:])
            grouped[base_name][key_type] = (key, val)
        else:
            grouped[key] = {"misc": (key, val)}

    sorted_result = {}

    for base in sorted(grouped.keys()):
        for prefix in prefix_order:
            if prefix in grouped[base]:
                k, v = grouped[base][prefix]
                sorted_result[k] = v
        if "misc" in grouped[base]:
            k, v = grouped[base]["misc"]
            sorted_result[k] = v

    return sorted_result


def write_log(entries_added, entries_skipped, duplicates, log_dir):
    os.makedirs(log_dir, exist_ok=True)
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    log_path = os.path.join(log_dir, f"langgen_{timestamp}.log")

    with open(log_path, "w", encoding="utf-8") as f:
        f.write(f"LangGen Log - {timestamp}\n")
        f.write(f"New entries added: {len(entries_added)}\n")
        f.write(f"Skipped existing entries: {len(entries_skipped)}\n")
        f.write(f"Duplicates found: {len(duplicates)}\n\n")

        if duplicates:
            f.write("⚠️ Duplicate keys:\n")
            for key, files in duplicates.items():
                f.write(f'  "{key}" in:\n')
                for file in files:
                    f.write(f"    - {file}\n")

        f.write("\n✅ Added entries:\n")
        for k in sorted(entries_added):
            f.write(f"  {k}\n")

        f.write("\n➖ Skipped entries:\n")
        for k in sorted(entries_skipped):
            f.write(f"  {k}\n")

    print(Fore.YELLOW + f"📄 Log written to {log_path}")
    return log_path

def sort_lang_entries_grouped(lang_dict, prefix_order=("item", "tooltip")):
    grouped = defaultdict(dict)

    for key, val in lang_dict.items():
        # Parse keys like item.hawaiinei.kukui_oil
        parts = key.split(".")
        if len(parts) >= 3:
            key_type, _, base_name = parts[0], parts[1], ".".join(parts[2:])
            grouped[base_name][key_type] = (key, val)
        else:
            grouped[key] = {"misc": (key, val)}

    sorted_result = {}

    for base in sorted(grouped.keys()):
        for prefix in prefix_order:
            if prefix in grouped[base]:
                k, v = grouped[base][prefix]
                sorted_result[k] = v
        if "misc" in grouped[base]:
            k, v = grouped[base]["misc"]
            sorted_result[k] = v

    return sorted_result


def write_csv(full_dict, added_keys, existing_keys, output_path):
    with open(output_path, "w", newline="", encoding="utf-8") as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow(["key", "value", "status"])
        for k, v in sorted(full_dict.items()):
            if k in added_keys:
                writer.writerow([k, v, "added"])
            elif k in existing_keys:
                writer.writerow([k, v, "skipped"])
    print(Fore.YELLOW + f"📊 CSV export written to {output_path}")


def print_footer_summary(lang_file, csv_file, log_file, added_count, skipped_count, success_sound):
    print()
    print(Fore.MAGENTA + Style.BRIGHT + "✨ LangGen Complete!")
    print(Fore.CYAN + f"📘 Lang Entries Written:       {lang_file}")
    if csv_file:
        print(Fore.CYAN + f"📊 CSV Export Created:         {csv_file}")
    if log_file:
        print(Fore.CYAN + f"📝 Log File Created:           {log_file}")
    print()
    print(Fore.GREEN + f"✅ New Entries Added:          {added_count}")
    print(Fore.YELLOW + f"➖ Existing Entries Skipped:    {skipped_count}")
    print()

    play_sound(success_sound, volume=0.5)


def main():
    parser = argparse.ArgumentParser(description="Generate and merge Minecraft lang entries.")
    parser.add_argument("--dry-run", action="store_true", help="Preview changes without writing to file.")
    parser.add_argument("--only-show", action="store_true", help="Only show registry-derived lang keys.")
    parser.add_argument("--csv", action="store_true", help="Export results as CSV.")
    parser.add_argument("--output-file", help="Override output file path.")
    parser.add_argument("--config", default="lang_config.json", help="Path to config JSON file.")
    parser.add_argument("--csv-output", help="Path to write CSV export.")
    parser.add_argument("--log-dir", help="Directory for log files.")
    parser.add_argument("--check-config", action="store_true", help="Validate config and exit.")

    args = parser.parse_args()

    config = load_config(args.config)

    # Load sound paths from config
    startup_sound = config.get("startup_sound")
    success_sound = config.get("success_sound")

    # Play startup chime
    play_sound(startup_sound, volume=0.3)

    registry_lang_entries = {}
    key_sources = defaultdict(list)

    # Determine paths
    log_dir = args.log_dir or config.get("log_dir", "langgen_logs")
    csv_output_path = args.csv_output or config.get("csv_output", "registry_lang_export.csv")
    output_path = args.output_file or config["output_file"]

    # 🧠 Step 1: Parse registry files
    for group in config["groups"]:
        group_type = group["type"]
        registry_dir = group["registry_dir"]
        prefix = group["registry_prefix"]

        patterns = {
            "item": [r'registerTooltip\(\s*"([^"]+)"', r'registerTooltipFuel\(\s*"([^"]+)"'],
            "block": [r'registerBlockItemWithTooltip\(\s*"([^"]+)"']
        }.get(group_type, [])

        if not patterns:
            print(Fore.YELLOW + f"⚠️ Unknown group type: {group_type}")
            continue

        for root, _, files in os.walk(registry_dir):
            for filename in files:
                if filename.endswith(".java"):
                    path = os.path.join(root, filename)
                    keys = extract_keys_from_file(path, patterns)
                    for key in keys:
                        full_key = f"{group_type}.{prefix}.{key}"
                        tooltip_key = f"tooltip.{prefix}.{key}"
                        key_sources[full_key].append(path)
                        key_sources[tooltip_key].append(path)
                        registry_lang_entries[full_key] = title_case(key)
                        registry_lang_entries[tooltip_key] = ""

    # 🚨 Step 2: Detect duplicates
    duplicates = {k: v for k, v in key_sources.items() if len(v) > 1}
    if duplicates:
        print(Fore.RED + f"⚠️ Duplicate keys detected. Aborting merge.")
        for key, paths in duplicates.items():
            print(Fore.RED + f'  "{key}" found in:')
            for p in paths:
                print(Fore.YELLOW + f"    - {p}")
        return

    # 👀 Step 3: Only show keys
    if args.only_show:
        print(Fore.CYAN + f"📦 Registry-derived lang keys ({len(registry_lang_entries)} total):")
        for k, v in sorted(registry_lang_entries.items()):
            print(f'"{k}": "{v}"')
        return

    # 📂 Step 4: Load existing entries
    existing_entries = {}
    existing_path = config.get("existing_lang_file")
    if existing_path and os.path.exists(existing_path):
        with open(existing_path, "r", encoding="utf-8") as f:
            existing_entries = json.load(f)

    # 🔁 Step 5: Merge and categorize
    merged = {**existing_entries}
    added_keys = []
    skipped_keys = []

    for k, v in registry_lang_entries.items():
        if k not in merged:
            merged[k] = v
            added_keys.append(k)
        else:
            skipped_keys.append(k)

    sort_mode = config.get("sort_mode", "flat")

    if sort_mode == "grouped":
        merged = sort_lang_entries_grouped(merged)
    elif config.get("sort_keys", False) or sort_mode == "flat":
        merged = dict(sorted(merged.items()))

    # 🧪 Step 6: Dry-run only
    if args.dry_run:
        print(Fore.CYAN + f"🔍 Dry run: {len(added_keys)} new entries would be added:")
        print_diff_preview(added_keys, merged)
        if args.csv:
            write_csv(registry_lang_entries, added_keys, skipped_keys, csv_output_path)
        write_log(added_keys, skipped_keys, duplicates, log_dir)
        return

    # 💾 Step 7: Write final lang file
    with open(output_path, "w", encoding="utf-8") as f:
        json.dump(merged, f, indent=2, ensure_ascii=False)
    print(Fore.GREEN + f"✅ Lang file written to {output_path} with {len(added_keys)} new entries.")

    # 📦 Step 8: Optional CSV + log
    log_path = write_log(added_keys, skipped_keys, duplicates, log_dir)
    csv_path = None
    if args.csv:
        write_csv(registry_lang_entries, added_keys, skipped_keys, csv_output_path)
        csv_path = csv_output_path

    if args.check_config:
        config = load_config(args.config)
        errors = check_config_structure(config)
        if errors:
            print(Fore.RED + "❌ Config validation failed with the following issues:")
            for err in errors:
                print(Fore.LIGHTRED_EX + f"  - {err}")
            return
        print(Fore.GREEN + "✅ Config validation successful. All required fields are present and valid.")
        return

    # 🎉 Final summary
    print_footer_summary(
        lang_file=output_path,
        csv_file=csv_path,
        log_file=log_path,
        added_count=len(added_keys),
        skipped_count=len(skipped_keys),
        success_sound=success_sound
    )


if __name__ == "__main__":
    main()
