

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class ChildrenSumProperty {
    Node root;

    boolean isCSum(Node root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;

        int sum = 0;
        if (root.left != null) sum += root.left.key;
        if (root.right != null) sum += root.right.key;

        return (root.key == sum) && isCSum(root.left) && isCSum(root.right);
    }

    public static void main(String[] args) {
        ChildrenSumProperty tree = new ChildrenSumProperty();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.right = new Node(12);
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(5);

        // Adjust the tree to satisfy the children sum property
        tree.root.left.key = 8; // 3 + 5 = 8
        tree.root.right.key = 12; // No children, so it can remain as is
        tree.root.key = 20; // 8 + 12 = 20

        if (tree.isCSum(tree.root)) {
            System.out.println("The tree satisfies the children sum property.");
        } else {
            System.out.println("The tree does not satisfy the children sum property.");
        }
    }
}