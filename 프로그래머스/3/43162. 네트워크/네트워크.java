import java.util.*;
class Solution {
    static List<Integer>[] graph;
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        graph = new ArrayList[n];
        visited = new boolean[n];
        for(int i=0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0; i < n; i++){
            for(int j=i+1; j < n; j++){
                if(computers[i][j] == 1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(visited[i])continue;
            visited[i] = true;
            queue.offer(i);
            ans++;
            while(!queue.isEmpty()){
                int num = queue.poll();
                for(int elem : graph[num]){
                    if(!visited[elem]){
                        visited[elem] = true;
                        queue.offer(elem);
                    }
                }
            }
        }
        
        return ans;
    }
}