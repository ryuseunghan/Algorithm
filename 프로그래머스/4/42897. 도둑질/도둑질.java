class Solution {
    public int solution(int[] money) {
        int max =0;
        int[][] dp = new int[2][2];
        
        // 0번째 집을 털지 않았을 경우
        dp[0][0] = 0;
        dp[0][1] = 0;

        for(int i = 0; i < money.length; i++){
            if(i == money.length - 1){
                max = Math.max(dp[0][0], dp[0][1]);
                continue;
            }
            dp[1][1] = dp[0][1] > dp[0][0] ? dp[0][1] : dp[0][0];
            dp[1][0] = dp[0][1] + money[i+1];
            dp[0][1] = dp[1][1]; dp[1][1] = 0;
            dp[0][0] = dp[1][0]; dp[1][0] = 0;

        }
        
        // 0번째 집을 턴 경우
        dp = new int[2][2];
        dp[0][0] = money[0];
        dp[0][1] = 0;
        for(int i = 0; i < money.length; i++){
            if(i == money.length - 1){
                max = Math.max(max, dp[0][1]);
                continue;
            }
            dp[1][1] = dp[0][1] > dp[0][0] ? dp[0][1] : dp[0][0];
            dp[1][0] = dp[0][1] + money[i+1];
            dp[0][1] = dp[1][1]; dp[1][1] = 0;
            dp[0][0] = dp[1][0]; dp[1][0] = 0;
        }
        
        return max;
    }
}