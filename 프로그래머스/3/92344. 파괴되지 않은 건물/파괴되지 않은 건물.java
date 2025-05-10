class Solution {
    public int solution(int[][] board, int[][] skill) {
        int[][] newBoard = new int[board.length+1][board[0].length+1];
        for(int[] s : skill){
            int degree = s[5];
            degree = (s[0] == 1) ? -degree : degree;
            int r1 = s[1];
            int c1 = s[2];
            int r2 = s[3];
            int c2 = s[4];
            newBoard[r1][c1] += degree;
            newBoard[r2+1][c2+1] += degree;
            newBoard[r1][c2+1] -= degree;
            newBoard[r2+1][c1] -= degree;
        }
        int row = board.length;
        int col = board[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 1; j < col; j++){
                newBoard[i][j] += newBoard[i][j-1];
            }
        }
        for(int j = 0; j < col; j++){
            for(int i = 1; i < row; i++){
                newBoard[i][j] += newBoard[i-1][j];
            }
        }
        // for(int i = 0; i < row; i++){
        //     for(int j = 0; j < col; j++){
        //         System.out.print(board[i][j] + newBoard[i][j]);
        //     }
        //     System.out.println();
        // }
        int answer = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] + newBoard[i][j]>0) answer++;
            }
        }
        return answer;
    }
}
