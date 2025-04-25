import java.util.*;
class Solution {
    static List<String> answer = null;
    public String[] solution(String[][] tickets) {
        Arrays.sort(tickets, (a, b) -> a[1].compareTo(b[1]));
        for(String[] ticket: tickets){
            if(ticket[0].equals("ICN")){
                LinkedList<String> path = new LinkedList<>();
                path.add(ticket[0]);
                path.add(ticket[1]);
                LinkedList<String[]> leftTickets = new LinkedList<>();
                for(String[] t : tickets){
                    if(!t.equals(ticket)) leftTickets.add(t);
                }
                dfs(ticket[1], leftTickets, path);
            }
        }
        return answer.toArray(new String[0]);
    }
    static void dfs(String start, LinkedList<String[]> tickets, LinkedList<String> path){
        // //디버깅
        // for(String p : path) System.out.print(p+" ");
        // System.out.println();
        
        if(tickets.isEmpty()){
            if (answer == null) { // 가장 첫 번째 완성된 경로만 저장
                answer = new ArrayList<>(path);
            }
            return;
        }
        for(String[] ticket : tickets){
            LinkedList<String> newPath = new LinkedList<>();
            if(ticket[0].equals(start)){
                for(String p : path){
                    newPath.add(p);
                }
                newPath.add(ticket[1]);
                LinkedList<String[]> leftTickets = new LinkedList<>();
                for(String[] t : tickets){
                    if(!t.equals(ticket))leftTickets.add(t);
                }
                dfs(ticket[1], leftTickets, newPath);
            }
        }
    }
}