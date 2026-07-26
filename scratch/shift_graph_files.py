import os
import re

DIR_PATH = r"c:\Users\hp\Desktop\DSA-Programs\Graph"
ROADMAP_PATH = os.path.join(DIR_PATH, "Roadmap_Graph.txt")

def shift_files(start_idx=4):
    # 1. Get all java files starting with _
    files = [f for f in os.listdir(DIR_PATH) if f.endswith(".java") and f.startswith("_")]
    
    # 2. Parse filenames to get their index
    pattern = re.compile(r"^_(?P<idx>\d+)_(?P<name>.*)\.java$")
    parsed_files = []
    for f in files:
        m = pattern.match(f)
        if m:
            idx = int(m.group("idx"))
            name = m.group("name")
            if idx >= start_idx:
                parsed_files.append((idx, name, f))
            
    # Sort in descending order to avoid conflict when renaming
    parsed_files.sort(reverse=True, key=lambda x: x[0])
    
    for idx, name, old_fname in parsed_files:
        new_idx = idx + 1
        new_fname = f"_{new_idx:02d}_{name}.java"
        
        old_path = os.path.join(DIR_PATH, old_fname)
        new_path = os.path.join(DIR_PATH, new_fname)
        
        old_classname = old_fname.replace(".java", "")
        new_classname = new_fname.replace(".java", "")
        
        print(f"Renaming {old_fname} -> {new_fname}")
        
        # Read content
        with open(old_path, 'r', encoding='utf-8') as f_in:
            content = f_in.read()
            
        # Replace occurrences of old class name with new class name
        content = re.sub(rf'\b{old_classname}\b', new_classname, content)
        
        # Write to new path
        with open(new_path, 'w', encoding='utf-8') as f_out:
            f_out.write(content)
            
        # Remove old file
        os.remove(old_path)

def update_roadmap(start_idx=4):
    if not os.path.exists(ROADMAP_PATH):
        print("Roadmap file not found.")
        return
        
    with open(ROADMAP_PATH, 'r', encoding='utf-8') as f:
        lines = f.readlines()
        
    new_lines = []
    for line in lines:
        m = re.match(r"^(\|\s*)(\d+)(\s*\|\s*)([a-zA-Z0-9_]+\.java)(\s*\|.*)$", line)
        if m:
            prefix = m.group(1)
            order = int(m.group(2))
            middle = m.group(3)
            fname = m.group(4)
            suffix = m.group(5)
            
            if order >= start_idx:
                new_order = f"{order + 1:02d}"
                new_line = f"{prefix}{new_order}{middle}{fname}{suffix}\n"
                new_lines.append(new_line)
            else:
                new_lines.append(line)
        else:
            new_lines.append(line)
            
    final_lines = []
    inserted = False
    for line in new_lines:
        if not inserted and re.match(r"^\|\s*05\s*\|", line):
            # Insert the new 04 line before 05 (which was originally 04)
            new_entry = "| 04    | GraphInput.java                                                    | Basics (Matrix Repr)     |\n"
            final_lines.append(new_entry)
            inserted = True
        final_lines.append(line)
        
    with open(ROADMAP_PATH, 'w', encoding='utf-8') as f:
        f.writelines(final_lines)
    print("Updated Roadmap_Graph.txt")

if __name__ == "__main__":
    shift_files(start_idx=4)
    update_roadmap(start_idx=4)
