import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Node>[] graph;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        int E = sc.nextInt();
        int start = sc.nextInt();
        graph = new ArrayList[V+1];
        distance = new int[V+1];
        for(int i = 0; i <= V; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i < E; i++){
            int s = sc.nextInt();
            int e = sc.nextInt();
            int d = sc.nextInt();
            graph[s].add(new Node(e, d));
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node newNode = pq.poll();
            for(Node adjNode : graph[newNode.idx]){
                if(distance[adjNode.idx] > newNode.distance + adjNode.distance){
                    distance[adjNode.idx] = newNode.distance + adjNode.distance;
                    pq.add(new Node(adjNode.idx, distance[adjNode.idx]));
                }
            }
        }
        for(int i = 1; i <= V; i++){
            if(distance[i] != Integer.MAX_VALUE){
                System.out.println(distance[i]);
            }else{
                System.out.println("INF");
            }

        }

    }
    static class Node implements Comparable<Node>{
        int idx;
        int distance;
        Node(int idx, int distance){
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o){
            return this.distance - o.distance;
        }
    }
}