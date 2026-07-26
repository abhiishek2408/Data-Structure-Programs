package Tree;

public class _29_LowestCommonAncestor {
    Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    Node lca(Node root, int n1, int n2) {
        if (root == null) return null;

        if (root.val == n1 || root.val == n2)
            return root;

        Node lca1 = lca(root.left, n1, n2);     
        Node lca2 = lca(root.right, n1, n2);

        if (lca1 != null && lca2 != null)
            return root;

        return (lca1 != null) ? lca1 : lca2;
    }

    public static void main(String[] args) {
        _29_LowestCommonAncestor solution = new _29_LowestCommonAncestor();
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.left = new Node(6);
        solution.root.right.right = new Node(7);

        Node lca = solution.lca(solution.root, 4, 5);
        if (lca != null) {
            System.out.println("LCA(4, 5) = " + lca.val);
        } else {
            System.out.println("Keys are not present");
        }
    }
}