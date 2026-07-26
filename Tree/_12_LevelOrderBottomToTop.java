package Tree;
import java.util.*;

public class _12_LevelOrderBottomToTop {

    static class Node {
        int val;
        Node left;
        Node right;
    
        Node(int val) { 
            this.val = val; 
        }
    }
    
    public List<List<Integer>> levelOrderBottom(Node root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                Node current = queue.poll();
                level.add(current.val);

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.addFirst(level);
        }

        return result;
    }

    public static void main(String[] args) {
        Node root = new Node(3);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        _12_LevelOrderBottomToTop solution = new _12_LevelOrderBottomToTop();
        List<List<Integer>> result = solution.levelOrderBottom(root);
        System.out.println(result); // Expected: [[15, 7], [9, 20], [3]]
    }
}
