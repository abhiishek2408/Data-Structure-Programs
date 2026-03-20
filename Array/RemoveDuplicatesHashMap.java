import java.util.HashMap;

public class RemoveDuplicatesHashMap {

    public static int removeDuplicates(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;

        for(int i = 0; i < nums.length; i++) {

            int count = map.getOrDefault(nums[i], 0);

            if(count < 2) {
                nums[index] = nums[i];
                index++;
                map.put(nums[i], count + 1);
            }
        }

        return index;
    }

    public static void main(String[] args) {

        int nums[] = {1,1,1,2,2,3};

        int len = removeDuplicates(nums);

        for(int i = 0; i < len; i++)
            System.out.print(nums[i] + " ");
    }
}