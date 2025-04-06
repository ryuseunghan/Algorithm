import java.util.*;
import java.io.*;

public class Main {
    static int[][] graph;
    static int[] move_r = {1, 0, -1, 0};
    static int[] move_c = {0, 1, 0, -1};
    static int n, m;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken()); // 열
        n = Integer.parseInt(st.nextToken()); // 행
        graph = new int[n + 1][m + 1];

        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
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
            int r = node[0], c = node[1], d = node[2];
            date = Math.max(date, d);
            for(int i = 0; i < 4; i++){
                int newr = r + move_r[i];
                int newc = c + move_c[i];
                if(ingraph(newr, newc)){
                    graph[newr][newc] = 1; // 방문 체크를 여기서!
                    q.offer(new int[]{newr, newc, d + 1});
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

        System.out.println(flag ? -1 : date);
    }

    static boolean ingraph(int r, int c){
        return r > 0 && r <= n && c > 0 && c <= m && graph[r][c] == 0;
    }
}
