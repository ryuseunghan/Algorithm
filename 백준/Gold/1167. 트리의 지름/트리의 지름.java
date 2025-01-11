import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<int[]>[] tree;
    static int[] visited;
    static int[] max = {0, 0};
    static Queue<Integer> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken());
        tree = new ArrayList[v+1];
        visited = new int[v+1];
        for (int i=1; i <= v; i++){
            visited[i] = -1;
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            tree[start] = new ArrayList();
            while(true){
                int num = Integer.parseInt(st.nextToken());
                if(num == -1) break;
                int num2 = Integer.parseInt(st.nextToken());
                tree[start].add(new int[] {num, num2});
            }
        }
        queue = new LinkedList<>();
        queue.add(1);
        visited[1] = 0;
        int node = BFS();
        queue = new LinkedList<>();
        visited = new int[v+1];
        queue.add(node);
        for (int i=1; i <= v; i++) visited[i] = -1;
        visited[node] = 0;
        BFS();
        System.out.println(max[1]);
    }
    static int BFS(){
        while(!queue.isEmpty()){
            int node = queue.poll();
            for (int[] i : tree[node]) {
                int newNode = i[0];
                int distance = i[1];
                if(visited[newNode] ==-1){
                    visited[newNode] = visited[node] + distance;
                    queue.add(newNode);
                    if(max[1] < visited[newNode]){
                        max[0] = newNode;
                        max[1] = visited[newNode];
                    }
                }

            }
        }
        return max[0];

    }

}


