import java.util.Scanner;
import java.io.FileInputStream;
import java.util.HashSet;

class Solution {
	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
            int n = sc.nextInt();
			System.out.println("#"+test_case+" "+getCount(n));
		}
	}
    
    public static int getCount(int n) {
        HashSet<Integer> seenNumbers = new HashSet<>();
        int num = n;
        
        while(true) {
        	int temp = num;
            while(temp>0) {
            	seenNumbers.add(temp%10);
                temp /= 10;
            }
            if(seenNumbers.size()>=10) break;
            
            num += n;
        }
        
        return num;
    }
}