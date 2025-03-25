import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] dp_min = new int[3];
    static int[] dp_max = new int[3];
    static int[][] point;
    static int[] dp_next;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        point = new int[n][3];
        for(int i=0; i< n; i++){
            point[i][0] = sc.nextInt();
            point[i][1] = sc.nextInt();
            point[i][2] = sc.nextInt();
        }
        dp_next = new int[3];
        for(int i=0; i< n; i++){
            Arrays.fill(dp_next, Integer.MAX_VALUE);
            for(int j = 0; j<=2; j++){
                if(j == 0){
                    next_min(0, j, i);
                    next_min(1, j, i);
                }else if(j == 1){
                    next_min(0, j, i);
                    next_min(1, j, i);
                    next_min(2, j, i);
                }else if(j==2){
                    next_min(1, j, i);
                    next_min(2, j, i);
                }
            }
            for(int j = 0; j<=2; j++){
                dp_min[j] = dp_next[j];
            }

            Arrays.fill(dp_next, Integer.MIN_VALUE);
            for(int j = 0; j<=2; j++){
                if(j == 0){
                    next_max(0, j, i);
                    next_max(1, j, i);
                }else if(j == 1){
                    next_max(0, j, i);
                    next_max(1, j, i);
                    next_max(2, j, i);
                }else if(j==2){
                    next_max(1, j, i);
                    next_max(2, j, i);
                }
            }
            for(int j = 0; j<=2; j++){
                dp_max[j] = dp_next[j];
            }
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int j = 0; j<=2; j++){
            if(min > dp_min[j]) min = dp_min[j];
            if(max < dp_max[j]) max = dp_max[j];
        }
        System.out.println(max+" " + min);
        
    }
    static void next_min(int idx, int j, int i){
        if(dp_next[idx] > dp_min[j] + point[i][j]){
            dp_next[idx] = dp_min[j] + point[i][j];
        }
    }
    static void next_max(int idx, int j, int i){
        if(dp_next[idx] < dp_max[j] + point[i][j]){
            dp_next[idx] = dp_max[j] + point[i][j];
        }
    }
}