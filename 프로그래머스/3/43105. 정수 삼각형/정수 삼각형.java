class Solution {
    public int solution(int[][] triangle) {
        int[][] visited = new int[triangle.length][triangle.length];
        visited[0][0] = triangle[0][0];
        for(int i = 0; i < triangle.length-1; i++){
            for(int j=0; j< i+1; j++){
                // 좌하단
                if(visited[i+1][j] == 0){
                    visited[i+1][j] = triangle[i+1][j] +visited[i][j];
                }else{
                    visited[i+1][j] = visited[i+1][j] > triangle[i+1][j] +visited[i][j] ? visited[i+1][j] : triangle[i+1][j] +visited[i][j];
                }
                // 우하단
                if(visited[i+1][j+1] == 0){
                    visited[i+1][j+1] = triangle[i+1][j+1] +visited[i][j];
                }else{
                    visited[i+1][j+1] = visited[i+1][j+1] > triangle[i+1][j+1] +visited[i][j] ? visited[i+1][j+1] : visited[i+1][j+1];
                }
                
            }
        }
        
        int max = 0;
        for(int x: visited[triangle.length-1]){
            max = max > x ? max : x;
        }
        return max;
    }
}