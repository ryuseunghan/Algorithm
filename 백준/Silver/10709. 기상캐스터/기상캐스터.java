import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] graph = new int[r][c];
        for(int i = 0; i < r; i++){
            char[] line = br.readLine().toCharArray();
            for(int j = 0; j < c ; j++){
                if(line[j] == 'c') graph[i][j] = 0;
                else graph[i][j] = -1;
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 1; j < c ;j++){
                if(graph[i][j-1] == -1) continue;
                else if (graph[i][j] == 0) continue;
                else graph[i][j] = graph[i][j-1] + 1;
            }
        }
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c ; j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}