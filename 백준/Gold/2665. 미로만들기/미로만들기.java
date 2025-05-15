import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] moveR = new int[]{-1, 0, 1, 0};
    static int[] moveC = new int[]{0, 1, 0, -1};
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n+1][n+1];
        int[][] distance = new int[n+1][n+1];
        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=n; j++){
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[1][1] = 0;
        for(int i = 1; i <=n; i++){
            String[] str = br.readLine().split("");
            int j = 1;
            for(String ch : str){
                if(Integer.parseInt(ch) == 1) graph[i][j] = 0;
                else graph[i][j] = 1;
                j++;
            }
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,1, 0));
        
        while(!pq.isEmpty()){
            Node node = pq.poll();
            int row = node.row;
            int col = node.col;
            int weight = node. weight;
            for(int i = 0; i < 4 ; i ++){
                int newR = row + moveR[i];
                int newC = col + moveC[i];
                if(inGraph(newR, newC) && distance[newR][newC] > distance[row][col] + graph[newR][newC]){
                    distance[newR][newC] = distance[row][col] + graph[newR][newC];
                    pq.offer(new Node(newR,newC, distance[newR][newC]));
                }
            }
        }
        System.out.println(distance[n][n]);
    }
        
    static boolean inGraph(int row, int col){
        if(row >0 && row <= n && col > 0 && col <=n) return true;
        return false;
    }
    static class Node implements Comparable<Node>{
        int row, col, weight;
        Node(int row, int col, int weight){
            this.row = row;
            this.col = col;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o){
            return this.weight - o.weight;
        }
    }
}