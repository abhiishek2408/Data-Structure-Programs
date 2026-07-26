import os
import re

SYLLABUS_PATH = r"c:\Users\hp\Desktop\DSA-Programs\Syllabus.txt"
ROOT_DIR = r"c:\Users\hp\Desktop\DSA-Programs"

def get_implemented_files():
    implemented = []
    for root, dirs, files in os.walk(ROOT_DIR):
        if ".git" in root or ".vscode" in root or "scratch" in root:
            continue
        for f in files:
            if f.endswith(".java"):
                implemented.append((f, os.path.relpath(os.path.join(root, f), ROOT_DIR)))
    return implemented

def parse_syllabus():
    # Sections to look for questions
    sections = [
        "## 🟢 BASIC POINTER PROBLEMS",
        "## 🟡 TWO POINTER – CLASSIC INTERVIEW QUESTIONS",
        "## 🟠 SLIDING WINDOW + POINTER MIX",
        "## 🔴 ADVANCED TWO POINTER PROBLEMS",
        "## 🔁 POINTER + REVERSE / ROTATION",
        "## 🔗 POINTERS IN LINKED LIST (MUST-DO)",
        "## 🟢 BASIC REVERSE QUESTIONS",
        "## 🟡 INTERMEDIATE REVERSE QUESTIONS",
        "## 🟠 ROTATION + REVERSE",
        "## 🔴 ADVANCED / INTERVIEW LEVEL",
        "## 🧠 PATTERN-BASED REVERSE QUESTIONS",
        "## 🟢 BASIC COORDINATE PROBLEMS",
        "## 🟡 INTERMEDIATE PROBLEMS",
        "## 🟠 SLOPE & LINE BASED PROBLEMS",
        "## 🔴 ADVANCED / INTERVIEW LEVEL"
    ]
    
    with open(SYLLABUS_PATH, 'r', encoding='utf-8') as f:
        lines = f.readlines()
    
    questions = []
    current_section = None
    
    for line in lines:
        line = line.strip()
        if not line: continue
        
        if line.startswith("##"):
            current_section = line
        
        if current_section:
            # Match "1. Question" or "11. Question"
            match = re.match(r"^\d+\.\s*(.*)", line)
            if match:
                q_text = match.group(1).strip()
                # Remove extra info like (LeetCode style)
                q_text = re.sub(r'\(.*\)', '', q_text).strip()
                questions.append(q_text)
                
    return questions

def check_missing(questions, files):
    missing = []
    for q in questions:
        q_words = [w.lower() for w in re.findall(r'\w+', q)]
        found = False
        
        for f_name, f_path in files:
            f_lower = f_name.lower()
            # Strict matching: at least 70% of question words must be in filename
            # OR all unique key words must be there.
            matches = 0
            for w in q_words:
                if w in f_lower:
                    matches += 1
            
            if len(q_words) > 0 and (matches / len(q_words) >= 0.7):
                found = True
                break
        
        if not found:
            missing.append(q)
    return missing

def main():
    files = get_implemented_files()
    questions = parse_syllabus()
    
    # Deduplicate
    unique_questions = []
    seen = set()
    for q in questions:
        if q.lower() not in seen:
            unique_questions.append(q)
            seen.add(q_lower := q.lower())
            
    missing = check_missing(unique_questions, files)
    
    print(f"Scanned {len(unique_questions)} questions from Syllabus.")
    print(f"Found {len(missing)} questions that don't seem to have a matching .java file.")
    print("\n--- DETAILED MISSING LIST ---")
    for m in missing:
        print(m)

if __name__ == "__main__":
    main()
