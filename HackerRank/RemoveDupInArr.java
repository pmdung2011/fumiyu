package HackerRank;

import java.util.*;

/*
* Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
*
* Given nums = [1,1,2],

Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.

It doesn't matter what you leave beyond the returned length.
* */
public class RemoveDupInArr {
    public static int removeDuplicates(int[] nums){
        //assume need extra space

        //Using Set
//        Set<Integer> set = new HashSet<>();
//        for (int value : nums) {
//            set.add(value);
//        }
//        return set.size();

        //Using HashMap
//        HashMap<Integer,Boolean> map = new HashMap<>();
//        for (int value : nums) {
//            map.putIfAbsent(value, true);
//        }
//
//        return map.size();

        if(nums.length==0){
            return 0;
        }
        int j=0;
        for(int i=1;i<nums.length;i++){
            if(nums[j]!=nums[i]){
                nums[++j]=nums[i];
            }
        }
        System.out.println(Arrays.toString(nums));
        return j+1;


    }



    // 1 1 2: 1 ,2
    public static void main(String[] args){
        int[] nums = {1,1,3,4};
        System.out.println(removeDuplicates(nums));
    }
}
