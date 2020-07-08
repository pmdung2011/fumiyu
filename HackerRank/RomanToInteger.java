package HackerRank;

import java.util.HashMap;

/*
* Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
*
* Input: "III"
* Output: 3
*
* I can be placed before V (5) and X (10) to make 4 and 9.
* X can be placed before L (50) and C (100) to make 40 and 90.
* C can be placed before D (500) and M (1000) to make 400 and 900.
* */
public class RomanToInteger {
    public static int romanToInt(String s){
        char[] c = s.toCharArray();
        int sum = 0;
        int len = s.length();
        for (int i = 0; i < len ; i++) {
            switch(c[i]){
                case 'M':
                    sum+= 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'C':
                    if(i+1 < len && (c[i+1] == 'D' || c[i+1] == 'M')){
                        sum-= 100;
                    }
                    else{
                        sum += 100;
                    }
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'X':
                    if(i+1 < len && (c[i+1] == 'L' || c[i+1] == 'C' )){
                        sum -= 10;
                    }
                    else{
                       sum += 10;
                    }
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'I':
                    if(i+1 < len && (c[i+1] == 'V' || c[i+1] == 'X')){
                        sum -= 1;
                    }
                    else{
                        sum += 1;
                    }
                    break;
                default:
                    System.out.println("Invalid letter.");
            }

        }
        return sum;
    }

    public static void main (String[] args){
        String s = "IV";
        System.out.println(romanToInt(s));
    }
}
