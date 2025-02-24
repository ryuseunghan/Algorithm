import java.util.*;

class Solution {
    static List<List<Integer>> graph;
    static Queue<Node> queue;
    static boolean[] visited;
    static List<Integer> result = new ArrayList<>();
    public int solution(int n, int[][] edge) {
        queue = new LinkedList<>();
        visited = new boolean[n+1];
        graph = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edge.length; i++){
            graph.get(edge[i][0]).add(edge[i][1]);
            graph.get(edge[i][1]).add(edge[i][0]);
        }
        Node node = new Node(1, 0);
        bfs(node);
        return result.size();
    }
    static void bfs(Node start){
        queue = new LinkedList<>();
        queue.add(start);
        visited[start.n] = true;
        int max = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            int nodeNum = node.n;
            int distance = node.distance;

            if(max < distance){
                max = distance;
                result = new ArrayList<>();
            }
            
            if(max == distance){
                result.add(nodeNum);
            }

            for(int x : graph.get(nodeNum)){
                if(!visited[x]){
                    visited[x] = true; // 방문 처리 (중복 방지)
                    queue.add(new Node(x, distance+1));
                }
            }
        }
    }
    static class Node{
        int n;
        int distance;
        public Node(int n, int distance){
            this.n = n;
            this.distance = distance;
        }
    }
}