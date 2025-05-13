import argparse
import os
import sys
from colorama import init, Fore, Style

# Init colorama
init(autoreset=True)

def slugify(name: str) -> str:
    return name.lower().replace(' ', '_').replace('-', '_')

def constantify(name: str) -> str:
    return slugify(name).upper()

def generate_entries(names, class_name):
    item_lines = []
    moditems_lines = []

    for name in sorted(names, key=str.casefold):
        slug = slugify(name)
        const = constantify(name)

        item_line = f'public static final DeferredItem<Item> {const} = registerTooltip("{slug}", TooltipItem::new, new Item.Properties(), ALL);'
        moditems_line = f'public static final DeferredItem<Item> {const} = {class_name}.{const};'

        item_lines.append(item_line)
        moditems_lines.append(moditems_line)

    return item_lines, moditems_lines

def read_names_from_file(filepath):
    with open(filepath, 'r', encoding='utf-8') as f:
        return [line.strip() for line in f if line.strip()]

def write_output(output_path, item_lines, moditems_lines):
    with open(output_path, 'w', encoding='utf-8') as f:
        f.write("// Field declarations for class file:\n")
        f.write("\n".join(item_lines))
        f.write("\n\n// Forwarding entries for ModItems:\n")
        f.write("\n".join(moditems_lines))

def interactive_mode():
    print(Fore.CYAN + "Interactive mode activated.")
    class_name = input("Enter Java class name (e.g., FishItems): ").strip()
    print(Fore.YELLOW + "Enter item names (one per line). Type 'done' to finish:")
    names = []
    while True:
        line = input("> ").strip()
        if line.lower() == "done":
            break
        if line:
            names.append(line)

    item_lines, moditems_lines = generate_entries(names, class_name)
    print(Fore.GREEN + "\nGenerated Entries:")
    print(Fore.CYAN + "\n// Class Declarations")
    print("\n".join(item_lines))
    print(Fore.CYAN + "\n// ModItems Forwarders")
    print("\n".join(moditems_lines))

def main():
    parser = argparse.ArgumentParser(description="Generate Minecraft item class entries from a name list.")
    parser.add_argument('--input', help="Path to text file with item names")
    parser.add_argument('--class', help="Java class name (e.g., FishItems)")
    parser.add_argument('--output', help="Path to output file (optional)")
    args = parser.parse_args()

    if not args.input:
        interactive_mode()
        return

    if not args.class:
        print(Fore.RED + "Error: --class is required when using --input.")
        sys.exit(1)

    if not os.path.exists(args.input):
        print(Fore.RED + f"Error: File '{args.input}' not found.")
        sys.exit(1)

    names = read_names_from_file(args.input)
    item_lines, moditems_lines = generate_entries(names, args.class)

    if args.output:
        write_output(args.output, item_lines, moditems_lines)
        print(Fore.GREEN + f"Output written to: {args.output}")
    else:
        print(Fore.CYAN + "\n// Class Declarations")
        print("\n".join(item_lines))
        print(Fore.CYAN + "\n// ModItems Forwarders")
        print("\n".join(moditems_lines))

if __name__ == "__main__":
    main()
