package HackerRank;
/*
* Given a non-empty array of integers, every element appears twice except for one. Find that single one.
* Input: [2,2,1]
* Output: 1
* */
public class SingleNumber {
    public static int singleNum(int[] nums){
        int a = 0;
        //a XOR 0 = a, a XOR a = 0, a XOR b = 1; the same return 0, different return 1
        for (int i : nums){
            a ^= i;
        }
        return a;
    }

    public static void main (String[] args){
        int[] nums = {2,2,1};
        System.out.println(singleNum(nums));

    }
}
