import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        StringBuilder matcher = new StringBuilder("I");
        for(int i = 0; i< n;i ++){
            matcher.append("OI");
        }
        sc.next();
        String s = sc.next();
        System.out.println(matched(s, matcher.toString()));

        
    }
    static int matched(String s, String matcher) {
        int ans = 0;
        int idx = 0;
        int mLen = matcher.length();
        
        while (idx <= s.length() - mLen) {
            int found = s.indexOf(matcher, idx);
            if (found == -1) break;
            ans++;
            idx = found + 1; // 겹치게 세기 위해 +1
        }
        return ans;
    }
}