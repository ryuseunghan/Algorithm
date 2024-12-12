import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Long[] array = new Long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(array); // Sort the array
        
        // Print the K-th smallest number (1-indexed K means index K-1 in 0-indexed)
        System.out.println(array[K - 1]);
    }
}
