import java.util.*;
import java.io.*;

class Main {
    static List<int[]>[] graph;
    static int[] reverse;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        graph = new ArrayList[n + 1];
        reverse = new int[n + 1];
        distance = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            distance[i] = Integer.MAX_VALUE;
        }

        for (int i = 0; i < m; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            graph[start].add(new int[]{end, weight});
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        // Dijkstra with PriorityQueue
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        distance[start] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int s = current[0];
            int dist = current[1];

            if (dist > distance[s]) continue; // 이미 더 짧은 거리로 처리된 경우

            for (int[] route : graph[s]) {
                int e = route[0];
                int w = route[1];

                if (distance[e] > distance[s] + w) {
                    distance[e] = distance[s] + w;
                    reverse[e] = s;
                    pq.offer(new int[]{e, distance[e]});
                }
            }
        }

        System.out.println(distance[end]);
        Stack<Integer> stack = new Stack<>();
        int node = end;
        while (node != start) {
            stack.push(node);
            node = reverse[node];
        }
        stack.push(start);

        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            bw.write(stack.pop() + " ");
        }
        bw.flush();
    }
}
