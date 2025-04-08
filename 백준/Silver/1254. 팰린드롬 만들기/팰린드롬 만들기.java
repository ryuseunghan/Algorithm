import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static String s;
    static int len;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        s = sc.next();
        len = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < len; i++){
            if(isPelindom(sb)){
                break;
            }
            stringBuild(sb, i);
        }
        System.out.println(sb.length());
    }
    static StringBuilder stringBuild(StringBuilder str, int num){
        for(int i = str.length()-1; i >= len; i--){
            str.deleteCharAt(i);
        }
        for(int i = num; i>=0; i--){
            str.append(str.charAt(i));
        }
        return str;
    }
    static boolean isPelindom(StringBuilder str){
        int len = str.length();
        int start = 0;
        int end = len - 1;
        while(start < end){
            if(str.charAt(start) != str.charAt(end))return false;
            start ++;
            end --;
        }
        return true;
    }
}