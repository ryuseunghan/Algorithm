import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> answer = new ArrayList<>();
        for(String r : record){
            String[] rs = r.split(" ");
            if(rs[0].equals("Enter") ){
                map.put(rs[1], rs[2]);
                String id = rs[1];
                result.add("Enter "+id);
            }else if(rs[0].equals("Leave")){
                result.add("Leave "+rs[1]);
            }
            else{
                map.replace(rs[1], rs[2]);
            }
        }
        for(String r : result){
            String[] rs = r.split(" ");
            if(rs[0].equals("Enter")){
                answer.add(map.get(rs[1])+"님이 들어왔습니다.");
            }else if(rs[0].equals("Leave")){
                answer.add(map.get(rs[1])+"님이 나갔습니다.");
                
            }
        }
        return answer.toArray(new String[answer.size()]);
    }
}