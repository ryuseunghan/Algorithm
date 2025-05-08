import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static List<Node>[] graph;
    static int[] distance;
    static PriorityQueue<Node> pq;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테스트 케이스
        for(int t = 0 ; t < T; t++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호
            graph = new ArrayList[n+1];
            distance = new int[n+1];
            for(int i = 1; i <= n; i++){
                graph[i] = new ArrayList<>();
            }
            for(int i = 1; i<=d;i++){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());
                // graph[s].add(new Node(e, w));
                graph[e].add(new Node(s, w));
            }
    
            // 거리 초기화
            Arrays.fill(distance, Integer.MAX_VALUE);
            distance[c] = 0;
            pq = new PriorityQueue<>();
            pq.offer(new Node(c, 0));
            while(!pq.isEmpty()){
                Node node = pq.poll();
                for(Node adjNode : graph[node.idx]){
                    if(distance[adjNode.idx] > distance[node.idx]+ adjNode.weight){
                        distance[adjNode.idx] = distance[node.idx]+ adjNode.weight;
                        pq.offer(new Node(adjNode.idx, distance[adjNode.idx]));
                    }
                }
            }
            int num = 0;
            int max = 0;
            for(int i = 1; i <= n; i++){
                if(distance[i] != Integer.MAX_VALUE){
                    num ++;
                    max = Math.max(max, distance[i]);
                }
            }
            System.out.println(num+" "+max);
        }
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