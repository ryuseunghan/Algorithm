import java.util.*;
class Solution {
    static int[] start;
    static int[] end;
    static int[] moveR =new int[]{-1, 0, 1, 0};
    static int[] moveC =new int[]{0, 1, 0, -1};
    static int n;
    static int m;
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        int[][] graph = new int[n+1][m+1];
        boolean[][] visited = new boolean[n+1][m+1];
        int r = 0;
        int c = 0;
        for(String row : board){
            r++; c = 0;
            String[] strs = row.split("");
            for(String str : strs){
                c++;
                if(str.equals(".")) graph[r][c] = 0;
                if(str.equals("D")) graph[r][c] = -1;
                if(str.equals("R")) start = new int[]{r, c};
                if(str.equals("G")) end = new int[]{r, c};
            }
        }
        // for(int i = 1; i <= n; i++){
        //     for(int j = 1; j <= m; j++){
        //         System.out.print(graph[i][j]);
        //     }
        //     System.out.println();
        // }
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(start);
        visited[start[0]][start[1]] = true;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            
            for(int i =0; i< 4; i++){
                int newR = node[0];
                int newC = node[1];
                // 보드 내부 + 장애물 만나지 않았을 때
                while(inBoard(newR + moveR[i], newC + moveC[i]) && graph[newR + moveR[i]][newC + moveC[i]] >= 0){
                    newR += moveR[i];
                    newC += moveC[i];
                }
                if(!visited[newR][newC]){
                    visited[newR][newC] = true;
                    queue.offer(new int[]{newR, newC});
                    graph[newR][newC] = graph[node[0]][node[1]] + 1;
                }
                
            }
        }
        if(graph[end[0]][end[1]] > 0) return graph[end[0]][end[1]];
        return -1;
    }
    static boolean inBoard(int r, int c){
        if(r >0 && r <= n && c > 0 && c <= m) return true;
        return false;
    }
}