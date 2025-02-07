import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int ans = sc.nextInt();
        int[] array = new int[ans+1];
        array[1] = 0;
        for(int i=2; i <=ans ; i++) {
            int num = array[i - 1] + 1;
            if (i % 2 == 0) {
                num =Math.min(num, array[i / 2] + 1);
            }
            if (i % 3 == 0) {
                num = Math.min(num, array[i / 3] + 1);
            }
            array[i] = num;
        }
        System.out.println(array[ans]);

    }
}
