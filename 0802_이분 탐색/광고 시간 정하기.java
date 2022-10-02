import java.util.Scanner;

class Solution
{
    static class Peek {
        int start;
        int end;
        int acc;    // 누적 피크시간

        Peek(int start, int end, int acc) {
            this.start = start;
            this.end = end;
            this.acc = acc;
        }
    }

    static Peek[] peeks;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int L = sc.nextInt();
            int N = sc.nextInt();
            peeks = new Peek[N];
            int acc = 0;
            for(int i=0; i<N; i++) {
                int s = sc.nextInt(), e = sc.nextInt();
                acc += e-s;
                peeks[i] = new Peek(s, e, acc);
            }

            int max = 0;
            for(int i=0; i<N; i++) {
                int s = peeks[i].start, e = s+L;
                Peek p = findLastPeek(e);
                int a = p.acc - peeks[i].acc + peeks[i].end - peeks[i].start;
                if(p.end > e && p.start < e) a -= p.end-e;
                else if(p.end > e) a -= p.end-p.start;

                max = Math.max(max, a);
            }

            System.out.println("#"+test_case+" "+max);
        }
    }

    static Peek findLastPeek(int end) {
        int s = 0, e = peeks.length-1;

        while(s<e) {
            int mid = (s+e)/2;
            if(peeks[mid].end >= end) e = mid;
            else s = mid+1;
        }

        return peeks[e];
    }
}