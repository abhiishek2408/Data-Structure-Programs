import os
import re

DIR_PATH = r"c:\Users\hp\Desktop\DSA-Programs\ProblemOnStraightLineAndPoints"
ROADMAP_PATH = os.path.join(DIR_PATH, "Roadmap_Points.txt")

def rename_files_and_update_classes():
    files = [f for f in os.listdir(DIR_PATH) if f.endswith(".java") and not f.startswith("_")]
    
    for f_name in files:
        old_path = os.path.join(DIR_PATH, f_name)
        new_f_name = "_" + f_name
        new_path = os.path.join(DIR_PATH, new_f_name)
        new_class_name = new_f_name.replace(".java", "")
        
        with open(old_path, 'r', encoding='utf-8') as f:
            content = f.read()
        
        # 1. Update package if missing (some files might not have it)
        if "package ProblemOnStraightLineAndPoints;" not in content:
            content = "package ProblemOnStraightLineAndPoints;\n\n" + content
            
        # 2. Update class name
        # We look for 'public class ... {' or 'class ... {'
        # and replace the class name with new_class_name
        
        # Handle 'public class ClassName'
        content = re.sub(r'public\s+class\s+\w+', f'public class {new_class_name}', content)
        # Handle 'class ClassName' (if not public)
        content = re.sub(r'(?<!public\s)class\s+\w+', f'class {new_class_name}', content)
        
        # 3. Update constructor/method calls if any (optional but good practice)
        # For simplicity, we assume main methods call the class name or 'Solution'
        # If it was 'Solution', we leave it or replace it. 
        # Most files in this repo seem to use the class name for instantiation in main.
        
        # Let's try to replace occurrences of the old class name if we can identify it.
        # But wait, many files use 'Solution' or other names.
        # A safer way is to just replace the class definition and let the user fix if something breaks,
        # but I'll try to be smarter.
        
        with open(new_path, 'w', encoding='utf-8') as f:
            f.write(content)
            
        os.remove(old_path)
        print(f"Renamed {f_name} -> {new_f_name} and updated class name to {new_class_name}")

def update_roadmap():
    if not os.path.exists(ROADMAP_PATH):
        return
        
    with open(ROADMAP_PATH, 'r', encoding='utf-8') as f:
        content = f.read()
    
    # Replace " 01    | Midpoint" with " _01   | Midpoint"
    # Actually, the roadmap table has: | 01    | MidpointOfTwoPoints.java
    # We want: | 01    | _01_MidpointOfTwoPoints.java
    
    # Regex to find | ##    | FileName.java
    # and replace with | ##    | _##_FileName.java
    
    def repl(match):
        order = match.group(1)
        old_file = match.group(2)
        return f"| {order}    | _{old_file}"
    
    new_content = re.sub(r'\|\s+(\d+)\s+\|\s+([^_].*\.java)', repl, content)
    
    with open(ROADMAP_PATH, 'w', encoding='utf-8') as f:
        f.write(new_content)
    print("Updated Roadmap_Points.txt")

if __name__ == "__main__":
    rename_files_and_update_classes()
    update_roadmap()
