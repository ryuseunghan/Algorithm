import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        for(int i=1; i<N+1; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int se = Integer.parseInt(st.nextToken());
            int ee = Integer.parseInt(st.nextToken());
            graph[se].add(ee);
            graph[ee].add(se);
        }
        int count = 0;
        for(int i = 1; i < N+1; i++){
            if(!visited[i]) count ++;
            DFS(i);
        }
        System.out.println(count);
    }
    static void DFS(int i){
        if(visited[i]) return;
        visited[i]=true;
        for(int j : graph[i]){
            DFS(j);
        }
    }
}
