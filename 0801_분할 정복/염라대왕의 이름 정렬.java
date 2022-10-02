import java.util.Scanner;
import java.util.TreeSet;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            TreeSet<String>[] list = new TreeSet[51];   // 최대 길이 50
            for(int i=0;i<list.length;i++) list[i] = new TreeSet<>();

            for(int i=0; i<N; i++) {
                String name = sc.next();
                list[name.length()-1].add(name);
            }

            System.out.println("#"+test_case);
            for (TreeSet<String> l : list)
                for (String s : l)
                    System.out.println(s);

        }
    }
}