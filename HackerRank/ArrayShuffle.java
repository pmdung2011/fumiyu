package HackerRank;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayShuffle {
    public static int[] shuffle(int[] ar, int n){

        int[] tempArr = new int[n*2];
        for (int i = 0, j = n, idx = 0; idx < ar.length; i++, j++,idx++) {
            tempArr[idx] = ar[i];
            idx+=1;
            tempArr[idx] = ar[j];
        }
        //second method
//        for (int i = 0, j = n, idx = 0; idx < ar.length; i++, j++) {
//            tempArr[idx] = ar[i];
//            tempArr[idx] = ar[j];
//        }

        return tempArr;
    }

    public static void main(String[] args){
        int[] array = {2,5,1,3,4,7};
                    //0 1 2 3 4 5
        // 2 3 5 4 1 7
        // 0 3 1 4 2 5
        System.out.println(Arrays.toString(shuffle(array, 3)));

    }


}
