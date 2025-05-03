import java.util.*;
class Solution {
    static Set<Integer> set = new HashSet<>();
    public int solution(int[] elements) {
        int len = elements.length;
        // 길이 i
        for(int i = 1; i <= len ; i++){
            int sum = 0;
            // 초기 원소 합
            for(int j = 0; j < i; j++){
                sum += elements[j];
                set.add(sum);
            }
            if(i!= len){
                // set에 넣어주기
                for(int j = i; j < len-1 + i; j++){
                    int idx = j % len;
                    sum += elements[idx];
                    sum -= elements[(idx - i+ len)%len];
                    set.add(sum);
                }
            }
        }
        return set.size();
    }
}