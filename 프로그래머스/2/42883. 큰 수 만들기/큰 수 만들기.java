import java.util.*;
class Solution {
    public String solution(String number, int k) {
        int len = number.length();
        k = len - k;
        Deque<Integer> deque = new LinkedList<>();
        String answer = "";
        int idx = 0;
        for(int i =0; i<len; i++){
            int num = Integer.parseInt(number.substring(i, i+1));
            while(!deque.isEmpty() && deque.getLast() < num)deque.pollLast();
            if(deque.isEmpty() || deque.getLast() >= num) deque.offerLast(num);
            if(i - len + k - idx == 0){
                answer = answer.concat(String.valueOf(deque.pollFirst()));
                idx++;
            }
            
        }
        return answer;
    }
}