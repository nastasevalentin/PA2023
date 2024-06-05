package org.example;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.swing.mxGraphComponent;
import com.mxgraph.util.mxConstants;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultWeightedEdge;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

public class Frame {
    private JFrame frame;
    private JButton button;
    private JTextField nodeField;
    private JTextField edgeField;
    private JPanel graphPanel;
    private JButton routeButton;
    private JTextField routeField;
    private JButton cycleButton;
    private Graph graph;
    private JTextArea textArea;

    public Frame() {
        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);

        frame = new JFrame("Number Generator");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel(new BorderLayout());
        frame.add(panel);

        panel.add(scrollPane, BorderLayout.SOUTH);

        JPanel inputPanel = new JPanel();
        panel.add(inputPanel, BorderLayout.NORTH);

        button = new JButton("Generate");
        inputPanel.add(button);

        nodeField = new JTextField(10);
        inputPanel.add(nodeField);

        edgeField = new JTextField(10);
        inputPanel.add(edgeField);

        routeButton = new JButton("Find Route");
        inputPanel.add(routeButton);

        routeField = new JTextField(10);
        inputPanel.add(routeField);

        graphPanel = new JPanel();
        panel.add(graphPanel, BorderLayout.CENTER);

        cycleButton = new JButton("Find Cycles");
        inputPanel.add(cycleButton);

        cycleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (graph != null) {
                    graph.findAllCycles();
                    List<List<Integer>> cycles = graph.getCycles();
                    textArea.setText("Cycles found");
                }
            }
        });

        routeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (graph != null) {
                    int desiredSum = Integer.parseInt(routeField.getText());
                    List<List<Integer>> cycles = graph.findRoute(desiredSum);
                    if (cycles.isEmpty()) {
                        textArea.setText("No cycle found with the desired sum.");
                    } else {
                        for (List<Integer> cycle : cycles) {
                            textArea.setText("Cycle with the desired sum: " + cycle);
                            break;
                        }
                    }
                }
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int nodes = Integer.parseInt(nodeField.getText());
                int edges = Integer.parseInt(edgeField.getText());
                graph = new Graph(nodes, edges);
                JGraphXAdapter<Integer, DefaultWeightedEdge> graphAdapter = new JGraphXAdapter<Integer, DefaultWeightedEdge>(graph.getGraph()) {
                    @Override
                    public String convertValueToString(Object cell) {
                        if (model.isEdge(cell)) {
                            Object edge = model.getValue(cell);
                            if (edge instanceof DefaultWeightedEdge) {
                                int weight = (int) graph.getGraph().getEdgeWeight((DefaultWeightedEdge) edge);
                                return String.format("%d", weight);
                            }
                        }
                        return super.convertValueToString(cell);
                    }
                };
                String edgeStyle = mxConstants.STYLE_NOEDGESTYLE + "=1;" + mxConstants.STYLE_STROKECOLOR + "=black";
                graphAdapter.getStylesheet().getDefaultEdgeStyle().put(mxConstants.STYLE_ENDARROW, mxConstants.NONE);
                graphAdapter.setCellStyle(edgeStyle, graphAdapter.getChildEdges(graphAdapter.getDefaultParent()));
                graphPanel.removeAll();
                graphPanel.add(new mxGraphComponent(graphAdapter));
                mxCircleLayout layout = new mxCircleLayout(graphAdapter);
                layout.execute(graphAdapter.getDefaultParent());
                frame.validate();
            }
        });
    }

    public void show() {
        frame.setVisible(true);
    }
}