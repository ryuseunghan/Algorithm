import java.util.*;
class Solution {
    static Map<Integer, Integer> result = new HashMap<>();
    static Map<Integer, Integer> map = new HashMap<>();
    public int[] solution(int[] fees, String[] records) {
        for(String record : records){
            check(record);
        }
        for(int num : map.keySet()){
            int intime = map.get(num);
            result.put(num, result.getOrDefault(num, 0)+23*60+59-intime);
        }
        int[] answer = new int[result.size()];
        int i = 0;
        Integer[] array = result.keySet().toArray(new Integer[result.size()]);
        Arrays.sort(array);
        for(int num : array){
            if(result.get(num) > fees[0]){
                answer[i]= fees[1] + ((result.get(num)-fees[0])/ fees[2] ) * fees[3];
                if((result.get(num)-fees[0])% fees[2] > 0){
                    answer[i] += fees[3];
                }
            }else{
                answer[i]= fees[1];
            }
            
            i++;
        }

        return answer;
    }
    static void check(String str){
        int time = Integer.parseInt(str.substring(0,2))*60 + Integer.parseInt(str.substring(3,5));
        int num = Integer.parseInt(str.substring(6,10));
        String inout = str.substring(11);
        if(inout.equals("IN") ){
            map.put(num, time);
        }
        if(inout.equals("OUT")){
            int intime = map.get(num);
            result.put(num, result.getOrDefault(num, 0)+time-intime);
            map.remove(num);
        }
    }
}