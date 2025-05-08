import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Node>[] graph;
    static int[] distance;
    static int[] fromx;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 마을 개수, 학생 수
        int m = Integer.parseInt(st.nextToken()); // 단방향 도로
        int x = Integer.parseInt(st.nextToken()); // 축제
        graph = new ArrayList[n+1];
        distance = new int[n+1];
        fromx = new int[n+1];
        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 1; i<=m;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, w));
        }

        // x에서의 각 거리
        // 거리 초기화
        Arrays.fill(fromx, Integer.MAX_VALUE);
        fromx[x] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(x, 0));
        while(!pq.isEmpty()){
            Node node = pq.poll();
            for(Node adjNode : graph[node.idx]){
                if(fromx[adjNode.idx] > fromx[node.idx]+ adjNode.weight){
                    fromx[adjNode.idx] = fromx[node.idx]+ adjNode.weight;
                    pq.offer(new Node(adjNode.idx, fromx[adjNode.idx]));
                }
            }
        }
        int answer = 0;
        // 각 도시에서 출발 시 최단 거리
        for(int i = 1; i <= n; i++){
            if(i == x) continue;
            // 거리 초기화
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[i] = 0;
            pq = new PriorityQueue<>();
            pq.offer(new Node(i, 0));
            while(!pq.isEmpty()){
                Node node = pq.poll();
                for(Node adjNode : graph[node.idx]){
                    if(distance[adjNode.idx] > distance[node.idx]+ adjNode.weight){
                        distance[adjNode.idx] = distance[node.idx]+ adjNode.weight;
                        pq.offer(new Node(adjNode.idx, distance[adjNode.idx]));
                    }
                }
            }
            answer = Math.max(answer, distance[x]+fromx[i]);
        }
        System.out.println(answer);
    }

    static class Node implements Comparable<Node>{
        int idx, weight;
        Node(int idx, int weight){
            this.idx = idx;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}