
class Node {
    int key;
    Node left, right;
    public int data;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class LowestCommonAncestor {
    Node root;

    Node lca(Node root, int n1, int n2) {
        if (root == null) return null;

        if (root.key == n1 || root.key == n2)   // 1. If it is the same as n1 or n2.
            return root;

        Node lca1 = lca(root.left, n1, n2);     
        Node lca2 = lca(root.right, n1, n2);

        if (lca1 != null && lca2 != null)  // 2. If one of its subtrees contains n1 and the other contains n2.
            return root;

        if (lca1 != null)         // 3. If one of its subtrees contains both n1 and n2.
            return lca1;
        else
            return lca2;          // 4. If none of its subtrees contain any of n1 and n2.
    }

    public static void main(String[] args) {
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        Node lca = tree.lca(tree.root, 4, 5);
        if (lca != null) {
            System.out.println("LCA(4, 5) = " + lca.key);
        } else {
            System.out.println("Keys are not present");
        }
    }
}