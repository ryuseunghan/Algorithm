import java.io.*;
import java.util.*;

class Main {
    static int n, m, k;
    static List<Edge>[] graph;
    static long[] distance;

    public static void main(String[] args) throws IOException {
        // 빠른 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        graph = new ArrayList[n + 1];
        distance = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Long.MAX_VALUE;
        }

        // 간선 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[end].add(new Edge(start, weight)); // 역방향 그래프
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        // 면접장 입력
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            int idx = Integer.parseInt(st.nextToken());
            distance[idx] = 0;
            pq.offer(new Edge(idx, 0));
        }

        // 다익스트라
        while (!pq.isEmpty()) {
            Edge node = pq.poll();

            if (distance[node.idx] < node.weight) continue;

            for (Edge adj : graph[node.idx]) {
                if (distance[adj.idx] > distance[node.idx] + adj.weight) {
                    distance[adj.idx] = distance[node.idx] + adj.weight;
                    pq.offer(new Edge(adj.idx, distance[adj.idx]));
                }
            }
        }

        long max = -1;
        int maxIdx = -1;

        for (int i = 1; i <= n; i++) {
            if (distance[i] > max) {
                max = distance[i];
                maxIdx = i;
            }
        }

        System.out.println(maxIdx);
        System.out.println(max);
    }

    static class Edge implements Comparable<Edge> {
        int idx;
        long weight;

        Edge(int idx, long weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return Long.compare(this.weight, o.weight); // 안전한 long 비교
        }
    }
}
