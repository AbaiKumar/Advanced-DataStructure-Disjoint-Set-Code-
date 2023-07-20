/*  Author : Abaikumar
 *  Problem statement : Variation of 1 with tail pointer
 */

class Node {
    int val;
    Node next, rep;

    Node(int val) {
        this.val = val;
    }
}

// A list has a pointer to head and tail
class SetItem {
    Node head, tail;
}

// To represent union SetItem
class DisjointSet {

    SetItem arr[];

    DisjointSet(int n) {
        arr = new SetItem[n];
    }

    // To make a disjoint set
    public void makeSet(int a) {
        arr[a] = new SetItem();
        arr[a].head = new Node(a);
        arr[a].tail = arr[a].head;
        arr[a].head.rep = arr[a].head;
    }

    // To find representative of a key
    public SetItem find(int key) {
        for (SetItem i : arr) {
            Node tmp = i.head;
            while (tmp != null) {
                if (tmp.val == key) {
                    return i;
                }
                tmp = tmp.next;
            }
        }
        return null;
    }

    // union function for joining two subSetItems
    // of a universe. Merges SetItem2 into SetItem1
    // and deletes SetItem1.
    public void union(int x, int y) {
        SetItem set1 = find(x);
        SetItem set2 = find(y);
        if (set1 != set2) {
            Node cur = set2.head;
            while (cur != null) {// change representative
                cur.rep = set1.head;
                cur = cur.next;
            }
            set1.tail.next = set2.head;// join sets
            set1.tail = set2.tail;
        }
        set2.head = null;
        set2.tail = null;
    }
}

/**
 * DisjointSetLinkedListWithTailPtr
 */
public class DisjointSetLinkedListWithTailPtr {
    public static void main(String[] args) {
        int n = 4;
        DisjointSet a = new DisjointSet(n);
        for (int i = 0; i < n; i++) {
            a.makeSet(i);
        }

        for (int i = 0; i < n; i++) {
            System.out.println("find(" + i + ") " + a.find(i).head.rep.val);
        }
        System.out.println("\nPerfoming Union(0, 1)");
        a.union(0, 1);

        for (int i = 0; i < n; i++) {
            System.out.println("find(" + i + ") " + a.find(i).head.rep.val);
        }
        System.out.println("\nPerfoming Union(0, 1)");
        a.union(2, 3);

        for (int i = 0; i < n; i++) {
            System.out.println("find(" + i + ") " + a.find(i).head.rep.val);
        }
        System.out.println("\nPerfoming Union(0, 3)");
        a.union(0, 3);

        for (int i = 0; i < n; i++) {
            System.out.println("find(" + i + ") " + a.find(i).head.rep.val);
        }
    }
}