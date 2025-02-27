import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x: scoville){
            pq.add(x);
        }
        int answer = 0;

        while(true){
            int lowest = pq.poll();
            if(lowest >= K){
                break;
            }
            if(pq.isEmpty()){
                return -1;
            }
            int secondLowest = pq.poll();
            pq.add(lowest + 2*secondLowest);
            answer++;
        }
        
        return answer;
    }
}