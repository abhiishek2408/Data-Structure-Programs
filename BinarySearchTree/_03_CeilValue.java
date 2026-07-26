package BinarySearchTree;
public class _03_CeilValue {
    static class Node {
        int key;
        Node left, right;
        Node(int x) {
            key = x;
            left = right = null;
        }
    }

    Node ceil(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (root.key == x)
                return root;
            else if (root.key < x)
                root = root.right;
            else {
                res = root;
                root = root.left;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        _03_CeilValue solution = new _03_CeilValue();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        int x = 12;
        Node ceilNode = solution.ceil(root, x);
        if (ceilNode != null) {
            System.out.println("Ceil value of " + x + " is " + ceilNode.key);
        } else {
            System.out.println("No ceil value found for " + x);
        }
    }
}
