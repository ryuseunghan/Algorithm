import java.util.*;
import java.lang.*;

class Main {
    static int[] parent;
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        parent = new int[N+1];
        for(int i = 0; i<=N; i++){
            parent[i] = i;
        }
        sc.nextLine();
        int num = sc.nextInt();
        for(int i = 0; i<num; i++){
            parent[sc.nextInt()] = 0;
        }
        sc.nextLine();
        int count = 0;
        int before = 0;
        List<List<Integer>> array = new ArrayList<>();
        for(int i = 0; i<M; i++){
            List<Integer> list = new ArrayList<>();
            num = sc.nextInt();
            before = 0;
            for(int j = 0; j<num; j++){
                int next = sc.nextInt();
                if(before !=0){
                    union(before, next);
                }
                before = next;
                list.add(next);
            }
            sc.nextLine();
            array.add(list);
        }
        for(int i = 0; i<M; i++){
            boolean flag = true;
            for(int x : array.get(i)){
                if(find(x) == 0){
                    flag = false;
                    break;
                }
            }
            if(flag){
                count++;
            }
        }
        System.out.println(count);
    }
    static int find(int node){
        if(node == parent[node]){
            return node;
        }else return parent[node] = find(parent[node]);
    }
    static void union(int a, int b){
        if(find(a) <= find(b)){
            parent[find(b)] = find(a);
        }else{
            parent[find(a)] = find(b);
        }
    }
}