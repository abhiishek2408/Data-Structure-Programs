public class MaximumXORPair {
    static class Node {
        Node[] next = new Node[2];
    }

    static class BinaryTrie {
        private final Node root = new Node();

        void insert(int number) {
            Node current = root;
            for (int bit = 31; bit >= 0; bit--) {
                int value = (number >>> bit) & 1;
                if (current.next[value] == null) current.next[value] = new Node();
                current = current.next[value];
            }
        }

        int bestXorWith(int number) {
            Node current = root;
            int answer = 0;
            for (int bit = 31; bit >= 0; bit--) {
                int value = (number >>> bit) & 1;
                int wanted = 1 - value;
                if (current.next[wanted] != null) {
                    answer |= (1 << bit);
                    current = current.next[wanted];
                } else current = current.next[value];
            }
            return answer;
        }
    }

    static int maximumXor(int[] numbers) {
        BinaryTrie trie = new BinaryTrie();
        for (int number : numbers) trie.insert(number);
        int maximum = 0;
        for (int number : numbers) maximum = Math.max(maximum, trie.bestXorWith(number));
        return maximum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum pair XOR: " + maximumXor(new int[]{3, 10, 5, 25, 2, 8}));
    }
}
