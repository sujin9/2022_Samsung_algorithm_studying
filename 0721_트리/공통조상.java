import java.util.Scanner;

class Node {
    int data;
    int idx_Parent;
    int idx_leftChild, idx_rightChild;

    Node(int data) {
        this.data = data;
        this.idx_Parent = 0;
        this.idx_leftChild = 0;
        this.idx_rightChild = 0;
    }
}

public class Solution {
    static Node[] nodes;
    static int nSubtree;

    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++) {
            int V = sc.nextInt();
            int E = sc.nextInt();
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            nSubtree = 0;
            int idxCommonParent = 1;    // 루트

            nodes = new Node[V+1];
            for(int i=1;i<=V;i++)
                nodes[i] = new Node(i);

            // Tree 생성
            for(int i=0; i<E; i++) {
                int p = sc.nextInt();
                int c = sc.nextInt();

                if(nodes[p].idx_leftChild != 0) nodes[p].idx_rightChild = c;
                else nodes[p].idx_leftChild = c;
                nodes[c].idx_Parent = p;
            }

            // 공통 조상
            boolean[] visited = new boolean[V+1];

            while(v1!=1 || v2!=1) {
                if(v1!=1) {
                    if (visited[v1]) {
                        idxCommonParent = v1;
                        break;
                    }
                    visited[v1] = true;
                    v1 = nodes[v1].idx_Parent;
                }
                if(v2!=1) {
                    if (v2 != 1 && visited[v2]) {
                        idxCommonParent = v2;
                        break;
                    }
                    visited[v2] = true;
                    v2 = nodes[v2].idx_Parent;
                }
            }

            // 서브 트리의 크기
            getNumOfSubTree(idxCommonParent);


           System.out.println("#"+test_case+" "+idxCommonParent+" "+nSubtree);
        }
    }

    static void getNumOfSubTree(int idx) {
        nSubtree++;
        if(nodes[idx].idx_leftChild!=0) getNumOfSubTree(nodes[idx].idx_leftChild);
        if(nodes[idx].idx_rightChild!=0) getNumOfSubTree(nodes[idx].idx_rightChild);
    }
}