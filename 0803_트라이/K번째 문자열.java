import java.util.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int K = sc.nextInt();
            String str = sc.next();
            int len = str.length();
            String[] suffix = new String[len];
            int[] lcp = new int[len];

            for(int i=0;i<len;i++) suffix[i] = str.substring(i, len);
            Arrays.sort(suffix);

            for(int i=1; i<len;i++) {
                lcp[i] = getLCP(suffix[i-1], suffix[i]);
            }

            int cnt = 0;
            String answer = "none";
            for(int i=0; i<len; i++) {
                cnt += suffix[i].length() - lcp[i];
                if(cnt>=K) {
                    answer = suffix[i].substring(0, suffix[i].length()-cnt+K);
                    break;
                }
            }

            System.out.println("#"+test_case+" "+answer);
        }
    }

    static int getLCP(String s1, String s2) {
        int cnt = 0;
        int len = Math.min(s1.length(), s2.length());

        for(int i=0; i<len; i++) {
            if(s1.charAt(i) != s2.charAt(i)) break;
            cnt++;
        }

        return cnt;
    }
}