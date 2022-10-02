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
            List<String> list = new LinkedList<>();
            for(int i=0; i<str.length(); i++)
                list.add(str.substring(i));

            Collections.sort(list);
            System.out.println("#"+test_case+" "+list.get(K-1));
        }
    }

}