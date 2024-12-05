import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num = Integer.parseInt(st.nextToken());
        int[] array = new int[num+1];
        for(int i=1; i<= num; i++){
            array[i] = array[i-1] + i;
        }
        int count = 0;
        int j = 0;
        for(int i=1; i<= num; i++){
            if(array[i] - array[j] > num){
                while(array[i] - array[j] > num){
                    j++;
                }
            }
            if(array[i] - array[j] == num){
                count += 1;
            }
        }
        System.out.println(count);
    }
}
