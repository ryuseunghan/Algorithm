import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());
        int[] array = new int[N+1];
        int[] result = new int[N+1];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for(int i=1; i< N+1; i++){
            array[i] = Integer.parseInt(st.nextToken());
        }
        stack.addFirst(array[N]);
        result[N] =-1;
        for(int i=N-1; i>0; i--){
            while(!stack.isEmpty() && stack.getFirst()<=array[i]){
                stack.removeFirst();
            }
            if(stack.isEmpty()){
                stack.addFirst(array[i]);
                result[i] = -1;
            }else{
                result[i] = stack.getFirst();
                stack.addFirst(array[i]);
            }
        }
        for(int i=1; i< N+1; i++){
            bw.write(result[i]+" ");
        }
        bw.flush();
        bw.close();

    }
}