import java.util.*;
class Solution {
    static int[][] rectangles;
    static boolean[][] visited;
    static int[] moveR = {-1,0,1,0};
    static int[] moveC = {0,1,0,-1};
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        rectangles = new int[102][102];
        visited = new boolean[102][102];
        for(int[] rec : rectangle){
            int lc = rec[0] *2;
            int lr = rec[1] *2;
            int rc = rec[2] *2;
            int rr = rec[3] *2;
            for(int i =lc; i<= rc; i++){
                for(int j = lr; j <= rr; j++){
                    if(rectangles[j][i] == 2) continue;
                    rectangles[j][i] = 2;
                    if(i==lc||i==rc||j==lr||j==rr){
                        rectangles[j][i]=1;
                    }
                }
            }
        }
        
        int answer = bfs(characterY*2, characterX*2, itemY*2, itemX*2)/2;
        
        return answer;
    }
    static int bfs(int row, int col, int itemRow, int itemCol){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row,col, 0});
        visited[row][col] = false;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int r = node[0];
            int c = node[1];
            int d = node[2];
            if(r == itemRow && c == itemCol){
                return d;
            }
            for(int i = 0; i<4; i++){
                int newR = r + moveR[i];
                int newC = c + moveC[i];
                if(rectangles[newR][newC]==1 && !visited[newR][newC]){
                    visited[newR][newC] = true;
                    queue.add(new int[]{newR, newC, d+1});
                }
            }
        }
        return -1;
    }
}