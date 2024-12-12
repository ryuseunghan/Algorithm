import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for(int i = 0; i<N; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int total = 0;
        for(int i = 0; i<N; i++){
            total += array[i] * (N - i);
        }
        System.out.println(total);
    }
}