import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Deque<Integer> stack = new LinkedList<>();
        int index = 1;
        boolean flag = true;
        stack.addLast(1);
        bf.append("+\n");
        for(int i=0; i <N;i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            if(index < num){
                while(index < num){
                    index += 1;
                    stack.addFirst(index);
                    bf.append("+\n");
                }
            }
           if(!stack.isEmpty() && stack.getFirst() == num){
                stack.removeFirst();
               bf.append("-\n");
           }else{
               flag = false;
               break;
           }
        }
        if(flag){
            System.out.println(bf.toString());
        }else{
            System.out.println("NO");
        }
    }
}