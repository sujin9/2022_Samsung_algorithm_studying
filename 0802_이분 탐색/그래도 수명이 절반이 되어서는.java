import java.io.FileInputStream;
import java.util.Scanner;

public class Solution {
    final static int Max = 200009;
    static int[] W, S;
    static int N, K;

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            N = sc.nextInt();
            K = sc.nextInt();

            W = new int[N+1];
            S = new int[K+1];
            for (int i = 1; i <= N; i++)
                W[i] = sc.nextInt();
            for (int i = 1; i <= K; i++)
                S[i] = sc.nextInt();

            int s = 1, e = Max, m;
            while (s < e) {
                m = (s + e) / 2;
                if (isAvailable(m))
                    e = m;
                else
                    s = m + 1;
            }
            System.out.println("#"+test_case+" " + s);
        }
    }

    private static boolean isAvailable(int p) {
        int now = 1, cont = 0;
        for (int i = 1; i <= N; i++) {
            if (W[i] <= p)
                cont++;
            else
                cont = 0;
            if (cont == S[now]) {
                cont = 0;
                if (++now > K)
                    break;
            }
        }
        return now > K;
    }

}