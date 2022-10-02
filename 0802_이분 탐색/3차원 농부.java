import java.util.Arrays;
import java.util.Scanner;

class Solution
{
    static int[] cows;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(), M = sc.nextInt();
            int dx = Math.abs(sc.nextInt() - sc.nextInt());     // 소와 말의 x축 거리, dy는 어차피 0, 고정값
            cows = new int[N];
            for(int i=0; i<N; i++) cows[i] = sc.nextInt();
            Arrays.sort(cows);

            int dz = Integer.MAX_VALUE;
            int cnt = 0;

            for(int i=0; i<M; i++) {
                int horse = sc.nextInt();
                int idx = findCowIndex(horse);

                if(idx>=0 && idx<N) {
                    int d = Math.abs(cows[idx] - horse);
                    if(dz>d) { dz = d; cnt = 1; } // 새로운 최소 거리
                    else if(dz == d) cnt++;
                }

                if(idx>0 && idx<N) {
                    int d = Math.abs(cows[idx-1] - horse);
                    if(dz>d) { dz=d; cnt=1; }
                    else if(dz == d) cnt++;
                }
            }

            System.out.println("#"+test_case+" "+(dx+dz)+" "+cnt);
        }
    }

    static int findCowIndex(int h) {
        int left=0, right=cows.length-1;

        if(h<cows[left]) return 0;
        if(h>cows[right]) return right;

        int mid = (left+right)/2;
        while(left<right) {
            mid = (left+right)/2;
            if(cows[mid]>=h) right = mid;
            else left = mid+1;
        }

        if(cows[mid]<h) mid++;
        return mid;
    }
}