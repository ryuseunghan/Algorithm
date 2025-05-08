class Solution {
    static int[] arr;
    public int solution(String[] user_id, String[] banned_id) {
        arr = new int[banned_id.length];
        int idx = 0;
        for(String ban : banned_id){
            int num = 0;
            for(String user : user_id){
                if(check(ban, user)){
                    arr[idx] += Math.pow(2, num);
                }
                num++;
            }
            idx++;
        }
        for(int i = 0; i < banned_id.length;i++){
            System.out.println(arr[i]);
        }
        
        int answer = 0;
        return answer;
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