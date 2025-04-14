class Solution {
    static long[][] dp;
    public int solution(int m, int n, int[][] puddles) {
        dp = new long[m+1][n+1];
        dp[1][1] = 1l;
        for(int i = 1; i <= m; i++){
            for (int j = 1; j <= n; j++){
                if(isNotPuddle(i,j, puddles)) dp[i][j] = (dp[i-1][j]  % 1000000007 + dp[i][j-1]  % 1000000007) % 1000000007; 
            }
        }
        return (int) (dp[m][n]);
    }
    static boolean isNotPuddle(int i, int j, int[][] puddles){
        if(i == 1 && j == 1) return false;
        for(int[] puddle : puddles){
            if(puddle[0] == i && puddle[1] == j) return false;
        }
        return true;
    }
}