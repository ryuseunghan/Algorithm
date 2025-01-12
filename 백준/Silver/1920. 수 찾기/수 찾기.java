import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] array1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(st.nextToken());
        array1 = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n;i++){
            array1[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array1);
        st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m;i++){
            bw.write(find(Integer.parseInt(st.nextToken()))+"\n");
        }
        bw.flush();
    }
    static int find(int num){
        int min = 0;
        int max = array1.length-1;
        while (min <= max) {
            int mid = (min + max) / 2;

            if (array1[mid] == num) {
                return 1; // 숫자를 찾음
            } else if (array1[mid] > num) {
                max = mid - 1; // 왼쪽으로 탐색
            } else {
                min = mid + 1; // 오른쪽으로 탐색
            }
        }
        return 0;         
    }

}


