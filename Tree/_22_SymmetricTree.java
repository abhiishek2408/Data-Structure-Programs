package Tree;

public class _22_SymmetricTree {

    static class Node {
        int val;
        Node left, right;
    
        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public boolean isSymmetric(Node root) {
        if (root == null) return true;
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(Node t1, Node t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        return (t1.val == t2.val)
            && isMirror(t1.left, t2.right)
            && isMirror(t1.right, t2.left);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        _22_SymmetricTree solution = new _22_SymmetricTree();
        boolean result = solution.isSymmetric(root);
        System.out.println("Is the tree symmetric? " + result);
    }
}
