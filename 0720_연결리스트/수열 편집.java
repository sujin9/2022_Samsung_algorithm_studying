import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("C://Users/sujin/Downloads/sample_input.txt"));

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++) {

            LinkedList<Integer> seq = new LinkedList<>();

            int N = sc.nextInt();
            int M = sc.nextInt();
            int L = sc.nextInt();

            for(int i=0; i<N; i++) seq.add(sc.nextInt());

            for(int i=0; i<M; i++) {
                String op = sc.next();

                if(op.equals("I")) {
                    int index = sc.nextInt();
                    int value = sc.nextInt();
                    seq.add(index, value);
                } else if(op.equals("D")) {
                    int index = sc.nextInt();
                    seq.remove(index);
                } else if(op.equals("C")) {
                    int index = sc.nextInt();
                    int value = sc.nextInt();
                    seq.remove(index);
                    seq.add(index, value);
                }
            }

            System.out.print("#"+test_case+" ");
            if(seq.size()<L) System.out.println(-1);
            else System.out.println(seq.get(L));

        }
    }
}