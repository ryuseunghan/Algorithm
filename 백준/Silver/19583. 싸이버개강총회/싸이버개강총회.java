import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Set<String> enter = new HashSet<>();
    static Set<String> quit = new HashSet<>();
    public static void main(String[] args) throws IOException{
        // System.out.println("Hello world!")
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        int startHour = Integer.parseInt(s.substring(0,2));
        int startMin = Integer.parseInt(s.substring(3));
        String e = st.nextToken();
        int endHour = Integer.parseInt(e.substring(0,2));
        int endMin = Integer.parseInt(e.substring(3));
        String q = st.nextToken();
        int quitHour = Integer.parseInt(q.substring(0,2));
        int quitMin = Integer.parseInt(q.substring(3));
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            st = new StringTokenizer(line);
            String time = st.nextToken();
            int hour = Integer.parseInt(time.substring(0,2));
            int min = Integer.parseInt(time.substring(3));
            String name = st.nextToken();
            if(hour < startHour || (hour == startHour && min <= startMin)){
                enter.add(name);
            }
            if(hour > endHour || (hour == endHour && min >= endMin)){
                if(hour < quitHour || (hour == quitHour && min <= quitMin)){
                    if(enter.contains(name)){
                        quit.add(name);
                    }
                }
            }
        }
        System.out.println(quit.size());
        
    }
}