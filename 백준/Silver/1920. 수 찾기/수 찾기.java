import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] array = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<n; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int[] found = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<m; i++){
            found[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : found){
            int start = 0;
            int end = n-1;
            boolean flag = true;
            while(start <= end){
                int mid = (start + end) / 2;
                if(array[mid] == i){
                    bw.write(1+"\n");
                    flag = false;
                    break;
                }
                else if (array[mid] > i){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
            if(flag){
                bw.write(0+"\n");
            }
        }
        bw.flush();
    }

}
