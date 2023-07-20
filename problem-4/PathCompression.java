/*
 * Author : Abaikumar
 * Description : Variation using Path Compression
 * References : https://www.techiedelight.com/disjoint-set-data-structure-union-find-algorithm/
 */

 class Node {
    int data;
    Node parent;

    public Node(int data) {
        this.data = data;
        this.parent = this; // Initially, each node is its own parent.
    }
}

class DisjointSet {
    Node[] nodes;

    public DisjointSet(int n) {
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
    }

    public void makeSet(int x) {
        nodes[x].parent = nodes[x];
    }

    public Node findSet(int x) {
        if (nodes[x].parent != nodes[x]) {
            nodes[x].parent = findSet(nodes[x].parent.data); // Path compression
        }
        return nodes[x].parent;
    }

    public void union(int x, int y) {
        Node xRoot = findSet(x);
        Node yRoot = findSet(y);

        if (xRoot != yRoot) {
            xRoot.parent = yRoot;
        }
    }
}

public class PathCompression {
    public static void main(String[] args) {
        
        int n = 5;
        DisjointSet uf = new DisjointSet(n);
        for(int i = 0;i < n;i++) {
            uf.makeSet(i);
        }

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(0, 2);

        for(int i = 0;i < n;i++) {
            System.out.println(uf.findSet(i).data); // 8
        }
    } 
}
