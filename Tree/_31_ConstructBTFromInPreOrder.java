package Tree;

public class _31_ConstructBTFromInPreOrder {
    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    int preIndex = 0; // Index for preorder array

    Node constructTree(int in[], int pre[], int is, int ie) {
        if (is > ie) return null;

        Node root = new Node(pre[preIndex++]);

        int inIndex = -1;
        for (int i = is; i <= ie; i++) {
            if (in[i] == root.val) {
                inIndex = i;
                break;
            }
        }

        root.left = constructTree(in, pre, is, inIndex - 1);
        root.right = constructTree(in, pre, inIndex + 1, ie);

        return root;
    }

    void printInOrder(Node node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        _31_ConstructBTFromInPreOrder solution = new _31_ConstructBTFromInPreOrder();
        int in[] = {4, 2, 5, 1, 6, 3, 7}; // Inorder traversal
        int pre[] = {1, 2, 4, 5, 3, 6, 7}; // Preorder traversal

        Node root = solution.constructTree(in, pre, 0, in.length - 1);

        System.out.println("Inorder traversal of the constructed tree:");
        solution.printInOrder(root);
        System.out.println();
    }
}