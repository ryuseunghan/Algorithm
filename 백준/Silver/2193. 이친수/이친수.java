import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[][] array = new long[num+1][2];
        array[1][1] = 1;
        for(int i=2; i<=num; i++){
            array[i][0] = array[i-1][0] + array[i-1][1];
            array[i][1] = array[i-1][0];
        }
        System.out.println(array[num][0] + array[num][1]);
    }
}
