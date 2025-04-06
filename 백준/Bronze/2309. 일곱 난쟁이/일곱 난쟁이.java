import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i<9; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        boolean bool = false;
        for(int i = 0; i<8; i++){
            if(bool) break;
            for(int j = i + 1; j<9; j++){
                if((sum - 100) == arr[i] + arr[j]){
                    arr[i] = 100;
                    arr[j] = 100;
                    bool = true;
                    break;
                }
            }
        }
        Arrays.sort(arr);
        for(int i = 0; i<7; i++){
            System.out.println(arr[i]);
        }
        
    }
}