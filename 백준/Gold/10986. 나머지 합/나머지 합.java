import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N+1];
        int[] remain = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N+1; i++){
            int num = Integer.parseInt(st.nextToken());
            array[i] = (int)((num + array[i-1])%M);
            remain[array[i]] ++;
        }
        long count = remain[0];
        for(int i = 0; i < M; i++){
            count += Comb(remain[i]);
        }
        System.out.println(count);
    }
    static long Comb(long n){
        if (n < 2)
            return 0;
        else
            return n * (n - 1) / 2;
    }


}
