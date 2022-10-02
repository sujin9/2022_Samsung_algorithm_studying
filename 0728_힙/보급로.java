import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Pos implements Comparable {
    int x, y;
    int pit;

    Pos(int x, int y, int pit) {
        this.x = x;
        this.y = y;
        this.pit = pit;
    }

    @Override
    public int compareTo(Object o) {
        Pos p = (Pos) o;
        if (this.pit > p.pit) return 1;
        else if (this.pit == p.pit) return 0;
        else return -1;
    }
}

class Solution {
    final static int[] DX = {-1, 0, 1, 0};
    final static int[] DY = {0, -1, 0, 1};

    static int N;
    static int[][] map;
    static int[][] minPit; // 해당 위치까지 경로 중 가장 적은 깊이

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            minPit = new int[N][N];

            for (int i = 0; i < N; i++) {
                // map 입력
                String[] t = sc.next().split("");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(t[j]);
                }

                // minPit 초기화
                Arrays.fill(minPit[i], Integer.MAX_VALUE);
            }

            bfs();

            System.out.println("#" + test_case + " " + minPit[N-1][N-1]);
        }
    }

    static void bfs() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        pq.add(new Pos(0, 0, 0));
        minPit[0][0] = 0;

        while (!pq.isEmpty()) {
            Pos p = pq.poll();
            int x = p.x, y = p.y, pit = p.pit;

            if (x == N - 1 && y == N - 1) {
                minPit[x][y] = Math.min(minPit[x][y], pit);
                continue;
            }

            if (minPit[N-1][N-1] <= pit) continue;   // 이미 최적의 경우가 아님

            for (int i = 0; i < 4; i++) {
                int nx = x + DX[i], ny = y + DY[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;

                int nPit = pit + map[nx][ny];
                if (minPit[nx][ny] < nPit || minPit[nx][ny] == Integer.MAX_VALUE) {  // 더 최적의 경우 or 방문한 적 X
                    minPit[nx][ny] = nPit;
                    pq.add(new Pos(nx, ny, nPit));
                }
            }
        }
    }
}