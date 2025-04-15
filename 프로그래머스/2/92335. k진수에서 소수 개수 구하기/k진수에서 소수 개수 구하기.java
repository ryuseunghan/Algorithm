import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // n을 k 진수로
        int[] arr = ntok(n, k);
        long num = 0;
        // 소수 개수 구하기
        for(int i = 0; i < arr.length; i++){
            if(arr[i] != 0){
                num = num * 10 + (long)arr[i];
            }else{
                if(num > 1){
                    answer += checkIfPrime(num);
                }
                num = 0;
            }
        }
        if(num > 1) answer += checkIfPrime(num);
        
        
        return answer;
    }
    static int checkIfPrime(long num){
        for(long i = 2; i <= Math.sqrt(num) ; i++){
            if(num % i == 0) return 0; 
        }
        return 1;
    }
    static int[] ntok(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        while(n > 0){
            queue.offer(n%k);
            n /= k;
        }
        int[] arr = new int[queue.size()];
        int i = queue.size() - 1;
        while(!queue.isEmpty()){
            arr[i--] = queue.poll();
        }
        return arr;
    }
}