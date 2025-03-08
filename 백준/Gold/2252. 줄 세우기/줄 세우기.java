import java.io.*;
import java.util.*;

class Main {
    static int[] in;
    static List<List<Integer>> out;
    static List<Integer> notVisited;
    public static void main(String[] args)  throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        in = new int[N+1];
        out = new ArrayList<>();
        notVisited = new ArrayList<>();
        for(int i =0; i<= N; i++){
            if(i!=0){
                notVisited.add(i);
            }
            out.add(new ArrayList<>());
        }
        for(int i =1; i<= M; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            in[e]++;
            out.get(s).add(e);
        }

        while(!notVisited.isEmpty()){
            bw.write(checkIn(N) +" ");
        }
        bw.flush();
        bw.close();
        br.close();

    }

    public static int checkIn(int N) {
        for(int i = 0; i < notVisited.size(); i++){
            int num = notVisited.get(i);
            if(in[num] == 0){
                notVisited.remove(i);
                for(int x: out.get(num)){
                    in[x]--;
                }
                return num;
            }
        }
        return -1;
    }
}