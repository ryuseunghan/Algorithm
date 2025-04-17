class Solution
{
    public int solution(int [][]board)
    {
        int ans = 0;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1) ans = 1;break;
            }
            if(ans== 1) break;
        }
        for(int i = 1; i < n; i++){
            for(int j = 1; j < m; j++){
                if(board[i][j] > 0 && board[i - 1][j] > 0 && board[i][j - 1] > 0 && board[i - 1][j - 1] > 0) {
                    board[i][j] =  Math.min(board[i - 1][j], Math.min(board[i][j-1], board[i - 1][j-1])) + 1;
                    ans = Math.max(board[i][j], ans);
                }
            }
        }
        return ans*ans;
    }
}