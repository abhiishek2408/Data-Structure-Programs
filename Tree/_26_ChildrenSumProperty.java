package Tree;

public class _26_ChildrenSumProperty {
    Node root;

    static class Node {
        int val;
        Node left, right;

        public Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    boolean isCSum(Node root) {
        if (root == null) return true;
        if (root.left == null && root.right == null) return true;

        int sum = 0;
        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;

        return (root.val == sum) && isCSum(root.left) && isCSum(root.right);
    }

    public static void main(String[] args) {
        _26_ChildrenSumProperty solution = new _26_ChildrenSumProperty();
        solution.root = new Node(20);
        solution.root.left = new Node(8);
        solution.root.right = new Node(12);
        solution.root.left.left = new Node(3);
        solution.root.left.right = new Node(5);

        if (solution.isCSum(solution.root)) {
            System.out.println("The tree satisfies the children sum property.");
        } else {
            System.out.println("The tree does not satisfy the children sum property.");
        }
    }
}