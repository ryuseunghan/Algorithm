import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] parent;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken()); // 테케 수
        for(int t = 1; t <= T; t++){
            System.out.println("Scenario "+t+":");
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 유저수
            parent = new int[n]; // 작은 수가 부모로
            for(int i = 0; i < n ; i++){
                parent[i] = i;
            }
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken()); // 관계수
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                union(a, b);
            }
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken()); // 관계수
            for(int p = 0; p < P; p++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a) == find(b)) System.out.println(1);
                if(find(a) != find(b)) System.out.println(0);
            }
            System.out.println();
        }        
    }
    static int find(int a){
        if(a == parent[a]) return parent[a];
        else return parent[a] = find(parent[a]);
    }
    static void union(int a, int b){
        int pa = find(a);
        int pb = find(b);
        if(pa < pb){
            parent[pb] = pa;
        }else{
            parent[pa] = pb;
        }
    }
}