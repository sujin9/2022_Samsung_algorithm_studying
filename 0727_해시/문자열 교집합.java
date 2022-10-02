import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int answer = 0;

            HashMap<String, Integer> map = new HashMap<>();

            for(int i=0; i<N; i++) {
                String s = sc.next();
                map.put(s, 1);
            }

            for(int i=0; i<M; i++) {
                String s = sc.next();
                if(map.get(s)!=null) {
                    answer++;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }
}