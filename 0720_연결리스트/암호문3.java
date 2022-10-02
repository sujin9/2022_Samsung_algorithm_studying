import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {

    public static void main(String args[]) throws Exception {

        System.setIn(new FileInputStream("C://Users/sujin/Downloads/input.txt"));

        Scanner sc = new Scanner(System.in);
        int T = 10;
    //    T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {

            LinkedList<String> passwords = new LinkedList<>();

            int N = sc.nextInt();   // 원본 암호문 길이
            for(int i=0; i<N; i++) passwords.add(sc.next());    // 원본 암호문

            int M = sc.nextInt();   // 명령어의 개수
            for(int m=0; m<M; m++) {    // 명령어
                String op = sc.next();

                if(op.equals("I")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    for (int i = 0; i < y; i++) {
                        passwords.add(x+i, sc.next());
                    }

                } else if(op.equals("D")) {
                    int x = sc.nextInt();
                    int y = sc.nextInt();

                    for (int i = 0; i < y; i++) {
                        passwords.remove(x);
                    }

                } else if(op.equals("A")) {
                    int y = sc.nextInt();

                    for(int i=0; i<y; i++) {
                        passwords.add(sc.next());
                    }
                }
            }

            System.out.println("#"+test_case);
            for(int i=0; i<10; i++) {
                System.out.print(passwords.get(i)+" ");
            }
            System.out.println();

        }
    }

}