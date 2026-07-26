package Tree;

public class _04_HeightBinaryTree {

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

    public int getHeight(Node root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getHeight(root.left) , getHeight(root.right));
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        _04_HeightBinaryTree solution = new _04_HeightBinaryTree();
        int height = solution.getHeight(root);
        System.out.println("Height of Binary Tree is: " + height);
    }
}
