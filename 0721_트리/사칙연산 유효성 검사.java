import java.util.Scanner;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        // T=sc.nextInt();

        int N;
        int answer;

        for(int test_case = 1; test_case <= T; test_case++)
        {
            answer = 1;
            N = Integer.parseInt(sc.nextLine());
            for(int i=1; i<=N; i++) {
                String[] s = sc.nextLine().split(" ");

                if(!Character.isDigit(s[1].charAt(0)) && s.length<=2) {     // 연산자가 리프 노드에 있는 경우
                    answer = 0;
                }
            }

            System.out.println("#"+test_case+" "+answer);

        }
    }
}