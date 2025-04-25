import java.util.*;
class Solution {
    static Set<String> set = new HashSet<>();
    public int solution(String begin, String target, String[] words) {
        Queue<String[]> queue = new LinkedList<>();
        queue.offer(new String[]{begin, "0"});
        while(!queue.isEmpty()){
            String[] str = queue.poll();
            set.add(str[0]);
            for(String[] word : change(str, words)){
                if(word[0].equals(target)) return Integer.parseInt(word[1]);
                queue.offer(word);
            }
        }
        return 0;
    }
    static LinkedList<String[]> change(String[] str, String[] words){
        LinkedList<String[]> result = new LinkedList<>(); 
        char[] arr1 = str[0].toCharArray();
        for(String word : words){
            if(set.contains(word)) continue;
            char[] arr2 = word.toCharArray();
            int odd = 0;
            for(int i = 0; i < arr1.length; i++){
                if(arr1[i] != arr2[i]) odd++;
            }
            if(odd == 1) result.add(new String[]{word, Integer.toString(Integer.parseInt(str[1])+1)});
        }
        return result;
    }
}