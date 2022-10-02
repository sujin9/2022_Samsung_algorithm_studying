import java.util.Scanner;

class Solution
{
    static final int MAX_DAY = 1000001;
    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt(), P = sc.nextInt();
            boolean[] isStudied = new boolean[MAX_DAY];
            for(int i=0; i<N; i++) {
                int day = sc.nextInt();
                isStudied[day] = true;
            }

            int start=1, end=1, cnt=0;
            int max = 0;
            while(end<isStudied.length) {
                if(isStudied[end]) {    // 공부한 날
                    end++;
                    cnt++;
                    max = Math.max(max, cnt);
                } else {
                    if(P==0) {  // 남은 해킹 불가능 -> 앞에 취소, 지금 해킹 !
                        max = Math.max(max, cnt);
                        if(!isStudied[start]) P++;
                        start++;
                        cnt--;
                    } else {
                        P--;
                        end++;
                        cnt++;
                    }
                }
            }
            
            System.out.println("#"+test_case+" "+max);
        }
    }
}