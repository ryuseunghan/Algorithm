import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        boolean[] isPrime = new boolean[1003002];
        for(int i=2; i<= 1003001;i++){
            isPrime[i] = true;
        }
        for(int i=2; i<= 1003001;i++){
            if(isPrime[i]){
                StringBuffer sb = new StringBuffer(Integer.toString(i));
                int reverseInt = Integer.parseInt(sb.reverse().toString());
                if(i == reverseInt){
                    if(i>=n){
                        System.out.println(i);
                        break;
                    }
                }
                for(int j=i+i; j<=1003001;j+=i){
                    isPrime[j] = false;
                }
            }
        }

    }
}
