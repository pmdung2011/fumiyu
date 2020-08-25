package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeNum {
    public static int sortArr (int[] arr){
        int a = arr.length;
        Arrays.sort(arr);
        int counter = 0;
        for (int i : arr){
            if(a == i){
                counter++;
            }
        }

        if(counter == 0){
            int temp = arr[arr.length-1];
            counter+=1;
            for(int j = arr.length - 2; j >= 0; j--){
                if(temp == arr[j]){
                    counter++;
                }
            }
        }
        return counter;
    }

    public static void main(String[] args){
        int[] a = {11,9, 3,3,5,5,7,9};
        System.out.println(sortArr(a));
    }
}
