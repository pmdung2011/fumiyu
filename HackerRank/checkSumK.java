package HackerRank;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
* Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].*/
public class checkSumK {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};

            }
            map.put(nums[i],i); // 2 - 0

            System.out.println("Hashmap: " + map);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args){
        int[] nums = {2, 7, 11, 15};

        System.out.println(Arrays.toString(twoSum(nums,9)));
    }

}
