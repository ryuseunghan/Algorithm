import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] mover = new int[]{0, 1, 0, -1};
    static int[] movec = new int[]{1, 0, -1, 0};
    static HashMap<String, Integer> map = new HashMap<>();
    static int[][] graph;
    static boolean[][] visited;
    static int n;
    public static void main(String[] args) throws IOException{
        // 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        visited = new boolean[n+1][n+1];
        
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int k = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(!visited[i][j] && graph[i][j] == 1){
                    dfs(i, j, k);
                    k++;
                } 
            }
        }
        
        // queue에 대륙 끝단 넣어주기
        LinkedList<Queue<Node>> queueList = new LinkedList<>();
        for(int i = 0; i< k; i++){
            queueList.add(new LinkedList<>());
        }
        int q = 0;
        for(Queue<Node> queue : queueList){
            q++;
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(graph[i][j] == 1){
                        boolean flag = false;
                        for(int p = 0; p<4; p++){
                            if(inGraph(i+mover[p], j+movec[p])){
                                if(graph[i+mover[p]][j+movec[p]] == 0) flag = true;
                            }
                        }
                        if(flag) {
                            int cont = map.get(new StringBuilder().append(i).append(" ").append(j).toString());
                            if(q != cont) continue;
                            queue.offer(new Node(i, j, 0, cont));
                        }
                    }
                }
            }
        }

        // 대륙 끝단에서부터 bfs, 만약 다른 대륙 도착 시 최소 거리 갱신
        int min = 100000;
        for(Queue<Node> queue : queueList){
            visited = new boolean[n+1][n+1];
            while(!queue.isEmpty()){
                Node newNode = queue.poll();
                for(int i = 0; i < 4; i++){
                    int newRow = newNode.row + mover[i];
                    int newCol = newNode.col + movec[i];
                    
                    if(inGraph(newRow, newCol)){
                        if(graph[newRow][newCol] == 1 && newNode.start != map.get(new StringBuilder().append(newRow).append(" ").append(newCol).toString())){
                            
    
                            min = Math.min(newNode.distance, min);
                            continue;
                        }
                        if(graph[newRow][newCol] == 1 || visited[newRow][newCol]){
                            continue;
                        }
                        visited[newRow][newCol] = true;
                        queue.offer(new Node(newRow, newCol, newNode.distance +1, newNode.start));
                    }
                }
            }
        }
        System.out.println(min);
        
    }
    static boolean inGraph(int i, int j){
        if(i < 1 || i> n || j < 1 || j> n) return false;
        return true;
    }
    static class Node{
        int row, col, distance, start;
        Node(int row, int col, int distance, int start){
            this.row = row;
            this.col = col;
            this.distance = distance;
            this.start = start;
        }
    }
    static void dfs(int row, int col, int k){
        if(!visited[row][col] && graph[row][col] == 1){
            visited[row][col] = true;
            map.put(new StringBuilder().append(row).append(" ").append(col).toString(), k);
            for(int t =0; t < 4; t++){
                if(inGraph(row+mover[t], col + movec[t])){
                    dfs(row+mover[t], col + movec[t], k);
                }
            }
        }
    }
}