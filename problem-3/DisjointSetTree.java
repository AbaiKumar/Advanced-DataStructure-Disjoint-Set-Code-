/*
 * Author : Abaikumar
 * Description : MakeSet, Find and Union using trees
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
        while (nodes[x].parent != nodes[x]) {
            x = nodes[x].parent.data;
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

public class DisjointSetTree {
    public static void main(String[] args) {

        int n = 5;
        DisjointSet uf = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            uf.makeSet(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Initial Representative of " + i + " is '" + uf.findSet(i).data + "'");
        }

        System.out.println("\nAfter performing Union(0, 1), Union(2,3) and Union(0,2) operations:\n");

        uf.union(0, 1);
        uf.union(2, 3);
        uf.union(0, 2);

        for (int i = 0; i < n; i++) {
            System.out.println("Initial Representative of " + i + " is '" + uf.findSet(i).data + "'");
        }
    }
}
