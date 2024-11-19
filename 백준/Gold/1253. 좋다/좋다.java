import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        long[] array = new long[N];
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        // 배열 입력
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(stringTokenizer.nextToken());
        }

        // 배열 정렬
        Arrays.sort(array);

        int count = 0;

        // 각 원소를 '좋은 수'인지 검사
        for (int k = 0; k < N; k++) {
            long target = array[k];
            int i = 0;
            int j = N - 1;

            // 투 포인터 사용
            while (i < j) {
                if (i == k) {
                    i++; // k와 같은 위치는 건너뜀
                    continue;
                }
                if (j == k) {
                    j--; // k와 같은 위치는 건너뜀
                    continue;
                }

                long sum = array[i] + array[j];

                if (sum == target) {
                    count++;
                    break; // 한 번 발견하면 종료 (중복 제거)
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
