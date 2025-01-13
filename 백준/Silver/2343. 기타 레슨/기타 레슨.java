import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        array = new int[n];
        st = new StringTokenizer(br.readLine());
        int total = 0;
        for(int i = 0 ; i < n; i++){
            array[i] =  Integer.parseInt(st.nextToken());
            total += array[i];
        }

        int min = Arrays.stream(array).max().getAsInt();
        int max = total;
        int mid = 0;
        while(min <= max){
            mid = (min + max) /2;
            if(check(mid))  min = mid + 1;
            else max = mid - 1;
        }
        System.out.println(min);

    }

    // 시간복잡도 n
    static boolean check(int length){
        int count = 1;
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += array[i];
            if(sum > length){
                sum = array[i];
                count += 1;
            }
            if(count > m) return true;
        }
        return false;
    }
}


