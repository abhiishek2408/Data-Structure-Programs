package Tree;

public class _39_SecondMinimumNode { 

    static class Node {
        int val;
        Node left;
        Node right;
        
        Node(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    public int findSecondMinimumValue(Node root) {
        if (root == null) return -1;
        return findSecondMin(root, root.val);
    }

    private int findSecondMin(Node node, int minValue) {
        if (node == null) return -1;
        if (node.val > minValue) return node.val;
        
        int leftSecondMin = findSecondMin(node.left, minValue);
        int rightSecondMin = findSecondMin(node.right, minValue);
        
        if (leftSecondMin == -1) return rightSecondMin;
        if (rightSecondMin == -1) return leftSecondMin;
        
        return Math.min(leftSecondMin, rightSecondMin);
    }
    
    public static void main(String[] args) {
        _39_SecondMinimumNode solution = new _39_SecondMinimumNode();
        solution.root = new Node(1);
        solution.root.left = new Node(2);
        solution.root.right = new Node(3);
        solution.root.left.left = new Node(4);
        solution.root.left.right = new Node(5);
        solution.root.right.left = new Node(6);
        solution.root.right.right = new Node(7);
    
        System.out.println("Second minimum value in the binary tree is " + solution.findSecondMinimumValue(solution.root));
    }
}
