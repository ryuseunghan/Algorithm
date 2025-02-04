import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        long Min = sc.nextLong();
        long Max = sc.nextLong();
        boolean[] isPrime = new boolean[(int)(Max-Min+1)];

        // 소수 구하기
        for(long i=2; i<= Math.sqrt(Max);i++) {
            long pow = i * i;
            long start = Min / pow;
            if(Min%pow != 0){
                start ++;
            }
            for (long j = start; pow * j <= Max; j ++) {
                isPrime[(int) ((j*pow) - Min)] = true;
            }
        }
        // 해당 수 집계
        long count = 0;
        for(int i=0; i<= (int)(Max-Min);i++){
            if(!isPrime[i]){
                count++;
            }
        }

        System.out.println(count);
    }
}
