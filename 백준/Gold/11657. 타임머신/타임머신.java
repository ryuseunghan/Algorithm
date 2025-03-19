import java.util.*;
import java.io.*;

class Main {
    static class Edge {
        int from, to, weight;
        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of nodes
        int M = sc.nextInt(); // Number of edges

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        List<Edge> graph = new ArrayList<>();
        long[] distance = new long[N + 1];
        Arrays.fill(distance, Long.MAX_VALUE);
        
        // Reading edges
        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph.add(new Edge(start, end, weight));
        }
        
        // Bellman-Ford Algorithm
        distance[1] = 0;
        boolean hasCycle = false;

        for (int i = 1; i <= N; i++) {
            for (Edge edge : graph) {
                if (distance[edge.from] != Long.MAX_VALUE && distance[edge.to] > distance[edge.from] + edge.weight) {
                    distance[edge.to] = distance[edge.from] + edge.weight;
                    // If a change occurs in N-th iteration, negative cycle exists
                    if (i == N) {
                        hasCycle = true;
                    }
                }
            }
        }

        // Output results
        if (hasCycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= N; i++) {
                bw.write((distance[i] == Long.MAX_VALUE ? "-1" : distance[i]) + "\n");
            }
            bw.flush(); // Flush once after writing all results
        }
    }
}
