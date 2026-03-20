
class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class ConstructBTFromInPreOrder {
    int preIndex = 0; // Index for preorder array

    Node constructTree(int in[], int pre[], int is, int ie) {
        // Base case
        if (is > ie) return null;

        // Create a new node with the current key from the preorder array
        Node root = new Node(pre[preIndex++]);

        // Find the index of this node in the inorder array
        int inIndex = -1;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }

        // Recursively construct the left and right subtrees
        root.left = constructTree(in, pre, is, inIndex - 1);
        root.right = constructTree(in, pre, inIndex + 1, ie);

        return root;
    }

    // Function to print the tree in inorder (for verification)
    void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        ConstructBTFromInPreOrder tree = new ConstructBTFromInPreOrder();
        int in[] = {4, 2, 5, 1, 6, 3, 7}; // Inorder traversal
        int pre[] = {1, 2, 4, 5, 3, 6, 7}; // Preorder traversal

        Node root = tree.constructTree(in, pre, 0, in.length - 1);

        System.out.println("Inorder traversal of the constructed tree:");
        tree.printInOrder(root);
    }
}