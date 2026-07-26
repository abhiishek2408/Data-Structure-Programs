package Tree;

public class _02_BTConstruction {

    static class Node {
        int val;
        Node left, right;

        Node(int val) {
            this.val = val;
            left = right = null;
        }
    }

    private int preIndex = 0;

    public Node constructTree(int in[], int pre[], int is, int ie) {
        if (is > ie) return null;

        Node root = new Node(pre[preIndex++]);

        int inIndex = 0;
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
        _02_BTConstruction solution = new _02_BTConstruction();
        int in[] = {4, 2, 5, 1, 6, 3, 7};
        int pre[] = {1, 2, 4, 5, 3, 6, 7};
        int n = in.length;

        Node root = solution.constructTree(in, pre, 0, n - 1);

        System.out.println("Inorder traversal of the constructed tree:");
        solution.printInOrder(root);
        System.out.println();
    }
}