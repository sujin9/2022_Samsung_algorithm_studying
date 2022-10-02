import java.util.PriorityQueue;
import java.util.Scanner;

class Solution
{
    static class Pair implements Comparable {
        int count, leftNumber;
        Pair(int count, int leftNumber) {
            this.count = count; this.leftNumber = leftNumber;
        }

        @Override
        public int compareTo(Object o) {
            Pair p = (Pair) o;
            if(this.count > p.count) return 1;
            else if(this.count == p.count) return 0;
            else return -1;
        }
    }

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++) A[i] = sc.nextInt();
            int K = sc.nextInt();

            PriorityQueue<Pair> pq = new PriorityQueue<>();
            pq.add(new Pair(0, K));

            while(pq.peek().leftNumber != 0) {
                Pair p = pq.poll();
                pq.add(new Pair(p.count+p.leftNumber, 0));
                for(int i=0; i<N; i++) {
                    pq.add(new Pair(p.count+p.leftNumber%A[i], p.leftNumber/A[i]));
                }
            }

            System.out.println("#"+test_case+" "+pq.peek().count);
        }
    }
}