package BinarySearchTree;
import java.util.HashSet;

public class _06_BSTPairSum {
    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    Node root;

    boolean inPairSum(Node root, int sum, HashSet<Integer> set) {
        if (root == null) return false;

        if (inPairSum(root.left, sum, set)) return true;

        if (set.contains(sum - root.key)) return true;
        else set.add(root.key);

        return inPairSum(root.right, sum, set);
    }

    public static void main(String[] args) {
        _06_BSTPairSum tree = new _06_BSTPairSum();
        tree.root = new Node(15);
        tree.root.left = new Node(10);
        tree.root.right = new Node(20);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(12);
        tree.root.right.left = new Node(16);
        tree.root.right.right = new Node(25);

        int sum = 33;
        HashSet<Integer> set = new HashSet<>();
        if (tree.inPairSum(tree.root, sum, set))
            System.out.println("Pair exists");
        else
            System.out.println("No pair exists");
    }
}