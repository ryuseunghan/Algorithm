import java.util.*;
class Solution {
    static int[][] graph;
    public int[] solution(int rows, int columns, int[][] queries) {
        graph = new int[rows+2][columns+2];
        int a= 1;
        for(int i = 1; i<= rows; i++){
            for(int j = 1; j<= columns; j++){
                graph[i][j] = a++;
            }
        }
        int[] result = new int[queries.length];
        int idx = 0;
        for(int[] arr : queries){
            result[idx++] = rotate(arr[0], arr[1],arr[2],arr[3]);
        }
        return result;
    }
    static int rotate(int r1, int c1, int r2, int c2){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int r, c;
        int partial_first;
        int partial_second;
        
        partial_first = graph[r1][c2];
        pq.offer(partial_first);
        System.out.println(partial_first);
        for(int j = c2-1; j>=c1; j--){
            graph[r1][j+1] = graph[r1][j];
            pq.offer(graph[r1][j]);
        }
        
        partial_second = graph[r2][c2];
        pq.offer(partial_second);
        System.out.println(partial_second);
        
        for(int i = r2-1; i >= r1; i--){
            graph[i+1][c2] = graph[i][c2];
            pq.offer(graph[i][c2]);
        }
        graph[r1+1][c2] = partial_first;
        partial_first = graph[r2][c1];
        pq.offer(partial_first);
        System.out.println(partial_first);
        
        for(int j = c1+1; j <= c2; j++){
            graph[r2][j-1] = graph[r2][j];
            pq.offer(graph[r2][j]);
        }
        graph[r2][c2-1] = partial_second;
        
        for(int i = r1; i < r2; i++){
            graph[i][c1] = graph[i+1][c1];
            pq.offer(graph[i+1][c1]);
        }
        graph[r2-1][c1] = partial_first;
        
        return pq.poll();  
    }
}