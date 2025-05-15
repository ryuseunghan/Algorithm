import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static int[] distance;
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        distance = new int[n+1];
        graph = new ArrayList[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }
        for(int[] road : roads){
            int start = road[0];
            int end = road[1];
            graph[start].add(end);
            graph[end].add(start);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(destination, 0));
        distance[destination] = 0;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int end = node.end;
            int weight = node.weight;
            for(int adjNode : graph[end]){
                if(distance[adjNode] > distance[end] + 1){
                    distance[adjNode] = distance[end] + 1;
                    pq.offer(new Node(adjNode, distance[adjNode]));
                }
            }
        }
        int[] answer = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            if(distance[sources[i]] == Integer.MAX_VALUE){
                answer[i] = -1;
                continue;
            }
            answer[i] = distance[sources[i]];
        }
        return answer;
    }
    static class Node implements Comparable<Node>{
        int end, weight;
        Node(int end, int weight){
            this.end = end;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}