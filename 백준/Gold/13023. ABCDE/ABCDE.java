import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static boolean[] visited;
    static int flag;
    static ArrayList<Integer>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i< m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
            graph[e].add(s);
        }
        for(int i = 0; i < n; i++){
            visited = new boolean[n];
            DFS(i, 0);
        }
        System.out.println(flag);

    }
    static void DFS(int cur, int count){
        if(visited[cur]) return;
        visited[cur] = true;
        if(count ==4) {
            flag =1;
            return;
        }
        for(int i: graph[cur]){
            DFS(i, count + 1);
        }
        visited[cur] = false;
    }
}
