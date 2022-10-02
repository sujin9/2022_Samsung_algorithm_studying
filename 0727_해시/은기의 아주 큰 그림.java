import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            // 입력
            int H = sc.nextInt();
            int W = sc.nextInt();
            int N = sc.nextInt();
            int M = sc.nextInt();


            int[][] pattern = new int[H][W];
            int[][] drawing = new int[N][M];
            int[][] pHash = new int[2000][2000];
            int[][] dHash = new int[2000][2000];

            // 꿈에서의 그림 입력
            for(int i=0; i<H; i++) {
                char[] c = sc.next().toCharArray();
                for(int j=0; j<W; j++) {
                    if(c[j]=='o') pattern[i][j] = 1;
                    else pattern[i][j] = 0;
                }
            }

            // 선생님의 그림 입력
            for(int i=0; i<N; i++) {
                char[] c = sc.next().toCharArray();
                for(int j=0; j<M; j++) {
                    if(c[j]=='o') drawing[i][j] = 1;
                    else drawing[i][j] = 0;
                }
            }

            // 해시값 계산
            for(int i=0; i<H; i++) pHash[0][i] = getHash(pattern[i], W, 4);
            int patternHash = getHash(pHash[0], H, 5);

            int mC = getMul(W, 4);
            int mR = getMul(H, 5);
            for(int i=0; i<N; i++) {
                pHash[0][i] = getHash(drawing[i], W, 4);
                for(int j = 1; j < M - W + 1; j++) {
                    pHash[j][i] = getNext(pHash[j-1][i], drawing[i][j-1], mC, drawing[i][j+W-1], 4);
                }
            }
            for(int i = 0; i < M - W + 1; i++) {
                dHash[0][i] = getHash(pHash[i], H, 5);
                for(int j = 1; j < N - H + 1; j++) {
                    dHash[j][i] = getNext(dHash[j-1][i], pHash[i][j-1], mR, pHash[i][j+H-1], 5);
                }
            }

            // 해시값 비교하기
            int cnt = 0;
            for(int i = 0; i < N - H + 1; i++) for(int j = 0; j < M - W + 1; j++)
                if(dHash[i][j] == patternHash) cnt++;

            System.out.println("#"+test_case+" "+cnt);
        }
    }

    static int getHash(int[] piv, int n, int shift) {
        long hash = 0;
        for(int i=0; i<n; i++)
            hash = (hash<<shift) + hash + piv[i];
        return (int) hash % (1<<30 - 1);
    }

    static int getMul(int n, int shift) {
        long r = 1;
        for(int i=1; i<n; i++)
            r = (r << shift) + r;
        return (int) r % (1<<30 - 1);
    }

    static int getNext(int prev, int sub, int m, int add, int shift) {
        long hash = prev - (sub * m);
        hash = (hash << shift) + hash + add;
        return (int) hash % (1<<30 - 1);
    }
}