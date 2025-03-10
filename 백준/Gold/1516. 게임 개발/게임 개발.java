import java.util.*;

class Main {
    static List<List<Integer>> in = new ArrayList<>();
    static List<List<Integer>> out = new ArrayList<>();
    static int[] originDistance;
    static int[] distance;
    static int[] inDegree; // 위상 정렬을 위한 진입 차수 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        originDistance = new int[N + 1];
        distance = new int[N + 1];
        inDegree = new int[N + 1]; // 진입 차수 배열 추가

        for (int i = 0; i <= N; i++) {
            in.add(new ArrayList<>());
            out.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            int num = sc.nextInt();
            distance[i] = num;
            originDistance[i] = num;

            num = sc.nextInt();
            while (num != -1) {
                in.get(i).add(num);
                out.get(num).add(i);
                inDegree[i]++; // 진입 차수 증가
                num = sc.nextInt();
            }
        }

        // 위상 정렬을 위한 Queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) { // 진입 차수가 0이면 처리
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int next : out.get(node)) {
                inDegree[next]--; // 진입 차수 감소
                distance[next] = Math.max(distance[next], distance[node] + originDistance[next]);
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        // 최종 거리 값 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(distance[i]);
        }
    }
}
