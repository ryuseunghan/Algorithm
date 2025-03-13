import java.util.*;
class Solution {
    static List<Node>[] graph;
    static int[] intensity;
    static Set summitSet = new HashSet();
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        graph = new ArrayList[n+1];
        intensity = new int[n+1];

        for(int x : summits){
            summitSet.add(x);
        }
        for(int i = 1; i <= n; i++){
            intensity[i] = Integer.MAX_VALUE;
            graph[i] = new ArrayList<>();
        }
        for(int[] path : paths){
            int start = path[0];
            int end = path[1];
            int distance = path[2];

            graph[start].add(new Node(end, distance));
            graph[end].add(new Node(start, distance));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        for(int x : gates){
            pq.add(new Node(x, 0));
            intensity[x] = 0;
        }
        int summitMax = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int currNode = node.idx;
            int currIntensity = node.distance;
            if(summitSet.contains(currNode)){
                summitMax = currIntensity;
                continue;
            }
            if(summitMax< currIntensity){
                break;
            }
            for(Node next : graph[currNode]){
                currIntensity = Math.max(intensity[currNode], next.distance);
                if(currIntensity < intensity[next.idx]){
                    intensity[next.idx] = currIntensity;
                    pq.add(new Node(next.idx, currIntensity));
                }
            }
        }
        int minIdx = 0;
        int min = Integer.MAX_VALUE;
        for(int i : summits){
            if(min > intensity[i]){
                minIdx = i;
                min = intensity[i];
            }else if(min == intensity[i]  && minIdx > i){
                minIdx = i;
            }
        }
        int[] answer = {minIdx, intensity[minIdx]};
        return answer;
    }
    static class Node implements Comparable<Node>{
        int idx, distance;
        public Node(int idx, int distance){
            this.idx = idx;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node o){
            return this.distance - o.distance;
        }
    }
}