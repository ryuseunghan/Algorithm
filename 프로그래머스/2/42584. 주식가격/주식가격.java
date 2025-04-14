import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        prices[prices.length-1] = 0;
        int[] result = new int[prices.length];
        for(int i = 0; i < prices.length - 1; i++){
            for(int j = i; j < prices.length; j++){
                if(prices[i] > prices[j]) {result[i] = j-i;break;}
            }
        }
        return result;
    }
}