import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            long N = sc.nextLong();
            N *= 2;
            long v = (long) Math.sqrt(N);
            System.out.print("#"+test_case+" ");
            if(v*(v+1)==N) System.out.println(v);
            else System.out.println(-1);
        }
    }
}