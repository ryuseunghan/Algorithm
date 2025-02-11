import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        parent = new int[N+1];
        for(int i=0; i<=N; i++){
            parent[i] = i;
        }
        for(int i=0; i< M; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(num == 0){
                union(a, b);
            }else{
                if(check(a,b)) bw.write("YES"+"\n");
                else bw.write("NO"+"\n");
            }
        }
        bw.flush();

    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);
        if(a == b){
            return;
        }
        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }
    }
    static boolean check(int a, int b){
        return find(a) == find(b);
    }
    public static int find(int x) {
        if(parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
}
