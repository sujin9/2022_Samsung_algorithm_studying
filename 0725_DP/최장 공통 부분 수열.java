import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            String s1 = sc.next();
            String s2 = sc.next();
            int[][] dp = new int[s1.length()+1][s2.length()+1];
            int i, j=0;
            for(i=1; i<=s1.length(); i++) {
                for(j=1; j<=s2.length(); j++) {
                    if(s1.charAt(i-1) == s2.charAt(j-1)) {
                        dp[i][j] = dp[i-1][j-1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }

            System.out.println("#"+test_case+" "+dp[i-1][j-1]);
        }
    }
}