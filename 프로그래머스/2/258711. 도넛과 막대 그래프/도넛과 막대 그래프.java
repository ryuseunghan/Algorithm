import java.util.*;

class Solution {
    static ArrayList<List<Integer>> graph;
    static int[] incomingGraph;
    static int maxVertex;
    static int[] answer;
    static Set set;
    static int edgeNum;
    static boolean flag;
    public int[] solution(int[][] edges) {
        answer = new int[4];
        initializeGraph(edges);
        int center = searchCenter(edges);
        answer[0] = center;

        for(int end : graph.get(center)){
            flag = false;
            set = new HashSet<>();
            edgeNum = 0;
            trip(end);
            defineGraph();
        }
        return answer;
    }
    static void initializeGraph(int[][] edges){
        maxVertex = 0;
        // 가장 큰 vertex 구하기
        for(int[] edge: edges){
            int max = Math.max(edge[0], edge[1]);
            maxVertex = Math.max(maxVertex, max);
        }

        // 해당 vertex로 초기화
        incomingGraph = new int[maxVertex+1];
        graph = new ArrayList<>(maxVertex+1);
        for(int i = 0; i<= maxVertex; i++){
            graph.add(new LinkedList<>());
        }
    }
    static int searchCenter(int[][] edges){
        for(int[] edge: edges){
            int s = edge[0];
            int e = edge[1];
            graph.get(s).add(e);
            incomingGraph[e]++;
        }

        for(int i = 1; i <= maxVertex; i++){
            if(incomingGraph[i] == 0){
                if(graph.get(i).size() >= 2){
                    return i;
                }
            }
        }
        return 0;
    }
    static void trip(int start){
        set.add(start);
        if(!graph.get(start).isEmpty()){
            int newStart = graph.get(start).get(0);
            if(graph.get(start).size() == 2){
                flag = true;
            }
            graph.get(start).remove(0);
            edgeNum += 1;
            trip(newStart);
        }
    }
    static void defineGraph(){
        int vertexNum = set.size();
        if(flag){
            answer[3]++;
        }
        else if(edgeNum == vertexNum){
            answer[1]++;
        }else if(edgeNum == vertexNum - 1){
            answer[2]++;
        }else{
            System.out.println("error");   
        }
    }
}