import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node> window = new LinkedList<>();
        for(int i=1; i <N+1;i++){
            int value = Integer.parseInt(st.nextToken());
            if(!window.isEmpty() && window.getFirst().index<(i-L+1) ){
                window.removeFirst();
            }
            while(!window.isEmpty() &&window.getLast().value > value){
                window.removeLast();
            }
            window.addLast(new Node(value, i));
            bw.write(window.getFirst().value+" ");
        }
        bw.flush();
        bw.close();
    }

    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }

}