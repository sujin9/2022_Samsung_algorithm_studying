import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class Solution
{
    public static final int R = 20171109;
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int answer = 0;

            PriorityQueue<Integer> smaller = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> bigger = new PriorityQueue<>();
            int N = sc.nextInt();
            int A = sc.nextInt();

            for(int i=0; i<N; i++) {
                int x1 = sc.nextInt(), x2 = sc.nextInt();

                if(A>x1) smaller.add(x1); else bigger.add(x1);
                if(A>x2) smaller.add(x2); else bigger.add(x2);

                while (smaller.size() > bigger.size()) {
                    bigger.add(A);
                    A = smaller.poll();
                }
                while (smaller.size() < bigger.size()) {
                    smaller.add(A);
                    A = bigger.poll();
                }

                answer = (answer + A) % R;
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}