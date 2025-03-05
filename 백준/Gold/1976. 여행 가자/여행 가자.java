import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    // Find: 부모 노드 찾기 (경로 압축)
    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    // Union: 두 집합 합치기
    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;  // 한 쪽을 다른 쪽의 부모로 설정
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine().trim());  // 도시 수
        int m = Integer.parseInt(br.readLine().trim());  // 여행 계획에 포함된 도시 수

        parent = new int[n + 1];  // 1-based 인덱싱
        for (int i = 1; i <= n; i++) {
            parent[i] = i;  // 초기화 (자기 자신을 부모로 설정)
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1) {
                    union(i, j);  // 연결된 도시들은 같은 집합으로 묶기
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int startCity = Integer.parseInt(st.nextToken());
        int root = find(startCity);

        boolean possible = true;
        for (int i = 1; i < m; i++) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (find(nextCity) != root) {  // 다른 집합이면 여행 불가능
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "YES" : "NO");
    }
}
