import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean plus = true;
    static int sum = 0;
    static String st = "";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        String[] array = new String[line.length()];
        for(int i = 0; i < line.length(); i++){
            array[i] = line.substring(i, i+1);
        }
        for(int i = 0; i < line.length(); i++){
            if(array[i].equals("+")){
                calculate();
            }else if (array[i].equals("-")){
                calculate();
                plus = false;
            }else{
                st+=array[i];
            }
        }
        calculate();
        System.out.println(sum);
    }

    static void calculate(){
        if(plus) sum += Integer.parseInt(st);
        else sum -= Integer.parseInt(st);
        st = "";
    }
}