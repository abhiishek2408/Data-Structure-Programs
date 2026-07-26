package Tree;

public class _05_SizeBinaryTree {

    static class Node {
        int val;
        Node left;
        Node right;
    
        Node(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }

    public int countNodes(Node root) {
        if(root == null) {
            return 0;
        }

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
    
        _05_SizeBinaryTree solution = new _05_SizeBinaryTree();
        int count = solution.countNodes(root);
        System.out.println("Number of nodes: " + count);
    }
}
