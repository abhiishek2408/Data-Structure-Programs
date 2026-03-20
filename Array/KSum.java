import java.util.*;

public class KSum {

    public static List<List<Integer>> kSum(int[] nums, int target, int k, int start) {

        List<List<Integer>> res = new ArrayList<>();

        if(k == 2) {

            int left = start;
            int right = nums.length - 1;

            while(left < right) {

                int sum = nums[left] + nums[right];

                if(sum == target) {

                    res.add(Arrays.asList(nums[left], nums[right]));

                    while(left < right && nums[left] == nums[left+1]) left++;
                    while(left < right && nums[right] == nums[right-1]) right--;

                    left++;
                    right--;
                }

                else if(sum < target)
                    left++;

                else
                    right--;
            }

            return res;
        }

        for(int i = start; i < nums.length - k + 1; i++) {

            if(i > start && nums[i] == nums[i-1])
                continue;

            List<List<Integer>> temp = kSum(nums, target - nums[i], k - 1, i + 1);

            for(List<Integer> list : temp) {

                List<Integer> newList = new ArrayList<>();
                newList.add(nums[i]);
                newList.addAll(list);

                res.add(newList);
            }
        }

        return res;
    }

    public static List<List<Integer>> solve(int[] nums, int target, int k) {

        Arrays.sort(nums);
        return kSum(nums, target, k, 0);
    }

    public static void main(String[] args) {

        int nums[] = {1,0,-1,0,-2,2};
        int target = 0;

        System.out.println(solve(nums, target, 4));
    }
}
