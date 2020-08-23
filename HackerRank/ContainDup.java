package HackerRank;

import java.util.Arrays;

public class ContainDup {
    public static boolean containsDuplicate(int[] nums) {
        //Method 1:

        for (int num : nums) {
            for (int j = 1; j < nums.length; j++) {
                System.out.println("num[i]: " + num);
                System.out.println("nums[j] " + nums[j]);
                System.out.println("=============");
                if (num != nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args){
        int[] nums = {1,1,1,3,3,4,3,2,4,2};
        int[] arr = {1,2,3,4};
        System.out.println(containsDuplicate(arr));
    }
}
