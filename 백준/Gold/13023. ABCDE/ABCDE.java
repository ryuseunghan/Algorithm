import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean visited[];
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N];
        visited = new boolean[N];

        for(int i = 0; i<N; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        flag = false;

        for(int i = 0; i<N; i++){
            Arrays.fill(visited, false);
            DFS(i, 1);
            if(flag) break;
        }
        System.out.println(flag ? 1 : 0);
    }
    static void DFS(int n, int count){
        visited[n] = true;
        if(count == 5){
            flag = true;
            return;
        }
        for(int j : graph[n]){
            if(!visited[j]){ // vistied x
                DFS(j, count + 1);
                if (flag) return;
            }
        }
        visited[n] = false; // 백트래킹
    }
}