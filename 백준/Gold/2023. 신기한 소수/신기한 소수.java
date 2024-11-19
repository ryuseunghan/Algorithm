import org.w3c.dom.Node;

import java.io.*;
import java.util.*;

import static java.lang.Math.sqrt;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        N = (int)Math.pow(10, N-1);
        DFS(2);DFS(3);DFS(5);DFS(7);
    }
    static boolean isPrime(int n){
        for(int i = 2; i <= sqrt(n); i++){
            if(n%i == 0) return false;
        }
        return true;
    }
    static void DFS(int n){
        if(isPrime(n)){
            if(n < N ){
                for(int j = 0; j < 10; j++){
                    DFS(10* n + j);
                }
            }else{
                System.out.println(n);
            }
        }
        return;
    }
}