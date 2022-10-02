import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.io.FileInputStream;

class Coord {
    int x, y;

    Coord(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {

    static int N;
    static String[][] map;
    static int[][] numOfMines;  // 각 칸의 주변 지뢰 개수, 음수일 경우 이미 클릭된 칸
    static int totalMines;      // 총 지뢰 개수
    static int clickedSquare;   // 클릭된 칸의 개수

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("C:\\Users\\sujin\\Downloads/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
        int ans;

        for (int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new String[N][N];
            numOfMines = new int[N][N];
            totalMines = 0;
            clickedSquare = 0;
            ans = 0;

            for (int i = 0; i < N; i++) {
                map[i] = sc.next().split("");
            }

            getNumOfMine();

            // 주변 지뢰 0인 부분들 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j].equals("*")) totalMines++;
                    else if (numOfMines[i][j] == 0) {
                        //    if(!map[i][j].equals("*")&&numOfMines[i][j]==0) {
                        clickMap(i, j);
                        ans++;
                    }
                }
            }

            // 나머지 부분들 클릭
            /*for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!map[i][j].equals("*") && numOfMines[i][j]>0)
                        ans++;
                }
            }*/
						// 위의 반복문 대신 이렇게 게산..
            ans += (N * N - totalMines) - clickedSquare;
            System.out.println("#" + test_case + " " + ans);
        }
    }

    static void clickMap(int x, int y) {
        Queue<Coord> q = new LinkedList<>();
        q.add(new Coord(x, y));
        numOfMines[x][y] = -1;
            clickedSquare++;

        while (!q.isEmpty()) {
            Coord curr = q.poll();

            for (int i = -1; i <= 1; i++) {
                for (int j = -1; j <= 1; j++) {
                    int dx = curr.x + i, dy = curr.y + j;
                    if (dx < 0 || dx >= N || dy < 0 || dy >= N) continue;
                    if (map[dx][dy].equals("*")) continue;
                    if (numOfMines[dx][dy] < 0) continue;

                    if (numOfMines[dx][dy] == 0)
                        q.add(new Coord(dx, dy));
                    numOfMines[dx][dy] = -1;
                    clickedSquare++;
                }
            }
        }

    }

    static void getNumOfMine() {
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {

                if (map[x][y].equals(".")) {
                    int count = 0;

                    for (int i = -1; i <= 1; i++) {
                        for (int j = -1; j <= 1; j++) {
                            if (i == 0 && j == 0) continue;  // 자기 자신
                            int dx = x + i, dy = y + j;
                            if (dx < 0 || dx >= N || dy < 0 || dy >= N) continue;

                            if (map[dx][dy].equals("*")) count++;
                        }
                    }
                    numOfMines[x][y] = count;
                }
            }
        }
    }
}