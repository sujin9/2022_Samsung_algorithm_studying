import java.util.Scanner;
import java.io.FileInputStream;
import java.util.Arrays;
class Solution {
    
    static int n;
    static char[] tree;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = 10;
//		T=sc.nextInt();
	
		for(int test_case = 1; test_case <= T; test_case++) {
            n = Integer.parseInt(sc.nextLine());
            tree = new char[n+1];
            for(int i=1; i<=n; i++) {
	            String[] s = sc.nextLine().split(" ");
            	tree[i] = s[1].charAt(0);
            }        
            System.out.print("#"+test_case+" ");
            inOrder(1);
            System.out.println();
		}
	}
    
    public static void inOrder(int index) {
		if(index > n) return;
        inOrder(2*index);
        System.out.print(tree[index]);
        inOrder(2*index+1);
    }
}