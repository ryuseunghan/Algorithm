import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static List<Node>[] graph;
    static int[] distance;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        
        graph = new ArrayList[N+1];
        distance = new int[N+1];
        
        for(int i = 1; i<= N; i++){
            distance[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i< M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start].add(new Node(end, weight));
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int nodeIdx = node.idx;
            int nodeWeight = node.weight;

            if (nodeWeight > distance[nodeIdx]) continue;
            
            for(Node newNode : graph[nodeIdx]){
                int newDistance = distance[nodeIdx] + newNode.weight;
                if(distance[newNode.idx] > distance[nodeIdx] + newNode.weight){
                    if(newDistance > distance[end]) continue;
                    distance[newNode.idx] = newDistance;
                    pq.offer(new Node(newNode.idx, distance[newNode.idx]));
                }
            }
        }
        System.out.println(distance[end]);
    }
    static class Node implements Comparable<Node>{
        int idx;
        int weight;
        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight; //오름차순
        }
    }
}