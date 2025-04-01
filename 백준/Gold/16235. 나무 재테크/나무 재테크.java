import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[][] nut;
    static int[][] a;
    static Deque<Integer>[] list;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        a = new int[n][n];
        nut = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                a[i][j] = Integer.parseInt(st.nextToken());
                nut[i][j] = 5;
            }
        } 
        list = new LinkedList[n * n];
        for(int i = 0; i < n*n; i++){
            list[i] = new LinkedList<>();
        }
        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            list[x * n + y].offer(z);
        }
        int count = m;
        for(int K = 0; K < k; K++){
            // 봄
            for(int i = 0; i < n*n; i++){
                List<Integer> arr = new LinkedList<>();
                List<Integer> dead = new LinkedList<>();
                int x = i / n;
                int y = i % n;
                while(!list[i].isEmpty()){
                    
                    int tree = list[i].pollFirst();
                    
                    if(tree <= nut[x][y]){
                        nut[x][y] -= tree;
                        arr.add(tree+1);
                    }else{
                        dead.add(tree);
                        count--;
                    }
                }
                for(int tree : arr){
                    list[i].offer(tree);
                }
                // 여름
                for(int d : dead){
                    nut[x][y] += d/2;
                }
            }
            // 가을 번식
            for(int i = 0; i < n*n; i++){
                List<Integer> arr = new LinkedList<>();
                while(!list[i].isEmpty()){
                    int tree = list[i].poll();
                    if(tree % 5 == 0){
                        int x = i / n;
                        int y = i % n;
                        for(int newx = x -1; newx <= x+1; newx++){
                            for(int newy = y -1; newy <= y+1; newy++){
                                if((newx >= 0 && newx < n && newy >= 0 && newy < n) && (newx!=x || newy!=y)){
                                    list[newx*n + newy].offerFirst(1);
                                    count++;
                                }
                            }
                        }
                    }
                    arr.add(tree);
                }
                for(int tree : arr){
                    list[i].offer(tree);
                }
            }
            // 겨울
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    nut[i][j] += a[i][j];
                }
            } 
        }
        System.out.println(count);
    }
}
/*
    n 칸수 <= 10
    m 나무 수 < n^2
    k k년 후 나무 개수 <= 1000
    a[r][c] 양분
    x, y, z : r c 나이
    봄 : 양분 섭취 어린 나무부터, 나이만큼 양분 섭취 못할 시 사망
    여름 : 죽은 나무는 나이/2를 양분으로 소수 제외
    가을 번식 : 근처에 1인 나무 생성
    겨울 : 양분 추가 a[r][c]
    
*/