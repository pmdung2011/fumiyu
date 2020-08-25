package HackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeNum {
    public static int sortArr (int[] arr){
        int a = arr.length;
        int counter = 0;
        for (int i : arr){
            if(a == i){
                counter++;
            }
        }

        if(counter == 0){
            int temp = arr[0];
            counter+=1;
            for(int j = 1; j < a-1; j++){
                if(temp == arr[j]){
                    counter++;
                }
            }
        }
        return counter;

    }

    public static void main(String[] args){
        int[] a = {9,5, 3,5,5,8,8,9};
        System.out.println(sortArr(a));
    }
}
