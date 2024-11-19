import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    static int[][] graph;
    static boolean[][] visited;
    static int[] move_x ={1,-1,0,0};
    static int[] move_y ={0,0,1,-1};
    static Deque<Integer> deque;
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N+1][M+1];

        for(int i=1; i< N+1; i++){
            st = new StringTokenizer(br.readLine());
            String line = st.nextToken();
            for(int j= 1; j<M+1;j++){
                graph[i][j] =Integer.parseInt(line.substring(j-1, j));
            }
        }
        visited = new boolean[N+1][M+1];
        BFS();
    }
    static void BFS(){
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{1,1});
        visited[1][1] = true;
        while(!queue.isEmpty()){
            int[] popped = queue.poll();
            for(int i =0; i < 4; i++){
                int x = popped[0]+ move_x[i];
                int y = popped[1]+ move_y[i];
                if(x>0 && x< N+1 && y>0 && y<M+1){
                    if(!visited[x][y] && graph[x][y]!=0){
                        queue.offer(new int[]{x,y});
                        graph[x][y] = (graph[popped[0]][popped[1]]+1);
                        visited[x][y] = true;
                    }
                }

            }
        }
        System.out.println(graph[N][M]);
    }
}