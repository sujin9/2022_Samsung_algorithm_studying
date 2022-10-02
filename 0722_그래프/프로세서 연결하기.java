import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileInputStream;

class Core {
    int x, y;

    Core(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
class Solution {

    final static int[] dx = {-1, 0, 1, 0};
    final static int[] dy = {0, -1, 0, 1};

    static int N;
    static int[][] map;
    static ArrayList<Core> cores;
    static int minWireNum, maxCoreNum;

    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\sujin\\Downloads/sample_input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            map = new int[N][N];
            cores = new ArrayList<>();

            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    map[i][j] = sc.nextInt();

                    if(map[i][j]==1) {
                        if(!(i==0 || j==0 || i==N-1 || j==N-1))
                            cores.add(new Core(i,j));
                    }
                }
            }

            minWireNum = Integer.MAX_VALUE;
            maxCoreNum = Integer.MIN_VALUE;
            connectWire(0,0,0);

            System.out.println("#"+test_case+" "+minWireNum);
        }
    }

    static void connectWire(int idx, int nCore, int nWire) {
        if(idx == cores.size()) {
            if(nCore>maxCoreNum) {
                maxCoreNum = nCore;
                minWireNum = nWire;
            } else if(nCore==maxCoreNum) {
                if(nWire<minWireNum) {
                    minWireNum = nWire;
                }
            }
            return;
        }

        int x = cores.get(idx).x;
        int y = cores.get(idx).y;

        for(int d=0; d<4; d++) {
            int wireCnt = 0;
            int nx = x, ny = y;

            // 한 방향으로 전선 이동
            while(true) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N) break;

                if (map[nx][ny] == 1) {
                    wireCnt = 0;
                    break;
                }

                wireCnt++;
            }

            if(wireCnt!=0) {    // 전선 그리기 성공
                drawWire(x, y, dx[d], dy[d], wireCnt);
                connectWire(idx+1, nCore+1, nWire+wireCnt);
                removeWire(x, y, dx[d], dy[d], wireCnt);
            } else {            // 전선 그리기 실패
                connectWire(idx+1, nCore, nWire);
            }
        }

    }

    static void drawWire(int x, int y, int dx, int dy, int wireLen) {
        for(int i=0; i<wireLen; i++) {
            x+=dx;
            y+=dy;
            map[x][y] = 1;
        }
    }

    static void removeWire(int x, int y, int dx, int dy, int wireLen) {
        for(int i=0; i<wireLen; i++) {
            x+=dx;
            y+=dy;
            map[x][y] = 0;
        }
    }
}