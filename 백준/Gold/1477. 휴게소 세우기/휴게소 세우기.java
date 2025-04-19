import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int n, m, l;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int l = sc.nextInt();
        PriorityQueue<Station> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int past = 0;
        for(int now : arr){
            pq.offer(new Station(now - past));
            past = now;
        }
        pq.offer(new Station(l - past));
        for(int i = 0 ; i < m; i++){
            Station s = pq.poll();
            s.division++;
            s.dividedDistance = divisionNum(s);
            pq.offer(s);
        }
        System.out.println(pq.poll().dividedDistance);
    }
    static int divisionNum(Station s){
        int num = s.distance;
        int division = s.division;
        int ans = num / division;
        int d = num % division;
        int[] arr = new int[division];
        Arrays.fill(arr, ans);
        int idx = 0;
        while(d > 0){
            idx %= division;
            arr[idx++] += 1;
            d--;
        }
        return arr[0];
    }
    static class Station implements Comparable<Station>{
        int division, distance, dividedDistance;
        Station(int distance){
            this.division = 1;
            this.distance = distance;
            this.dividedDistance = distance;
        }
        @Override
        public int compareTo(Station o){
            return this.dividedDistance - o.dividedDistance;
        }
    }
}

/*
    현재 휴게소 n
    + m 개 하려함
    휴게소는 겹칠 수 없으며 끝에도 세울 수 없음
    정수 위치만 가능
    모든 휴게소 방문
    m개 더 지어서 휴게소가 없는 구간의 길이의 최댓값을 최소로 하려고 한다
    
*/