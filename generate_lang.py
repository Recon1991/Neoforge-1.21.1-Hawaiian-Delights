import os
import json
import re
import argparse
from colorama import Fore, Style, init
from collections import defaultdict
from datetime import datetime
from playsound import playsound
import csv

init(autoreset=True)

log_dir = args.log_dir or config.get("log_dir", "langgen_logs")
csv_output_path = args.csv_output or config.get("csv_output", "registry_lang_export.csv")

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

def write_log(entries_added, entries_skipped, duplicates):
    os.makedirs(log_dir, exist_ok=True)
    timestamp = datetime.now().strftime("%Y%m%d_%H%M%S")
    log_path = os.path.join(log_dir, f"langgen_{timestamp}.log")

    with open(log_path, "w", encoding="utf-8") as f:
        f.write(f"Lang Gen Log - {timestamp}\n")
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

def write_csv(full_dict, added_keys, existing_keys, output_path):
    with open(output_path, "w", newline="", encoding="utf-8") as csvfile:
        writer = csv.writer(csvfile)
        writer.writerow(["key", "value", "status"])
        for k, v in sorted(full_dict.items()):
            if k in added_keys:
                writer.writerow([k, v, "added"])
            elif k in existing_keys:
                writer.writerow([k, v, "skipped"])
    print(Fore.YELLOW + f"📊 CSV export written to {CSV_OUTPUT}")

def print_footer_summary(lang_file, csv_file, log_file, added_count, skipped_count):
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


def main():
    parser = argparse.ArgumentParser(description="Generate and merge Minecraft lang entries.")
    parser.add_argument("--dry-run", action="store_true", help="Preview changes without writing to file.")
    parser.add_argument("--only-show", action="store_true", help="Only show registry-derived lang keys.")
    parser.add_argument("--csv", action="store_true", help="Export results as CSV.")
    parser.add_argument("--output-file", help="Override output file path.")
    parser.add_argument("--config", default="lang_config.json", help="Path to config JSON file.")
    parser.add_argument("--csv-output", help="Path to write CSV export.")
    parser.add_argument("--log-dir", help="Directory for log files.")
    args = parser.parse_args()

    config = load_config(args.config)
    registry_lang_entries = {}
    key_sources = defaultdict(list)  # Track duplicate keys

    # 🧠 Step 1: Parse registry sources
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

    # 👀 Step 3: Only show
    if args.only_show:
        print(Fore.CYAN + f"📦 Registry-derived lang keys ({len(registry_lang_entries)} total):")
        for k, v in sorted(registry_lang_entries.items()):
            print(f'"{k}": "{v}"')
        return

    # 📂 Step 4: Load existing
    existing_entries = {}
    existing_path = config.get("existing_lang_file")
    if existing_path and os.path.exists(existing_path):
        with open(existing_path, "r", encoding="utf-8") as f:
            existing_entries = json.load(f)

    # 🔁 Step 5: Merge
    merged = {**existing_entries}
    added_keys = []
    skipped_keys = []

    for k, v in registry_lang_entries.items():
        if k not in merged:
            merged[k] = v
            added_keys.append(k)
        else:
            skipped_keys.append(k)

    if config.get("sort_keys", False):
        merged = dict(sorted(merged.items()))

    # 🧪 Step 6: Dry-run
    if args.dry_run:
        print(Fore.CYAN + f"🔍 Dry run: {len(added_keys)} new entries would be added:")
        print_diff_preview(added_keys, merged)
        if args.csv:
            write_csv(registry_lang_entries, added_keys, skipped_keys)
        write_log(added_keys, skipped_keys, duplicates)
        return

    # 💾 Step 7: Write output
    output_path = args.output_file or config["output_file"]
    with open(output_path, "w", encoding="utf-8") as f:
        json.dump(merged, f, indent=2, ensure_ascii=False)

    print(Fore.GREEN + f"✅ Lang file written to {output_path} with {len(added_keys)} new entries.")

    log_path = None
    csv_path = None

    if args.csv:
        write_csv(registry_lang_entries, added_keys, skipped_keys, csv_output_path)
        csv_path = csv_output_path

    log_path = write_log(added_keys, skipped_keys, duplicates, log_dir)

    print_footer_summary(
        lang_file=output_path,
        csv_file=csv_path,
        log_file=log_path,
        added_count=len(added_keys),
        skipped_count=len(skipped_keys)
    )

if __name__ == "__main__":
    main()
