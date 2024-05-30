package org.example;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

public class Graph {
    private final SimpleWeightedGraph<Integer, DefaultWeightedEdge> graph;
    private List<List<Integer>> cycles = new ArrayList<>();
    private boolean[] visited;
    private int[] path;
    private int pathIndex = 0;

    private int count = 0;
    public Graph(int nodes, int edges) {
        graph = new SimpleWeightedGraph<>(DefaultWeightedEdge.class);
        Random random = new Random();
        for (int i = 0; i < nodes; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < nodes - 1; i++) {
            DefaultWeightedEdge edge = graph.addEdge(i, i + 1);
            if (edge != null) {
                graph.setEdgeWeight(edge, random.nextInt(10) + 1);
            }
        }
        int addedEdges = nodes - 1;
        while (addedEdges < edges) {
            int node1 = random.nextInt(nodes);
            int node2 = random.nextInt(nodes);
            if (node1 != node2 && !graph.containsEdge(node1, node2)) {
                DefaultWeightedEdge edge = graph.addEdge(node1, node2);
                if (edge != null) {
                    graph.setEdgeWeight(edge, random.nextInt(10) + 1);
                }
                addedEdges++;
            }
        }
        printEdges();
    }

    public void findAllCycles() {
        visited = new boolean[graph.vertexSet().size()];
        path = new int[graph.vertexSet().size()];

        for (Integer vertex : graph.vertexSet()) {
            findCyclesInDFS(vertex, vertex);

            Arrays.fill(visited, false);
        }
    }

    private void findCyclesInDFS(int current, int start) {
        visited[current] = true;
        path[pathIndex] = current;
        pathIndex++;

        for (DefaultWeightedEdge edge : graph.edgesOf(current)) {
            if (graph.getEdgeSource(edge) != current) {
                continue;
            }
            int next = graph.getEdgeTarget(edge);
            if (next == start && pathIndex > 2) {
                saveCycle();
            } else if (!visited[next]) {
                findCyclesInDFS(next, start);
            }
        }

        visited[current] = false;
        pathIndex--;
    }

    private void saveCycle() {
        List<Integer> cycle = new ArrayList<>();
        for (int i = 0; i < pathIndex; i++) {
            cycle.add(path[i]);
        }
        if (graph.containsEdge(cycle.get(0), cycle.get(cycle.size() - 1))) {
            cycle.add(path[0]);
            cycles.add(cycle);
        }
    }

    public List<List<Integer>> getCycles() {
        return cycles;
    }

    public List<Integer> findRoute(int desiredDistance) {
        for (List<Integer> cycle : cycles) {
            int sum = 0;
            for (int i = 0; i < cycle.size() - 1; i++) {
                DefaultWeightedEdge edge = graph.getEdge(cycle.get(i), cycle.get(i + 1));
                if (edge != null) {
                    sum += graph.getEdgeWeight(edge);
                }
            }
            if (sum == desiredDistance) {
                return cycle;
            }
        }
        return new ArrayList<>();
    }

    public SimpleWeightedGraph<Integer, DefaultWeightedEdge> getGraph() {
        return graph;
    }

    public void printEdges() {
        Set<DefaultWeightedEdge> edges = graph.edgeSet();
        for (DefaultWeightedEdge edge : edges) {
            int source = graph.getEdgeSource(edge);
            int target = graph.getEdgeTarget(edge);
            System.out.println("Edge from " + source + " to " + target);
        }
    }
}