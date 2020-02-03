import java.io.*;
import java.util.Scanner;

public class InputOutput {
    static void sum(int x, int y){
        System.out.print(x+y);
    }

    public static void main(String [] args){
        Scanner sc1 = new Scanner(System.in);
        int a = sc1.nextInt();
        int b = sc1.nextInt();

        sum(a,b);
    }

}
