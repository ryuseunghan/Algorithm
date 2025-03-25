import java.util.*;

public class Main {
    static final int MOD = 1_000_000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int len = str.length();

        // 시작이 0이면 해석 불가능
        if (str.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int[] dp = new int[len + 1];
        dp[0] = 1; 
        dp[1] = 1; 

        for (int i = 2; i <= len; i++) {
            char curr = str.charAt(i - 1);
            char prev = str.charAt(i - 2);

            if (curr != '0') {
                dp[i] = dp[i - 1];
            }

            int num = Integer.parseInt(str.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
            }

            dp[i] %= MOD;
        }

        System.out.println(dp[len]);
    }
}
