package Graph;

import java.util.*;

class Pair {

    int node;
    int distance;

    Pair(int node, int distance) {
        this.node = node;
        this.distance = distance;
    }
}

public class _33_DijkstraAlgorithm {

    static void dijkstra(int src,
                         ArrayList<ArrayList<Pair>> graph,
                         int V) {

        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) ->
                a.distance - b.distance);

        dist[src] = 0;

        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {

            Pair current = pq.poll();

            int node = current.node;
            int currentDist = current.distance;

            for (Pair neighbor : graph.get(node)) {

                int adjNode = neighbor.node;
                int edgeWeight = neighbor.distance;

                if (currentDist + edgeWeight < dist[adjNode]) {

                    dist[adjNode] =
                        currentDist + edgeWeight;

                    pq.add(
                        new Pair(adjNode,
                        dist[adjNode])
                    );
                }
            }
        }

        // Print shortest distances
        for (int i = 0; i < V; i++) {

            System.out.println(
                "Distance from " + src +
                " to " + i +
                " = " + dist[i]
            );
        }
    }

    public static void main(String[] args) {

        int V = 4;

        ArrayList<ArrayList<Pair>> graph =
            new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Undirected weighted graph

        graph.get(0).add(new Pair(1, 4));
        graph.get(1).add(new Pair(0, 4));

        graph.get(0).add(new Pair(2, 1));
        graph.get(2).add(new Pair(0, 1));

        graph.get(2).add(new Pair(1, 2));
        graph.get(1).add(new Pair(2, 2));

        graph.get(1).add(new Pair(3, 5));
        graph.get(3).add(new Pair(1, 5));

        graph.get(2).add(new Pair(3, 8));
        graph.get(3).add(new Pair(2, 8));

        dijkstra(0, graph, V);
    }
}
