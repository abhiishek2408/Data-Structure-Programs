import java.util.HashSet;

public class CheckDuplicate {

    public boolean checkDuplicateBruteforce(int[] nums) {
        boolean isDup = false;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
            if(nums[i]==nums[j]){
             isDup = true;
            }
            }
        }
        return isDup;
    }

    public boolean checkDuplicateEfficient(int[] nums) {
        HashSet<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    
}
