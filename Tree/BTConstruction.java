

class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BTConstruction {
    int preIndex = 0;

    Node constructTree(int in[], int pre[], int is, int ie) {
        if (is > ie) return null;

        Node root = new Node(pre[preIndex++]);

        int inIndex = 0;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.key) {
                inIndex = i;
                break;
            }
        }

        root.left = constructTree(in, pre, is, inIndex - 1);
        root.right = constructTree(in, pre, inIndex + 1, ie);
        return root;
    }

    // Function to print the tree in inorder (for testing)
    void printInOrder(Node node) {
        if (node == null) return;

        printInOrder(node.left);
        System.out.print(node.key + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        BTConstruction tree = new BTConstruction();
        int in[] = {4, 2, 5, 1, 6, 3, 7};
        int pre[] = {1, 2, 4, 5, 3, 6, 7};
        int n = in.length;

        Node root = tree.constructTree(in, pre, 0, n - 1);

        System.out.println("Inorder traversal of the constructed tree:");
        tree.printInOrder(root);
    }
}