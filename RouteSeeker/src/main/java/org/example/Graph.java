package org.example;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import java.util.*;

public class Graph {
    private final SimpleWeightedGraph<Integer, DefaultWeightedEdge> graph;

    private List<List<Integer>> cycles = new ArrayList<>();

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

    }




    public SimpleWeightedGraph<Integer, DefaultWeightedEdge> getGraph() {
        return graph;
    }

}