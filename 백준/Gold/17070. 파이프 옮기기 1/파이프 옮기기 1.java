import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n;
    static int[][] graph;
    static int ans = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        graph = new int[n+1][n+1];
        for(int i = 1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++){
                if(Integer.parseInt(st.nextToken()) == 1){
                    graph[i][j] = -1;
                }
            }
        }
        graph[1][2] = 1;
        dfs(1, 2);
        System.out.println(ans);
    }
    static void dfs(int r, int c){
        if(r == n && c== n){
            ans++;
            return;
        }
        if(graph[r][c] == 1){
            if(move1(r,c)) dfs(r, c+1);
            if(move2(r,c)) dfs(r+1, c+1);
        }
        if(graph[r][c] == 2){
            if(move1(r,c)) dfs(r, c+1);
            if(move2(r,c)) dfs(r+1, c+1);
            if(move3(r,c)) dfs(r+1, c);
        }
        if(graph[r][c] == 3){
            if(move2(r,c)) dfs(r+1, c+1);
            if(move3(r,c)) dfs(r+1, c);
        }
    }
    static boolean move1(int r, int c){
        if(canMove(r, c+1)){
            graph[r][c+1] = 1;
            return true;
        }
        return false;
    }
    static boolean move2(int r, int c){
        if(canMove(r, c+1) && canMove(r+1, c+1) && canMove(r+1, c)){
            graph[r+1][c+1] = 2;
             return true;
        }
        return false;
    }
    static boolean move3(int r, int c){
        if(canMove(r+1, c)){
            graph[r+1][c] = 3;
            return true;
        }
        return false;
    }
    static boolean canMove(int r, int c){
        return r >= 1 && r<= n && c >= 1 && c <= n && graph[r][c] != -1;
    }
}