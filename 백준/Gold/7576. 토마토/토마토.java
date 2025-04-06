import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int[] move_r = new int[]{1,0,-1,0};
    static int[] move_c = new int[]{0,1,0,-1};
    static int n, m;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n+1][m+1];
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            st =  new StringTokenizer(br.readLine());
            for(int j = 1; j <= m; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                if(graph[i][j] == 1){
                    q.offer(new int[]{i, j, 0});
                }
            } 
        }
        int date = 0;
        while(!q.isEmpty()){
            int[] node = q.poll();
            date = Math.max(date, node[2]);
            for(int i = 0; i< 4; i++){
                int newr = node[0] + move_r[i];
                int newc = node[1] + move_c[i];
                if(ingraph(newr, newc)){
                    q.offer(new int[]{newr, newc, node[2] + 1});
                    graph[newr][newc] = 1;
                }
            }
        }
        boolean flag = false;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(graph[i][j] == 0) {
                    flag = true;
                    break;
                }
            }
            if(flag) break;
        }
        if(flag) System.out.println(-1); 
        else System.out.println(date);
       
    }
    static boolean ingraph(int r, int c){
        if(r > 0 && r <= n && c > 0 && c <= m && graph[r][c] == 0) return true;
        return false;
    }

}
/*
    정수 1은 익은 토마토, 정수 0은 익지 않은 토마토, 정수 -1은 토마토
*/
