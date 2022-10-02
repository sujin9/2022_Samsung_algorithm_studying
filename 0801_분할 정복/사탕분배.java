import java.util.Scanner;

class Solution
{
    static long D;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long A = sc.nextLong();
            long B = sc.nextLong();
            long K = sc.nextLong();
            D = A+B;

            long a = (A * power(K)) % D;

            System.out.println("#"+test_case+" "+Math.min(a, D-a));
        }
    }

    static long power(long n) {
        if(n == 0) return 1L;

        long ret = power(n>>1);
        ret *= ret;
        ret %= D;

        if(n%2==1) {
            ret = ret<<1;
            ret %= D;
        }
        return ret;
    }
}