import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

class Node{
    String data;
    int leftIdx;
    int rightIdx;

    public Node(String data) {
        this.data = data;
        this.leftIdx = 0;
        this.rightIdx = 0;
    }

    public Node(String data, int left, int right) {
        this.data = data;
        this.leftIdx = left;
        this.rightIdx = right;
    }
}

public class Solution {
    static int N;
    static Node[] cal;
    static Stack<Double> stack;

    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T = 10;
        // T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(sc.nextLine());
            cal = new Node[N+1];
            for(int i=1; i<=N; i++) {
                String[] s = sc.nextLine().split(" ");
                if(s.length<=2) cal[i] = new Node(s[1]);
                else cal[i] = new Node(s[1], Integer.parseInt(s[2]), Integer.parseInt(s[3]));
            }

            stack = new Stack<>();
            postOrder(1);

            System.out.println("#"+test_case+" "+stack.peek().intValue());
        }
    }

    static void postOrder(int index) {
        if(index>N) return;

        if(cal[index].leftIdx!=0) postOrder(cal[index].leftIdx);
        if(cal[index].rightIdx!=0) postOrder(cal[index].rightIdx);

        Node n = cal[index];
        String s = n.data;

        if(s.equals("+") || s.equals("-") || s.equals("/") || s.equals("*")) {
            Double n2 = stack.pop();
            Double n1 = stack.pop();

            switch(s) {
                case "+":
                    stack.push(n1+n2);
                    break;
                case "-":
                    stack.push(n1-n2);
                    break;
                case "*":
                    stack.push(n1*n2);
                    break;
                case "/":
                    stack.push(n1/n2);
                    break;
            }
        } else {
            stack.push(Double.parseDouble(s));
        }
    }
}