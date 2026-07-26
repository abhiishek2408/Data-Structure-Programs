package PriorityQueue;

import java.util.PriorityQueue;
import java.util.Scanner;

class Pair {
    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Min Heap based on distance
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.distance - b.distance);

        System.out.print("Enter number of pairs: ");
        int n = sc.nextInt();

        // User input
        for (int i = 0; i < n; i++) {

            System.out.print("Enter node: ");
            int node = sc.nextInt();

            System.out.print("Enter distance: ");
            int distance = sc.nextInt();

            pq.add(new Pair(node, distance));
        }

        System.out.println("\nPriority Queue Output:");

        // Printing in sorted order
        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            System.out.println(
                    "Node = " + current.node +
                    ", Distance = " + current.distance
            );
        }

        sc.close();
    }
}
