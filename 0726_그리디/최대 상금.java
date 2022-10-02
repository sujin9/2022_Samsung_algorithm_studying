import java.util.Scanner;

class Solution {

    static char[] nums;
    static int len;
    static int change;
    static int answer;

    public static void main(String args[]) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            nums = sc.next().toCharArray();
            len = nums.length;
            change = sc.nextInt();
            answer = 0;

            getAnswer(0, change);

            System.out.println("#"+test_case+" "+answer);
        }
    }

    public static void getAnswer(int idx, int cnt) {
        if(cnt%2==0)
            answer = Math.max(answer, Integer.parseInt(String.valueOf(nums)));

        if(cnt == 0) {
            return;
        }
        if(idx == len-1) {
            if(cnt%2==1) {
                swap(len-1, len-2);
                answer = Math.max(answer, Integer.parseInt(String.valueOf(nums)));
                swap(len-1, len-2);
            }
            return;
        }

        getAnswer(idx+1, cnt);

        for(int i=idx+1; i<len; i++) {
            if(nums[idx] <= nums[i]) {
                swap(idx, i);
                getAnswer(idx+1, cnt-1);
                swap(idx, i);
            }
        }

    }

    public static void swap(int a, int b) {
        char t = nums[a];
        nums[a] = nums[b];
        nums[b] = t;
    }
}