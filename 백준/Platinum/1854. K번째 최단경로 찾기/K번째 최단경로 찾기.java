import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException{
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 도시 개수
        int m = sc.nextInt(); // 도로 개수
        int k = sc.nextInt(); // 목표

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        graph = new ArrayList[n+1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        PriorityQueue<Integer>[] distance = new PriorityQueue[n+1];

        for(int i = 0; i <= n; i++){
            graph[i] = new ArrayList<>();
            distance[i] = new PriorityQueue<>(k, new Comparator<Integer>(){
                @Override
                public int compare(Integer o1, Integer o2){
                    return o2 - o1;
                }
            });
        }
        for(int i = 0; i < m; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start].add(new Node(end, weight));
        }
        pq.offer(new Node(1, 0));
        distance[1].add(0);
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(Node adjNode : graph[node.idx]){
                int newDistance = node.weight + adjNode.weight;
     
                if(distance[adjNode.idx].size() < k){
                    pq.offer(new Node(adjNode.idx, newDistance));
                    distance[adjNode.idx].offer(newDistance);
                }else if(newDistance < distance[adjNode.idx].peek()){
                    distance[adjNode.idx].poll();
                    pq.offer(new Node(adjNode.idx, newDistance));
                    distance[adjNode.idx].offer(newDistance);
                }
            }
        }
        for(int i = 1; i <= n; i++){
            if(distance[i].size() == k){
                bw.write(distance[i].peek() + "\n");
            }else{
                bw.write(-1 + "\n");
            }
        }
        bw.flush();
    }
    static class Node implements Comparable<Node>{
        int idx;
        int weight;
        public Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {return this.weight - o.weight;} // 오름차순
    }

}