package com.vedha.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class GraphDS {

    private final ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

    // Constructor to initialize the adjacency list
    public GraphDS(int v) {

        for (int i = 0; i < v; i++) {

            adjList.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {

        // Matrix Representation of Graph
        int[][] graph = {
                {0, 1, 0, 0, 1},
                {1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0},
                {0, 0, 1, 0, 1},
                {1, 1, 0, 1, 0}
        };

        // Adjacency List Representation of Graph
        GraphDS graphDS = new GraphDS(5); // no of vertices is 5

        // Adding edges to the graph using an adjacency list
        graphDS.addEdge(0, 1); // Edge between 0 and 1
        graphDS.addEdge(0, 4);
        graphDS.addEdge(1, 2);
        graphDS.addEdge(1, 4);
        graphDS.addEdge(2, 3);
        graphDS.addEdge(3, 4);

        graphDS.printGraph();

        graphDS.bfs(0);

        System.out.println();

        graphDS.dfs(0);
    }

    public void addEdge(int u, int v) {

        adjList.get(u).add(v);
        adjList.get(v).add(u);
    }

    public void printGraph() {

        for (int i = 0; i < adjList.size(); i++) {

            System.out.print("Adjacency list of vertex: " + i + " - ");
            adjList.get(i).forEach(System.out::print);
            System.out.println();
        }
    }

    // GRAPH TRAVERSAL - BFS - Breadth-First Search and DFS - Depth-First Search
    // BFS - Breadth-First Search, starting from vertex v in the graph,
    // Visit all the vertices reachable from v
    public void bfs(int v) {

        int size = adjList.size(); // no of vertices

        boolean[] visited = new boolean[size];
        visited[v] = true;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);

        while (!queue.isEmpty()) {

            Integer poll = queue.poll();
            System.out.print(poll + " ");

            for (int i = 0; i < adjList.get(poll).size(); i++) {

                Integer av = adjList.get(poll).get(i);
                if (!visited[av]) {

                    queue.offer(av);
                    visited[av] = true;
                }
            }
        }
    }

    // DFS - Depth-First Search, starting from vertex v in the graph,
    // Visit all the vertices reachable from v
    public void dfs(int v) {

        int size = adjList.size(); // no of vertices

        boolean[] visited = new boolean[size];

        dfsUtil(v, visited);
    }

    private void dfsUtil(int v, boolean[] visited) {
        visited[v] = true;

        System.out.print(v + " ");
        for (int i = 0; i < adjList.get(v).size(); i++) {

            Integer av = adjList.get(v).get(i);
            if (!visited[av]) {

                dfsUtil(av, visited);
            }
        }

    }
}
