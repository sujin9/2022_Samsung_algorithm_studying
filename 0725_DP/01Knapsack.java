import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int N;
        int K;

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();

            int[] v = new int[N];
            int[] c = new int[N];
            int[][] dp = new int[N+1][K+1];

            for(int i=0; i<N; i++) {
                v[i] = sc.nextInt();
                c[i] = sc.nextInt();
            }

            for(int i=1; i<=N; i++) {
                for(int j=1; j<=K; j++) {
                    if(v[i-1]>j) {
                        dp[i][j] = dp[i-1][j];
                    }
                    else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-v[i-1]]+c[i-1]);
                    }
                }
            }

            System.out.println("#"+test_case+" "+dp[N][K]);
        }
    }
}