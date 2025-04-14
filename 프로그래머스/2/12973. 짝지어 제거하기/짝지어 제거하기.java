import java.util.Stack;

class Solution {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop(); // 짝을 이루면 제거
            } else {
                stack.push(ch); // 아니면 추가
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }
}
