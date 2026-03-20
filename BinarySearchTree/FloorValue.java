class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class FloorValue {
    Node floor(Node root, int x) {
        Node res = null;
        while (root != null) {
            if (root.key == x)
                return root;
            else if (root.key > x)
                root = root.left;
            else {
                res = root;
                root = root.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        FloorValue tree = new FloorValue();
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(15);
        root.left.left = new Node(3);
        root.left.right = new Node(7);
        root.right.right = new Node(18);

        int x = 12;
        Node floorNode = tree.floor(root, x);
        if (floorNode != null) {
            System.out.println("Floor value of " + x + " is " + floorNode.key);
        } else {
            System.out.println("No floor value found for " + x);
        }
    }
}

/*In a Binary Search Tree (BST), the floor of a given key x is the largest value in the BST that is less than or equal to x.*/