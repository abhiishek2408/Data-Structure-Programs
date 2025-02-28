class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Distance {
    int val;

    Distance(int d) {
        val = d;
    }
}

public class BurnTree {
    int res = 0; // Stores the maximum burn time

    int burnTime(Node root, int leaf, Distance dist) {
        if (root == null) return 0;
        if (root.data == leaf) {
            dist.val = 0;
            return 1;
        }

        Distance ldist = new Distance(-1), rdist = new Distance(-1);
        int lh = burnTime(root.left, leaf, ldist);
        int rh = burnTime(root.right, leaf, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, rh + dist.val);
        } else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + lh);
        }

        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        BurnTree tree = new BurnTree();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        root.right.left = new Node(60);
        root.right.right = new Node(70);

        int leaf = 50; // Leaf node to start burning
        Distance dist = new Distance(-1);

        tree.burnTime(root, leaf, dist);
        System.out.println("Maximum burn time: " + tree.res);
    }
}