package HackerRank;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MiniMaxSum {
    private static int[] sortArray(int[] nums){
        int temp;
        for (int i = 1; i < nums.length/2; i++) {
            temp = nums[i];
            if(temp > nums[nums.length - 1 - i]){
                nums[i] = nums[nums.length - 1 - i];
                nums[nums.length - 1 - i] = temp;
            }
        }
        return nums;
    }

    public static void minimaxSum(int[] arr){
        int minSum, maxSum;
        int sum = 0;

        sortArray(arr);
        for (int i : arr) {
            sum+=i;
        }
        minSum = sum - arr[arr.length-1];
        maxSum = sum - arr[0];
        System.out.println(minSum + " " + maxSum);
    }

    public static void main (String[] args){
        int[] a = {1,5,3,2,9};
        System.out.println(Arrays.toString(sortArray(a)));
        minimaxSum(a);
    }
}
