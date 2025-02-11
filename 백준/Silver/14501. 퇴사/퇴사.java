import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] result = new int[N+1];
        int[][] array = new int[N+1][2];
        for(int i = 1; i <= N; i++){
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }
        for(int i = 1; i <= N; i++){
            result[i] = Math.max(result[i-1], result[i]);
            int idx  = array[i][0] +i -1;
            if(idx <= N){
                result[idx] = Math.max(result[idx],result[i-1] + array[i][1]);
            }
        }
        System.out.println(result[N]);
    }
}
