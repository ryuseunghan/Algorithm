import java.io.*;
import java.util.*;

import static java.util.Collections.sort;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int[] array = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i =0; i< N; i++){
            array[i+1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        int start = 1;
        int end = N;
        int count = 0;
        while(start < end){
            int sum = array[start] + array[end];
            if(sum < M){
                start++;
            }else if(sum > M){
                end --;
            }
            else{
                count ++;
                start++;
                end --;
            }
        }
        System.out.println(count);
    }

}