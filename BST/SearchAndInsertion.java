

class Node {
    int key;
    Node left, right;

    public Node(int item) {
        key = item;
        left = right = null;
    }
}

class SearchAndInsertion {
    Node root;

    // Recursive search function
    boolean recursiveSearch(Node root, int x) {
        if (root == null)
            return false;
        else if (root.key == x)
            return true;
        else if (root.key < x)
            return recursiveSearch(root.right, x);
        else
            return recursiveSearch(root.left, x);
    }

    // Iterative search function
    boolean iterativeSearch(Node root, int x) {
        while (root != null) {
            if (root.key == x)
                return true;
            else if (root.key < x)
                root = root.right;
            else
                root = root.left;
        }
        return false;
    }

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

    // Iterative insert function
    Node iterativeInsert(Node root, int x) {
        Node temp = new Node(x);
        Node parent = null, curr = root;

        while (curr != null) {
            parent = curr;
            if (curr.key > x)
                curr = curr.left;
            else if (curr.key < x)
                curr = curr.right;
            else
                return root; // If the key already exists, return the root
        }

        if (parent == null)
            return temp; // Tree was empty, new node is the root
        else if (parent.key > x)
            parent.left = temp;
        else
            parent.right = temp;

        return root;
    }

    public static void main(String[] args) {
        SearchAndInsertion tree = new SearchAndInsertion();
        tree.root = tree.iterativeInsert(tree.root, 50);
        tree.iterativeInsert(tree.root, 30);
        tree.iterativeInsert(tree.root, 20);
        tree.iterativeInsert(tree.root, 40);
        tree.iterativeInsert(tree.root, 70);
        tree.iterativeInsert(tree.root, 60);
        tree.iterativeInsert(tree.root, 80);

        int keyToSearch = 40;

        // Test recursive search
        if (tree.recursiveSearch(tree.root, keyToSearch))
            System.out.println("Key " + keyToSearch + " found using recursive search.");
        else
            System.out.println("Key " + keyToSearch + " not found using recursive search.");

        // Test iterative search
        if (tree.iterativeSearch(tree.root, keyToSearch))
            System.out.println("Key " + keyToSearch + " found using iterative search.");
        else
            System.out.println("Key " + keyToSearch + " not found using iterative search.");
    }
}