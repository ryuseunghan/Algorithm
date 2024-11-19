import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];

        for(int i=1; i< N+1; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for(int i=1; i< N+1; i++){
            sort(graph[i]);
        }
        visited = new boolean[N+1];
        DFS(V);
        System.out.println();

        visited = new boolean[N+1];
        BFS(V);
    }
    static void DFS(int n){
        visited[n] = true;
        System.out.print(n+" ");
        for(int j: graph[n]){
            if(!visited[j]){
                DFS(j);
            }
        }
    }
    static void BFS(int n){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(n);
        visited[n] = true;
        while(!queue.isEmpty()){
            int popped = queue.poll();
            System.out.print(popped+" ");
            for(int j:graph[popped]){
                if(!visited[j]){
                    queue.add(j);
                    visited[j] = true;
                }
            }
        }
    }
}