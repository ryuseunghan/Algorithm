import java.util.*;
import java.io.*;

class Main {
    static int w, h;
    static char[][] map;
    static int[][] fireTime, playerTime;
    static int[] start;
    static Queue<int[]> fireQueue, playerQueue;
    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            map = new char[h][w];
            fireTime = new int[h][w];
            playerTime = new int[h][w];
            fireQueue = new LinkedList<>();
            playerQueue = new LinkedList<>();
            start = new int[2];

            for (int i = 0; i < h; i++) {
                Arrays.fill(fireTime[i], -1);
                Arrays.fill(playerTime[i], -1);
            }

            for (int i = 0; i < h; i++) {
                String row = br.readLine();
                for (int j = 0; j < w; j++) {
                    map[i][j] = row.charAt(j);
                    if (map[i][j] == '*') {
                        fireQueue.offer(new int[]{i, j});
                        fireTime[i][j] = 0;
                    } else if (map[i][j] == '@') {
                        start[0] = i;
                        start[1] = j;
                        playerQueue.offer(new int[]{i, j});
                        playerTime[i][j] = 0;
                    }
                }
            }

            spreadFire();
            int result = escapePlayer();
            System.out.println(result == -1 ? "IMPOSSIBLE" : result);
        }
    }

    static void spreadFire() {
        while (!fireQueue.isEmpty()) {
            int[] fire = fireQueue.poll();
            int row = fire[0], col = fire[1];

            for (int i = 0; i < 4; i++) {
                int newRow = row + moveRow[i];
                int newCol = col + moveCol[i];

                if (isValid(newRow, newCol) && fireTime[newRow][newCol] == -1 && map[newRow][newCol] != '#') {
                    fireTime[newRow][newCol] = fireTime[row][col] + 1;
                    fireQueue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    static int escapePlayer() {
        while (!playerQueue.isEmpty()) {
            int[] player = playerQueue.poll();
            int row = player[0], col = player[1];

            // 탈출 성공
            if (isExit(row, col)) {
                return playerTime[row][col] + 1;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + moveRow[i];
                int newCol = col + moveCol[i];

                if (isValid(newRow, newCol) && playerTime[newRow][newCol] == -1 && map[newRow][newCol] != '#') {
                    // 불보다 먼저 도달할 수 있어야 이동 가능
                    if (fireTime[newRow][newCol] == -1 || playerTime[row][col] + 1 < fireTime[newRow][newCol]) {
                        playerTime[newRow][newCol] = playerTime[row][col] + 1;
                        playerQueue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return -1; // 탈출 불가능
    }

    static boolean isValid(int row, int col) {
        return row >= 0 && row < h && col >= 0 && col < w;
    }

    static boolean isExit(int row, int col) {
        return row == 0 || row == h - 1 || col == 0 || col == w - 1;
    }
}
