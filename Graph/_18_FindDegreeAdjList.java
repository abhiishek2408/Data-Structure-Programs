package Graph;

import java.util.*;

public class _18_FindDegreeAdjList {

    private List<List<Integer>> adjList;

    public _18_FindDegreeAdjList(int vertices) {
        adjList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjList.add(new ArrayList<>()); // Initialize adjacency lists
        }
    }

    // Add an undirected edge
    public void addEdge(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            adjList.get(u).add(v);
            adjList.get(v).add(u); // For undirected graph
        } else {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
        }
    }

    // Add a directed edge
    public void addDirectedEdge(int u, int v) {
        if (u >= 0 && u < adjList.size() && v >= 0 && v < adjList.size()) {
            adjList.get(u).add(v);
        } else {
            System.out.println("Invalid edge: (" + u + ", " + v + ")");
        }
    }

    // Get the degree (undirected)
    public int getDegree(int v) {
        if (v >= 0 && v < adjList.size()) {
            return adjList.get(v).size();
        }
        return -1;
    }

    // Get out-degree (directed)
    public int getOutDegree(int v) {
        return getDegree(v); // In adj list, out-degree is just the size of the list at v
    }

    // Get in-degree (directed)
    public int getInDegree(int v) {
        if (v < 0 || v >= adjList.size()) return -1;
        int inDegree = 0;
        for (List<Integer> neighbors : adjList) {
            for (int neighbor : neighbors) {
                if (neighbor == v) {
                    inDegree++;
                }
            }
        }
        return inDegree;
    }

    // Print adjacency list
    public void printGraph() {
        System.out.println("Adjacency List:");
        for (int i = 0; i < adjList.size(); i++) {
            System.out.print(i + " -> " + adjList.get(i));
            System.out.println();
        }
    }

    public static void main(String[] args) {
        _18_FindDegreeAdjList solution = new _18_FindDegreeAdjList(3);
 
        System.out.println("--- Undirected Graph ---");
        solution.addEdge(0, 1);
        solution.addEdge(1, 2);
        solution.printGraph();
        System.out.println("Degree of 1: " + solution.getDegree(1));
 
        _18_FindDegreeAdjList directedSolution = new _18_FindDegreeAdjList(3);
        System.out.println("\n--- Directed Graph ---");
        directedSolution.addDirectedEdge(0, 1);
        directedSolution.addDirectedEdge(1, 2);
        directedSolution.addDirectedEdge(0, 2);
        directedSolution.printGraph();
        System.out.println("Out-degree of 0: " + directedSolution.getOutDegree(0));
        System.out.println("In-degree of 2: " + directedSolution.getInDegree(2));
    }
}
