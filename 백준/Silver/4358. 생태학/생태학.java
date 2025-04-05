import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException{
        Map<String, Float> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        int count = 0;
        while(sc.hasNext()){
            String s = sc.nextLine();
            if(map.containsKey(s)){
                map.put(s, map.get(s) + 1);
            }else{
                map.put(s, 1f);
            }
            count++;
        }
        PriorityQueue<Tree> pq = new PriorityQueue<>();
        for(String s : map.keySet()){
            pq.offer(new Tree(s, map.get(s)));
        }
        while(!pq.isEmpty()){
            Tree t = pq.poll();
            
            System.out.println(t.s +" " +String.format("%.4f",t.count/count * 100));
        }
    }
    static class Tree implements Comparable<Tree>{
        float count;
        String s;
        Tree(String s, float count){
            this.s = s;
            this.count = count;
        }
        @Override
        public int compareTo(Tree o){
            return this.s.compareTo(o.s);
        }
    }
}

