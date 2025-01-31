import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        long b = sc.nextLong();

        boolean[] isPrime = new boolean[(int)Math.sqrt(b)+1];
        long count = 0;
        for(int i = 2; i <= Math.sqrt(b);i++){
            isPrime[i] = true;
        }
        for(int i = 2; i <= Math.sqrt(b);i++){
            if(isPrime[i]){
                for(int j = i+i; j <= Math.sqrt(b); j+=i){
                    isPrime[j] = false;
                }
            }
        }
        for(int i = 2; i <= Math.sqrt(b);i++){
            double maximum = (double) b;
            double minimum = (double) a;
            if(isPrime[i]){
                maximum = maximum/ (double)i;
                minimum =  minimum / (double) i;
                while((double) i <= maximum){
                    if((double) i >= minimum){
                        count ++;
                    }
                    maximum = maximum/ (double)i;
                    minimum =  minimum / (double) i;
                }
            }
        }
        System.out.println(count);
    }
}
