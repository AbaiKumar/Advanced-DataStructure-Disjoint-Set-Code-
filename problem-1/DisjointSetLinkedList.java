/*  Author : Abaikumar
 *  Problem statement : MakeSet, Find and Union using linked lists
 */

class Node { // node
  int data;
  Node next;

  Node(int data) {
    this.data = data;
    this.next = null;
  }
}

class DisjointSet {

  Node[] nodes; // list of nodes

  public DisjointSet(int n) {
    nodes = new Node[n];
    for (int i = 0; i < n; i++) {
      nodes[i] = new Node(i);
    }
  }

  public void makeSet(int x) {
    nodes[x].next = nodes[x]; // self-loop
  }

  public Node findSet(int x) {
    Node current = nodes[x];
    while (current.next != current) {
      current = current.next;
    }
    return current;
  }

  public void union(int x, int y) {
    Node xSet = findSet(x);
    Node ySet = findSet(y);

    if (xSet != ySet) {
      xSet.next = ySet;
    }
  }
}

public class DisjointSetLinkedList {

  public static void main(String[] args) {
    int n = 5;
    DisjointSet uf = new DisjointSet(n);
    for (int i = 0; i < n; i++) {
      uf.makeSet(i);
    }
    System.out.println("\nPerfoming Union(0, 1) and Union(2,3)");
    uf.union(0, 1);
    uf.union(2, 3);

    for (int i = 0; i < n; i++) {
      System.out.println(uf.findSet(i).data);
    }
  }
}
