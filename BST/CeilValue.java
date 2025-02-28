class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class CeilValue {
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
        CeilValue tree = new CeilValue();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        int x = 12;
        Node ceilNode = tree.ceil(root, x);
        if (ceilNode != null) {
            System.out.println("Ceil value of " + x + " is " + ceilNode.key);
        } else {
            System.out.println("No ceil value found for " + x);
        }
    }
}
