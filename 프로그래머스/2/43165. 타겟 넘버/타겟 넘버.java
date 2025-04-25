class Solution {
    static int ans = 0;
    static int t;
    public int solution(int[] numbers, int target) {
        t= target;
        dfs(0, 0, numbers);
        return ans;
    }
    static void dfs(int sum, int idx, int[] numbers){
        if(idx == numbers.length){
            if(sum == t) ans++;
            return;
        }
        dfs(sum - numbers[idx], idx+1, numbers);
        dfs(sum + numbers[idx], idx+1, numbers);
    }
}