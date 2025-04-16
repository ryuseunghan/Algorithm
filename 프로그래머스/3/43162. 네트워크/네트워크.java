import java.util.*;

class Solution {
    static int[] parent;

    public int solution(int n, int[][] computers) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // 각 컴퓨터는 자신을 부모로 설정
        }

        // Union-Find를 사용하여 연결된 컴퓨터들을 그룹화
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {  // j는 i보다 더 큰 값에서 시작
                if (computers[i][j] == 1) {
                    union(i, j);  // 연결된 컴퓨터들끼리 union 수행
                }
            }
        }

        // 각 네트워크(연결된 그룹)의 개수를 구하기 위해 부모가 서로 다른 노드를 Set에 저장
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(i));  // 각 컴퓨터의 루트 부모를 찾아서 집합에 추가
        }

        // 서로 다른 루트 부모의 개수가 네트워크의 개수
        return set.size();
    }

    // union 연산: 두 컴퓨터를 연결
    static void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);

        // 부모가 다르면 더 작은 번호를 부모로 설정
        if (rootI != rootJ) {
            if (rootI < rootJ) {
                parent[rootJ] = rootI;
            } else {
                parent[rootI] = rootJ;
            }
        }
    }

    // find 연산: 부모를 찾고 경로 압축
    static int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);  // 경로 압축
        }
        return parent[i];
    }
}
