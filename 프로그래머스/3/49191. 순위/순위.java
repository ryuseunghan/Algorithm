import java.util.*;
class Solution {
    static List<List<Integer>> win;
    static List<List<Integer>> lose;
    static boolean[] v; 
    static int answer;
    public int solution(int n, int[][] results) {
        win = new ArrayList<>();
        lose = new ArrayList<>();
        for(int i = 0; i<= n; i++){
            win.add(new ArrayList<>());
            lose.add(new ArrayList<>());
        }
        for(int i = 0; i < results.length; i++){
            win.get(results[i][0]).add(results[i][1]);
            lose.get(results[i][1]).add(results[i][0]);
        }
        answer = 0;
        for(int i=1; i<=n; i++){
            v = new boolean[n+1];
            v[0] = true;
            bfs(i, win);
            v[i] = false;
            bfs(i, lose);
            check();
        }
        
        
        return answer;
    }
    static void bfs(int start, List<List<Integer>> arrayList){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int num = queue.poll();
            if(!v[num]){
                v[num] = true;
                for(int x : arrayList.get(num)){
                    queue.add(x);
                }
            }
        }
    }
    static void check(){
        boolean flag = true;
        for(boolean bool : v){
            if(!bool){
                flag = false;
            }
        }
        if(flag){
            answer++;
        }

    }
}