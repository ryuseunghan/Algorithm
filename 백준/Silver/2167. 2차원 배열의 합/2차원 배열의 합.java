import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] graph = new int[row+1][col+1];
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                graph[i][j] =graph[i-1][j] + graph[i][j-1] - graph[i-1][j-1] + sc.nextInt();
            }
        }
        int n = sc.nextInt();
        for(int i =0; i < n; i++){
            int r1 = sc.nextInt();
            int c1 = sc.nextInt();
            int r2 = sc.nextInt();
            int c2 = sc.nextInt();
            System.out.println(graph[r2][c2] + graph[r1-1][c1-1]-graph[r2][c1-1]-graph[r1-1][c2]);
        }
    }
}