import java.util.*;

class Solution
{
    static class Node {
        int parent;
        int depth;
        List<Integer> children;

        Node() {    // 루트 노드
            this.parent = 0;
            this.depth = 0;
            this.children = new ArrayList<>();
        }

        Node(int parent) {
            this.parent = parent;
            this.depth = nodes.get(parent).depth + 1;
            this.children = new ArrayList<>();
        }
    }

    static List<Node> nodes;

    public static void main(String args[]) throws Exception
    {

        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = sc.nextInt();
            nodes = new ArrayList<>();

            nodes.add(new Node());
            for(int i=1; i<N; i++) {
                int v = sc.nextInt()-1;
                nodes.add(new Node(v));
                nodes.get(v).children.add(i);
            }

            temp = new HashMap<>();
            Queue<Integer> q = new LinkedList<>();
            q.add(0);
            int p = 0;
            long cnt = 0;

            while(!q.isEmpty()) {
                int idx = q.poll();
                int lca = getLCA(idx, p);

                cnt += nodes.get(idx).depth + nodes.get(p).depth - nodes.get(lca).depth * 2L;
                p = idx;
                for(int i=0; i<nodes.get(idx).children.size(); i++) q.add(nodes.get(idx).children.get(i));
            }

            System.out.println("#"+test_case+" "+cnt);
        }
    }

    static int getLCA(int a, int b) {
        if(a==b) return a;

        int dA = nodes.get(a).depth, dB = nodes.get(b).depth;
        if(dA>dB) {
            int t = a;
            a = b;
            b = t;
            t = dA;
            dA = dB;
            dB = t;
        }
        while(dA<dB) {
            b = nodes.get(b).parent;
            dB--;
        }

        return findLCA(a, b);
    }

    static Map<Long, Integer> temp;
    static int findLCA(int a, int b) {
        if(a==b) return a;

        long key = (long)a*100000 + (long)b;
        if(temp.containsKey(key)) return temp.get(key);

        a = nodes.get(a).parent; b = nodes.get(b).parent;
        int r = findLCA(a, b);

        temp.put(key, r);
        return r;
    }
}