import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] moveR = new int[]{0, 1, 0, -1};
    static int[] moveC = new int[]{1, 0, -1, 0};
    static int r;
    static int c;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        r = sc.nextInt();
        c = sc.nextInt();
        boolean[][] person = new boolean[r+1][c+1];
        boolean[][] fire = new boolean[r+1][c+1];

        Queue<int[]> p_que = new LinkedList<>();
        Queue<int[]> f_que = new LinkedList<>();
        
        for(int i = 1; i <= r; i++){
            String strs = sc.next();
            int j = 1;
            for(String s : strs.split("")){
                if(s.equals("#")) {
                    person[i][j] = true;
                    fire[i][j] = true;
                }
                if(s.equals("J")) {
                    p_que.offer(new int[]{i, j, 0});
                }
                if(s.equals("F")) {
                    f_que.offer(new int[]{i, j, 0});
                    fire[i][j] = true;
                }
                j++;
            }
        }
        boolean flag = false;
        int time = 0;
        while(!p_que.isEmpty()){
            while(!f_que.isEmpty() && f_que.peek()[2] == time){
                int[] fnode = f_que.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int newR = fnode[0] + moveR[i];
                    int newC = fnode[1] + moveC[i];
                    if(inBoard(newR, newC) && !fire[newR][newC]){
                        f_que.offer(new int[]{newR, newC, fnode[2]+1});
                        fire[newR][newC] = true;
                    }
                }
            }
            while(!p_que.isEmpty() && p_que.peek()[2] == time){
                int[] pnode = p_que.poll();
                for(int i = 0 ; i < 4 ; i++){
                    int newR = pnode[0] + moveR[i];
                    int newC = pnode[1] + moveC[i];
                    if(!inBoard(newR, newC)) {
                        System.out.println(pnode[2] + 1);
                        flag = true;
                        break;
                    }
                    
                    if(inBoard(newR, newC) && !person[newR][newC] && !fire[newR][newC]){
                        p_que.offer(new int[]{newR, newC, pnode[2]+1});
                        person[newR][newC] = true;
                    }
                }
                if(flag) break;
            }
            
            time++;
            if(flag) break;
        }
        if(!flag) System.out.println("IMPOSSIBLE");
    }
    static boolean inBoard(int row, int col){
        if(row > 0 && row <= r && col > 0 && col <= c)return true;
        return false;
    }
}