package Tree;

public class _38_CountGoodNode {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    public int goodNodes(Node root) {
        return countGoodNodes(root, Integer.MIN_VALUE);
    }

    private int countGoodNodes(Node node, int maxSoFar) {
        if (node == null) {
            return 0;
        }

        int count = 0;
        if (node.val >= maxSoFar) {
            count = 1;
            maxSoFar = node.val;
        }

        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(3);
        root.right.left = new Node(1);
        root.right.right = new Node(5);

        _38_CountGoodNode solution = new _38_CountGoodNode();
        int goodNodesCount = solution.goodNodes(root);

        System.out.println("Number of good nodes: " + goodNodesCount);
    }
}
