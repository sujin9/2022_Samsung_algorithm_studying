import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
    static final int R = 1000000007;
    static int[][] cases;
    
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			String pplInCharge = sc.next();
      cases = new int[pplInCharge.length()][16];
            
      System.out.println("#"+test_case+" "+getNumOfCases(pplInCharge));
		}
	}
    
    public static int getNumOfCases(String people) {
        int cnt = 0;
        int days = people.length();
        
        for(int day=0; day<days; day++) {
        	int pInCharge = 1 << (people.charAt(day)-'A');
            
            for(int i=0; i<16; i++) {
                if(day==0) {	// 첫날 : 관리자와 A 포함
                	if( (i&pInCharge)!=0 && (i&1)!=0) {
                    	cases[day][i] = 1;
                    }
                }
                else {	// 첫날 이후 : 관리자와 전날 나온 사람 포함
                	 if(cases[day-1][i] != 0) {
                     	for(int j=0; j<16; j++) {
                        	if( (j&pInCharge)!=0 && (j&i)!=0) {
                            	cases[day][j] += cases[day-1][i];
                                cases[day][j] %= R;
                            }
                        }
                     }
                }
        
            }
        }
        
        for(int i=0; i<16; i++) {
        	cnt += cases[days-1][i];
            cnt %= R;
        }
        
        return cnt;
    }
}