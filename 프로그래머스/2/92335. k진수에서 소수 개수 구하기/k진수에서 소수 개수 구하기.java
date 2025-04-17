import java.util.*;
class Solution {
    public int solution(int n, int k) {
        int result = 0;
        String[] arr = ntok(n, k).split("0");
        for(String str : arr){
           result +=  checkIfPrime(str);
        }
        return result;
    }
    static int checkIfPrime(String str){
        if(str.equals("") || str.equals("1")) return 0;
        long num = Long.parseLong(str);
        for(int i = 2; i <= Math.sqrt(num); i++){
            if(num % i == 0) return 0;
        }
        return 1;
    }
    static String ntok(int n, int k){
        Queue<Integer> queue = new LinkedList<>();
        while(n > 0){
            queue.offer(n%k);
            n /= k;
        }
        long num = 0;
        long jarisu = 1;
        while(!queue.isEmpty()){
            num += queue.poll() * jarisu;
            jarisu *=10;
        }
        return Long.toString(num);
    }
}