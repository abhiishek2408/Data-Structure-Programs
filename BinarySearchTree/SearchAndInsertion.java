

class SearchAndInsertion {
    
    static class Node {
        int data;
        Node left, right;
        
        public Node(int item) {
            data= item;
            left = right = null;
        }
    }
    
    Node root;
    // Recursive search function
    boolean recursiveSearch(Node root, int x) {
        if (root == null)
            return false;
            
        else if (root.data== x)
            return true;

        else if (root.data> x)
            return recursiveSearch(root.left, x);

        else if (root.data< x)
            return recursiveSearch(root.right, x);

        return false;
    }

    // Iterative search function
    boolean iterativeSearch(Node root, int x) {
        while (root != null) {
            if (root.data== x)
                return true;
            else if (root.data< x)
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

        else if (key< node.data)
            node.left = insert(node.left, key);
        else if (key> node.data)
            node.right = insert(node.right, key);
        return node;
    }

    // Iterative insert function
    Node iterativeInsert(Node root, int key) {
        Node temp = new Node(key);
        Node parent = null, curr = root;

        while (curr != null) {
            parent = curr;
            if (curr.data == key) {    // If the dataalready exists, return the root
                return root;
            } 
            else if (key < curr.data) {
                curr = curr.left;
            } 
            else if(key > curr.data) {
                curr = curr.right;
            } 
        }

        if (parent == null)
            return temp; // Tree was empty, new node is the root
        else if (parent.data> key)
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
            System.out.println("data" + keyToSearch + " found using recursive search.");
        else
            System.out.println("data" + keyToSearch + " not found using recursive search.");

        // Test iterative search
        if (tree.iterativeSearch(tree.root, keyToSearch))
            System.out.println("data" + keyToSearch + " found using iterative search.");
        else
            System.out.println("data" + keyToSearch + " not found using iterative search.");
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }
}