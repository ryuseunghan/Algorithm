import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long first = 1; 
        long last = (long) times[0] * n; 
        long mid;

        while (first <= last) {
            mid = (first + last) / 2;
            long count = check(mid, times);  
            if (count < n) {
                first = mid + 1;
            } else {
                last = mid - 1;
            }
        }
        return first;  
    }

    static long check(long mid, int[] times) { 
        long count = 0;
        for (int x : times) {
            count += mid / x;
        }
        return count;
    }
}
