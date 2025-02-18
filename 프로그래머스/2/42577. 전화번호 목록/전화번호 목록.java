import java.util.*;

class Solution {
    static Set set;
    public boolean solution(String[] phone_book) {
        boolean flag = true;
        Arrays.sort(phone_book);
        set = new HashSet<String>();
        for(String str : phone_book){
            for(int i = 1; i< str.length(); i++){
                if(set.contains(str.substring(0, i))){
                    flag = false;
                    break;
                }
            }
            set.add(str);
        }
        return flag;
    }
}