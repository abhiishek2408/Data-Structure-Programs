class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class Deletion {
    Node root;

    // Recursive insert function
    Node insert(Node node, int key) {
        if (node == null) {
            node = new Node(key);
            return node;
        }
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        return node;
    }

    // Delete function
    Node deleteNode(Node root, int x) {
        if (root == null) return null;
   
        if (root.key > x) //first finding where to delete
            root.left = deleteNode(root.left, x);
        else if (root.key < x)
            root.right = deleteNode(root.right, x);
        else {//Deletion start from here
            if (root.left == null)// Node with only one child or no child
                return root.right;
            else if (root.right == null)
                return root.left;
            else {
                // Node with two children: Get the inorder successor (smallest in the right subtree)
                Node succ = getSuccessor(root);
                // Copy the inorder successor's content to this node
                root.key = succ.key;
                // Delete the inorder successor
                root.right = deleteNode(root.right, succ.key);
            }
        }
        return root;
    }

    // Get successor (smallest in the right subtree)
    Node getSuccessor(Node root) {
        Node curr = root.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    public static void main(String[] args) {
        Deletion tree = new Deletion();
        tree.root = tree.insert(tree.root, 50);
        tree.insert(tree.root, 30);
        tree.insert(tree.root, 20);
        tree.insert(tree.root, 40);
        tree.insert(tree.root, 70);
        tree.insert(tree.root, 60);
        tree.insert(tree.root, 80);

        int keyToDelete = 40;

        // Test delete
        tree.root = tree.deleteNode(tree.root, keyToDelete);
        System.out.println("Key " + keyToDelete + " deleted.");
    }
}