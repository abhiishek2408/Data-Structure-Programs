import os
import re

DIR_PATH = r"c:\Users\hp\Desktop\DSA-Programs\ProblemOnStraightLineAndPoints"

def fix_instantiations():
    files = [f for f in os.listdir(DIR_PATH) if f.endswith(".java") and f.startswith("_")]
    
    for f_name in files:
        path = os.path.join(DIR_PATH, f_name)
        new_class_name = f_name.replace(".java", "")
        
        with open(path, 'r', encoding='utf-8') as f:
            content = f.read()
            
        # Replace 'Solution sol = new Solution()' with 'new_class_name sol = new new_class_name()'
        # Replace 'MidpointOfTwoPoints sol = new MidpointOfTwoPoints()' with 'new_class_name sol = new new_class_name()'
        
        # 1. Identify the current class name from the file
        # It should be the one after 'class ' or 'public class '
        match = re.search(r'class\s+(\w+)', content)
        if not match: continue
        current_class_name = match.group(1)
        
        # 2. Find any other class names that might be used for instantiation
        # Often it's 'Solution' if it was a LeetCode style file.
        
        # Replace 'Solution' as a type or constructor
        content = re.sub(r'\bSolution\b', new_class_name, content)
        
        # Also replace any other names that look like the old class name
        # (e.g. if the file was 01_Midpoint... the old class name was Midpoint...)
        # We can guess the old name by removing the _##_ prefix
        old_name_guess = re.sub(r'^_\d+_', '', new_class_name)
        if old_name_guess and old_name_guess != new_class_name:
            content = re.sub(rf'\b{old_name_guess}\b', new_class_name, content)

        with open(path, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"Fixed instantiations in {f_name}")

if __name__ == "__main__":
    fix_instantiations()
