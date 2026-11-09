#!/usr/bin/env python3
"""Add a simple item to the Arprod Delight registry and client resources.

Usage from the project root:
    python tools/add_item.py roasted_peach
    python tools/add_item.py roasted_peach --display-name "Roasted Peach"
    python tools/add_item.py roasted_peach --item-class RoastedPeachItem

The optional item class must already exist and have a no-argument constructor.
"""

import argparse
import json
import re
import sys
import tkinter as tk
from tkinter import messagebox
from pathlib import Path


ROOT = Path(__file__).resolve().parents[1]
REGISTRY = ROOT / "src/main/java/com/arprod/arproddelight/registry/ArproddelightModItems.java"
LANG = ROOT / "src/main/resources/assets/arproddelight/lang/en_us.json"
MODELS = ROOT / "src/main/resources/assets/arproddelight/models/item"


def title_from_id(item_id: str) -> str:
    return " ".join(word.capitalize() for word in item_id.split("_"))


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument("item_id", nargs="?", help="Registry ID, such as roasted_peach")
    parser.add_argument("--display-name", help="English name (defaults to title-cased item ID)")
    parser.add_argument("--item-class", default="BasicItem", help="Existing no-argument item class (default: BasicItem)")
    parser.add_argument("--gui", action="store_true", help="Open the graphical item creator")
    args = parser.parse_args()

    if args.gui or not args.item_id:
        return launch_gui()

    if not re.fullmatch(r"[a-z0-9]+(?:_[a-z0-9]+)*", args.item_id):
        parser.error("item_id must use lowercase letters, digits, and single underscores")
    if not re.fullmatch(r"[A-Za-z_$][A-Za-z0-9_$]*", args.item_class):
        parser.error("item-class must be a Java class name")

    if not REGISTRY.is_file() or not LANG.is_file():
        print("Run this script from a checkout containing the expected project files.", file=sys.stderr)
        return 1

    registry_text = REGISTRY.read_text(encoding="utf-8")
    registration = re.compile(
        r'REGISTRY\.register\("' + re.escape(args.item_id) + r'"\s*,'
        r'|block\(ArproddelightModBlocks\.' + re.escape(args.item_id.upper()) + r"\s*\)"
    )
    if registration.search(registry_text):
        print(f"Registry already contains '{args.item_id}'; no registry entry added.")
    else:
        field_name = args.item_id.upper()
        line = f'    public static final RegistryObject<Item> {field_name} = REGISTRY.register("{args.item_id}", {args.item_class}::new);\n'
        close = registry_text.rfind("}")
        if close < 0:
            print("Could not find the end of the item registry.", file=sys.stderr)
            return 1
        REGISTRY.write_text(registry_text[:close] + line + registry_text[close:], encoding="utf-8")
        print(f"Added {field_name} to the item registry.")

    model_path = MODELS / f"{args.item_id}.json"
    if model_path.exists():
        print(f"Model already exists at {model_path.relative_to(ROOT)}; left unchanged.")
    else:
        MODELS.mkdir(parents=True, exist_ok=True)
        model_path.write_text(json.dumps({
            "parent": "item/generated",
            "textures": {"layer0": f"arproddelight:item/{args.item_id}"},
        }, indent=2) + "\n", encoding="utf-8")
        print(f"Created model {model_path.relative_to(ROOT)} (add its texture separately).")

    translations = json.loads(LANG.read_text(encoding="utf-8"))
    lang_key = f"item.arproddelight.{args.item_id}"
    if lang_key in translations:
        print(f"Language entry '{lang_key}' already exists; left unchanged.")
    else:
        translations[lang_key] = args.display_name or title_from_id(args.item_id)
        LANG.write_text(json.dumps(translations, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
        print(f"Added English name: {translations[lang_key]}")

    return 0


def launch_gui() -> int:
    root = tk.Tk()
    root.title("Add Item")
    root.resizable(False, False)

    fields = {}
    for row, (label, key, default) in enumerate((
        ("Item ID", "item_id", ""),
        ("Display name", "display_name", ""),
        ("Item class", "item_class", "BasicItem"),
    )):
        tk.Label(root, text=label).grid(row=row, column=0, padx=12, pady=7, sticky="w")
        entry = tk.Entry(root, width=36)
        entry.insert(0, default)
        entry.grid(row=row, column=1, padx=12, pady=7)
        fields[key] = entry

    status = tk.StringVar(value=f"Project: {ROOT}")
    tk.Label(root, textvariable=status, wraplength=400, justify="left").grid(
        row=3, column=0, columnspan=2, padx=12, pady=(4, 8), sticky="w"
    )

    def add_item() -> None:
        item_id = fields["item_id"].get().strip()
        item_class = fields["item_class"].get().strip() or "BasicItem"
        if not re.fullmatch(r"[a-z0-9]+(?:_[a-z0-9]+)*", item_id):
            messagebox.showerror("Invalid item ID", "Use lowercase letters, digits, and single underscores.", parent=root)
            return
        if not re.fullmatch(r"[A-Za-z_$][A-Za-z0-9_$]*", item_class):
            messagebox.showerror("Invalid item class", "Enter a valid Java class name.", parent=root)
            return
        try:
            registry_text = REGISTRY.read_text(encoding="utf-8")
            if not REGISTRY.is_file() or not LANG.is_file():
                raise FileNotFoundError("Expected project files were not found.")
            matcher = re.compile(
                r'REGISTRY\.register\("' + re.escape(item_id) + r'"\s*,'
                r'|block\(ArproddelightModBlocks\.' + re.escape(item_id.upper()) + r"\s*\)"
            )
            if not matcher.search(registry_text):
                field_name = item_id.upper()
                line = f'    public static final RegistryObject<Item> {field_name} = REGISTRY.register("{item_id}", {item_class}::new);\n'
                close = registry_text.rfind("}")
                if close < 0:
                    raise ValueError("Could not find the end of the item registry.")
                REGISTRY.write_text(registry_text[:close] + line + registry_text[close:], encoding="utf-8")

            model_path = MODELS / f"{item_id}.json"
            if not model_path.exists():
                MODELS.mkdir(parents=True, exist_ok=True)
                model_path.write_text(json.dumps({
                    "parent": "item/generated",
                    "textures": {"layer0": f"arproddelight:item/{item_id}"},
                }, indent=2) + "\n", encoding="utf-8")

            translations = json.loads(LANG.read_text(encoding="utf-8"))
            lang_key = f"item.arproddelight.{item_id}"
            translations.setdefault(lang_key, fields["display_name"].get().strip() or title_from_id(item_id))
            LANG.write_text(json.dumps(translations, ensure_ascii=False, indent=2) + "\n", encoding="utf-8")
        except (OSError, ValueError, json.JSONDecodeError) as error:
            messagebox.showerror("Could not add item", str(error), parent=root)
            return

        status.set(f"Added {item_id}. Add its texture at assets/arproddelight/textures/item/{item_id}.png.")
        messagebox.showinfo("Item added", f"Created registry entry, model, and English name for '{item_id}'.", parent=root)

    tk.Button(root, text="Add Item", command=add_item).grid(row=4, column=0, columnspan=2, pady=(0, 12))
    root.mainloop()
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
