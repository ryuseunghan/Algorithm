import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            priorityQueue.add(Integer.parseInt(new StringTokenizer(br.readLine()).nextToken()));
        }

        if(n==1){
            System.out.println(0);
        }
        else{
            int count = 0;
            while(true){
                int sum = (priorityQueue.poll() + priorityQueue.poll());
                count += sum;
                if(priorityQueue.isEmpty()){break;}
                priorityQueue.add(sum);
            }
            System.out.println(count);
        }

    }
}