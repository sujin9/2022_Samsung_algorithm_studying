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
            int N = sc.nextInt();
            long M = sc.nextLong();
            long[] candies = new long[N];
            for(int i=0; i<N; i++) candies[i] = sc.nextLong();

            long min = 0, max = 1000000000000000000L;
            while(min!=max) {
                long bag = (min+max+1)/2;
                long nCandy = 0;
                for(long candy : candies) {
                    nCandy += candy/bag;
                }

                if(nCandy<M) {
                    max = bag-1;
                } else {
                    min = bag;
                }
            }

            System.out.println("#"+test_case+" "+max);
        }
    }
}