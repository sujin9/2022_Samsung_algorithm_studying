import java.util.Scanner;

class Solution {

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        // 해시 아니고 라빈카프..ㅜ
        for(int test_case = 1; test_case <= T; test_case++) {
            int answer = 0;
            String B = sc.next();
            String S = sc.next();
            int[] pattern = new int[S.length()];
            
            for(int i=1; i<S.length(); i++) {
                int j = pattern[i-1];
                while(j>0) {
                    if(S.charAt(i) == S.charAt(j)) break;
                    j = pattern[j-1];
                }
                if(S.charAt(i) == S.charAt(j)) pattern[i] = j+1;
                else pattern[i] = 0;
            }
            
            int pivot = 0, i = 0;
            
            while(pivot<B.length()) {
                if(B.charAt(pivot) == S.charAt(i)) {
                    if(i == S.length()-1) {
                        answer++;
                        i = pattern[i];
                    } else 
                        i++;
                    pivot++;
                } else if(i>0)
                    i = pattern[i-1];
                else
                    pivot++;
            }
            
            System.out.println("#"+test_case+" "+answer);
        }
    }
}