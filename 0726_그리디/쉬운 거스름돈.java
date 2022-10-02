import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int[] numOfMoney = new int[8];

            for(int i=0; i<8; i++) {
                if(N < money[i]) continue;

                numOfMoney[i] = N / money[i];
                N %= money[i];
            }

            System.out.println("#"+test_case);
            for(int n:numOfMoney) {
                System.out.print(n+" ");
            }
            System.out.println();
        }
    }
}