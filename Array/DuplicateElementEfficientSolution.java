import java.util.HashSet;

class  DuplicateElementEfficientSolution{
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true; // Duplicate found
            }
            seen.add(num);
        }
        return false; // No duplicates
    }
}

