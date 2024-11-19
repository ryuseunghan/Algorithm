import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        long[][] array = new long[n+1][n+1];
        for(int i = 1; i < n+1; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int j = 1; j < n+1; j++){
                array[i][j] = array[i-1][j] + array[i][j-1] -  array[i-1][j-1] + Integer.parseInt(stringTokenizer.nextToken());
            }
        }

        for(int i = 0; i < m; i++){
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken())-1;
            int y = Integer.parseInt(stringTokenizer.nextToken())-1;
            int X = Integer.parseInt(stringTokenizer.nextToken());
            int Y = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(array[X][Y] + array[x][y]-array[X][y]-array[x][Y]);
        }
    }
}