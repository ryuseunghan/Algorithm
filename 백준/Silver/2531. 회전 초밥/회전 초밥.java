import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] plates;
    static int n,d,k,c, size;
    public static void main(String[] args) {
        // 접시의 수 N, 초밥의 가짓수 d, 연속해서 먹는 접시의 수 k, 쿠폰 번호 c
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        d = sc.nextInt();
        k = sc.nextInt();
        c = sc.nextInt();
        plates = new int[n];
        for(int i = 0; i < n; i++){
            plates[i] = sc.nextInt();
            
        }
        // 1번
        if(d < k){
            if(notInPlates()){
                d += 1;
            }
            System.out.println(d);
        }else{
            HashMap<Integer, Integer> map = new HashMap<>();
            
            for(int i = 0 ; i < k; i++){
                int plate = plates[i];
                if(!map.containsKey(plate)){
                    map.put(plate, 1);
                }else{
                    map.put(plate, map.get(plate) + 1);
                }
            }
            int max = map.keySet().size();
            for(int i = k ; i < n+k; i++){
                int start = plates[i - k];
                int end = plates[i % n];
                
                if(map.get(start) == 1) map.remove(start);
                else map.put(start, map.get(start)- 1);
                
                if(map.containsKey(end)) map.put(end, map.get(end) + 1);
                else map.put(end, 1);

                size = map.keySet().size();
                if(!map.containsKey(c)) size+= 1;
                if(max < size) {
                    max = size;
                }
            }
            System.out.println(max);
        }
    }
    static boolean notInPlates(){
        
        for(int i : plates){
            if(i == c) return false;
        }
        return true;
    }
}

/*
    1. 임의로 K개 선택 시 가짓수 구하기
    2. 연속으로 K개 선택 시 최대 가짓수 구하기
    3. 2번의 경우 쿠폰을 통해 가짓수가 늘어나는지 확인하기
    임의의 한 위치부터 k개의 접시를 연속해서 먹을 경우 할인된 정액 가격
    각 고객에게 초밥의 종류 하나가 쓰인 쿠폰을 발행하고, 1번 행사에 참가할 경우 
    이 쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공한다. 
    만약 이 번호에 적혀진 초밥이 현재 벨트 위에 없을 경우, 요리사가 새로 만들어 손님에게 제공
*/