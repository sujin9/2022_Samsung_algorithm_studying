import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N, M;
            N = sc.nextInt();
            M = sc.nextInt();
            
            String answer = (isSwitchTurnedOn(N, M))?"ON":"OFF";
            System.out.println("#"+test_case+" "+answer);
		}
	}
    
    public static boolean isSwitchTurnedOn(int N, int M) {
        
        for(int i=0; i<N; i++) {
            if(M<=0) return false;
            
        	int v = M % 2;
            if(v==0) return false;
            
            M /= 2;
        }
        
    	return true;
    }
}