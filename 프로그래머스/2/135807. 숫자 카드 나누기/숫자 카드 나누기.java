import java.util.*;
class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);Arrays.sort(arrayB);
        int minA = arrayA[0];
        int minB = arrayB[0];
        int answer = 0;
       
        for(int i = minA; i > 1; i--){
            boolean find = true;
            for(int a : arrayA){
                if(a % i != 0){
                    find = false;
                    break;
                }
            }
            if(find){
                for(int b : arrayB){
                    if(b % i == 0){
                        find = false;
                        break;
                    }
                }
            }
            if(find){
                answer = Math.max(i, answer);
            }
        }
        
        for(int i = minB; i > 1; i--){
            boolean find = true;
            for(int b : arrayB){
                if(b % i != 0){
                    find = false;
                    break;
                }
            }
            if(find){
                for(int a : arrayA){
                    if(a % i == 0){
                        find = false;
                        break;
                    }
                }
            }
            if(find){
                answer = Math.max(i, answer);
            }
        }
        return answer;
    }
}