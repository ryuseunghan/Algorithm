import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    static ArrayList<Node>[] graph;
    static boolean[] visited;
    static Queue<Integer> queue;
    static int[] distance;
    static int Max;
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       int v = Integer.parseInt(st.nextToken());
        graph = new ArrayList[v+1];
        for(int i = 1; i <= v; i++){
            graph[i] = new ArrayList<Node>();
        }
        for(int i = 0; i < v; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int e = Integer.parseInt(st.nextToken());
                if(e == -1){
                    break;
                }
                int w = Integer.parseInt(st.nextToken());
                graph[s].add(new Node(e,w));
                graph[e].add(new Node(s,w));
            }
        }
        distance = new int[v+1];
        visited = new boolean[v+1];
        BFS(1);
        Max = 0;
        int index = 1;
        for(int i=2; i <=v; i++){
            if(Max<distance[i]){
                Max = distance[i];
                index = i;
            }
        }
        distance = new int[v+1];
        visited = new boolean[v+1];

        BFS(index);
        Arrays.sort(distance);
        System.out.println(distance[v]);
    }
    static void BFS(int n){
        visited[n]= true;
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(n);
        while(!queue.isEmpty()){
            int popped = queue.poll();
            for(Node node : graph[popped]){
                if (!visited[node.num]){
                    visited[node.num] = true;
                    queue.offer(node.num);
                    distance[node.num] = node.weight + distance[popped];
                }
            }
        }

    }
    static class Node{
        int num;
        int weight;
        public Node(int num, int weight){
            this.num = num;
            this.weight = weight;
        }
    }

}