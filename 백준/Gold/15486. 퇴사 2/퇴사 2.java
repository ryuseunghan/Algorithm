import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] dp = new int[N+1];
        for(int i = 0; i < N; i++){
            int day = sc.nextInt();
            int money = sc.nextInt();
            if(i > 0){
                dp[i] = dp[i] > dp[i-1] ? dp[i] : dp[i-1];
            }
            if(i+day <= N && dp[i+day] < dp[i] + money){
                dp[i+day] = dp[i] + money;
            }
        }
        System.out.println(Math.max(dp[N], dp[N-1]));
    }
}