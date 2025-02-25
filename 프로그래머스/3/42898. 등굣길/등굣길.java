import java.util.*;
class Solution {
    long[][] array;
    boolean[][] ps;
    public int solution(int m, int n, int[][] puddles) {
        array = new long[m+1][n+1];
        ps = new boolean[m+1][n+1];
        for(int[] puddle : puddles){
            ps[puddle[0]][puddle[1]] = true;
        }
        array[1][1] = 1;
        ps[1][1] = true;
        for(int i =1; i<= m; i++){
            for(int j = 1; j<= n; j++){
                if(!ps[i][j]){
                    array[i][j] = array[i-1][j]% 1000000007l + array[i][j-1]% 1000000007l;
                }
            }
        }

        return (int)(array[m][n] % 1000000007l);

    }
}