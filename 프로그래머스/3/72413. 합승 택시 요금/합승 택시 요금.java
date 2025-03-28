import java.util.*;

class Solution {
    static List<Node>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];
        
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] fare : fares) {
            int c = fare[0];
            int d = fare[1];
            int f = fare[2];
            graph[c].add(new Node(d, f));
            graph[d].add(new Node(c, f));
        }

        int[] distFromS = dijkstra(s, n);
        int[] distFromA = dijkstra(a, n);
        int[] distFromB = dijkstra(b, n);

        int minCost = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if(distFromS[i] == Integer.MAX_VALUE || 
               distFromA[i] == Integer.MAX_VALUE || 
               distFromB[i] == Integer.MAX_VALUE) continue;

            int cost = distFromS[i] + distFromA[i] + distFromB[i];
            minCost = Math.min(minCost, cost);
        }

        return minCost;
    }

    private int[] dijkstra(int start, int n) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        distance[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (current.weight > distance[current.idx]) continue;

            for (Node adj : graph[current.idx]) {
                int nextDist = distance[current.idx] + adj.weight;
                if (nextDist < distance[adj.idx]) {
                    distance[adj.idx] = nextDist;
                    pq.offer(new Node(adj.idx, nextDist));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        int idx, weight;

        Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
}
