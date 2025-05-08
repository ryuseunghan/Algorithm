import java.util.*;
class Solution {
    static List<String>[] list;
    static Set<Set<String>> set = new HashSet<>();
    static int banlen;
    public int solution(String[] user_id, String[] banned_id) {
        banlen = banned_id.length;
        list = new ArrayList[banlen];
        for(int i = 0 ; i < banlen; i++){
            list[i] = new ArrayList<>();
            for(String user : user_id){
                if(check(banned_id[i], user)){
                    list[i].add(user);
                }
            }
        }
        dfs(0, new HashSet<>());
        return set.size();
    }
    static void dfs(int idx, Set<String> subset) {
        if (idx == banlen) {
            set.add(new HashSet<>(subset));
            return;
        }

        for (String name : list[idx]) {
            if (!subset.contains(name)) {
                Set<String> newSet = new HashSet<>(subset);
                newSet.add(name);
                dfs(idx + 1, newSet);
            }
        }
    }
    static boolean check(String ban, String user){
        // 길이 다를 시 false
        if(ban.length() != user.length()) return false;
        String[] u = user.split("");
        String[] b = ban.split("");
        
        for(int i = 0; i < ban.length(); i++){
            if(!b[i].equals("*")){
                if(!u[i].equals(b[i])) return false;
            }
        }
        return true;
    }
}