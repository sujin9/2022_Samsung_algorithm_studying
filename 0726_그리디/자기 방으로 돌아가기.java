import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] corridor = new int[200];
            int answer = 0;

            for (int i = 0; i < N; i++) {
                int r1 = sc.nextInt();
                int r2 = sc.nextInt();

                if (r2 < r1) {
                    int t = r1;
                    r1 = r2;
                    r2 = t;
                }

                for(int j=(r1-1)/2; j<=(r2-1)/2; j++)
                    corridor[j]++;
            }
            
            for(int a:corridor) {
                answer = Math.max(answer, a);
            }
            System.out.println("#"+test_case+" "+answer);
        }
    }
}