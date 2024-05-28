package org.example;

import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;

import java.util.Random;

public class Graph {
    private final DefaultUndirectedGraph<Integer, CustomEdge> graph;

    public Graph(int nodes, int edges) {
        graph = new DefaultUndirectedGraph<>(CustomEdge.class);
        Random random = new Random();
        for (int i = 0; i < nodes; i++) {
            graph.addVertex(i);
        }
        for (int i = 0; i < nodes - 1; i++) {
            graph.addEdge(i, i + 1);
            graph.addEdge(i + 1, i);
        }
        int addedEdges = nodes - 1;
        while (addedEdges < edges) {
            int node1 = random.nextInt(nodes);
            int node2 = random.nextInt(nodes);
            if (node1 != node2 && !graph.containsEdge(node1, node2)) {
                graph.addEdge(node1, node2);
                graph.addEdge(node2, node1);
                addedEdges++;
            }
        }
    }

    public DefaultUndirectedGraph<Integer, CustomEdge> getGraph() {
        return graph;
    }

    public static class CustomEdge extends DefaultEdge {
        @Override
        public String toString() {
            return getSource() + " - " + getTarget();
        }
    }
}