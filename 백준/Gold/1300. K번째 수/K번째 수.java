import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class Main {
    static int n;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        int max = k;
        int min = 1;
        while(min <= max){
            int mid = (min+max)/2;
            if(check(mid)){
                max = mid -1;
            }
            else{
                min = mid+1;
            }
        }
        System.out.println(min);
    }

    // 시간복잡도 n
    static boolean check(int num){
        int sum = 0;
        for(int i = 1; i < n+1; i++){
            sum += min(num/i, n);
            if(sum >= k) return true;
        }
        return false;
    }
}


