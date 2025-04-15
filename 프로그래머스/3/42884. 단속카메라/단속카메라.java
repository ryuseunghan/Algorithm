import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));
        int answer = 0;
        int end = -30000;
        for (int[] route : routes) {
            if (route[0] > end) {
                answer++;
                end = route[1]; // 현재 차량의 진출 지점에 카메라 설치
            }
        }
        return answer;
    }
}