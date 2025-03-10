import java.util.*;
import java.lang.*;

class Main {
    public static void main(String[] args) {
        List<List<Integer>> in = new ArrayList<>();
        List<List<Integer>> out = new ArrayList<>();
        List<List<Integer>> reverse = new ArrayList<>();
        Map<Integer, Map<Integer, Integer>> weightMap = new HashMap<>();
        int[] distance;
        int[] inDegree;

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        distance = new int[N+1];
        for(int i = 0; i<=N; i++){
            in.add(new ArrayList<>());
            out.add(new ArrayList<>());
            reverse.add(new ArrayList<>());
            weightMap.put(i, new HashMap<>());
        }
        inDegree = new int[N+1];
        for(int i = 0; i<M; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            int d = sc.nextInt();
            weightMap.get(start).put(end, d);
            out.get(start).add(end);
            in.get(end).add(start);
            inDegree[end]++;
            reverse.get(end).add(start);
        }
        int start = sc.nextInt();
        int end = sc.nextInt();

        // 출발
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        while(!queue.isEmpty()){
            int s = queue.poll();
            for(int e : out.get(s)){
                inDegree[e]--;
                if(inDegree[e] == 0){
                    queue.add(e);
                }
                int weight =  weightMap.get(s).get(e);
                if(distance[s] + weight > distance[e]){
                    distance[e]= distance[s] + weight;
                }
            }
        }
        queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        queue.add(end);
        while(!queue.isEmpty()){
            int e = queue.poll();
            for(int s : reverse.get(e)) {
                int weight = weightMap.get(s).get(e);
                if (distance[e] - weight == distance[s]) {
                    String node = node(s, e);
                    if (!set.contains(node)) {
                        queue.add(s);
                        set.add(node);
                    }
                }
            }
        }
        System.out.println(distance[end]);
        System.out.println(set.size());

    }
    static String node(int start, int end){
        StringBuilder sb = new StringBuilder();
        sb.append(start);
        sb.append("/");
        sb.append(end);
        return sb.toString();
    }
}