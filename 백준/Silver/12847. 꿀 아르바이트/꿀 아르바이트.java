import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n =  sc.nextInt();
        int m = sc.nextInt();
        long[] array = new long[n];
        long num = 0;
        for(int i = 0; i < n; i++){
            array[i] = sc.nextInt();
        }
        for(int i = 0; i < m; i++){
            num += array[i];
        }
        long maxSum = num;
        for(int i = m; i < n; i++){
            num += array[i] - array[i-m];
            maxSum = Math.max(maxSum, num);
        }

        System.out.println(maxSum);
    }
}