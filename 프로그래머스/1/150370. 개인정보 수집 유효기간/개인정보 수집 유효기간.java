import java.util.*;
import java.lang.*;
class Solution {
    static List<Integer> list;
    static Map<String, Integer> map;
    static int y;
    static int m;
    static int d;
    public int[] solution(String today, String[] terms, String[] privacies) {
        map = new HashMap<>();
        list = new ArrayList<>();
        
        String[] date = today.split("\\.");
        y = Integer.parseInt(date[0]);
        m = Integer.parseInt(date[1]);
        d = Integer.parseInt(date[2]);
        
        for(String str : terms){
            String s = str.substring(0,1);
            String i = str.substring(2);
            map.put(s, Integer.parseInt(i));
        }
        int count = 1;
        for(String privacy : privacies){
            parser(privacy, count);
            count++;
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
    
    static boolean parser(String term, int count){
        int len = term.length();
        String category = term.substring(len-1, len);
        String today = term.substring(0, len-2);
        String[] date = today.split("\\.");
        
        int plusMonth = map.get(category);
        
        int month = Integer.parseInt(date[1]) + plusMonth;
        int plusYear = (month-1) / 12;
        
        int py = Integer.parseInt(date[0]) + plusYear;
        int pm = (month-1) % 12 + 1;
        int pd = Integer.parseInt(date[2]);
        
        if(check(py, pm, pd)){
            list.add(count);
        }
        System.out.println(count+" "+ py+" "+ pm+" "+pd);
        return check(py, pm, pd);
    }
    
    static boolean check(int py, int pm, int pd){
        if(py < y){
            return true;
        }else if(py == y && pm < m){
            return true;
        }else if(py == y && pm == m && pd <= d){
            return true;
        }else{
            return false;
        }
    }
}