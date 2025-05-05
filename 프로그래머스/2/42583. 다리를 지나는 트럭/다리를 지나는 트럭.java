import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int truckNum = truck_weights.length;
        int num =0;
        int time = 0;
        int weightSum = 0;
        Queue<Truck> que = new LinkedList<>();
        while(num != truckNum || !que.isEmpty()){
            // 시간 흐름
            time++;
            // que 상에 다리를 지난 트럭 삭제 처리
            if(!que.isEmpty()){
                if(que.peek().time == time){
                    weightSum -= que.poll().weight;
                }
            }
            
            // 현재 weightSum + truck_weight이 weight보다 작을 시 트럭을 queue에 집어넣음
            if(num < truckNum && weightSum + truck_weights[num] <= weight){
                que.offer(new Truck(bridge_length+time, truck_weights[num]));
                weightSum += truck_weights[num];
                num++;
            }
        }
        return time;
    }
    static class Truck{
        int time;
        int weight;
        Truck(int time, int weight){
            this.time = time;
            this.weight = weight;
        }
    }
}