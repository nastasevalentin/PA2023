package org.example;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerR;
    JSpinner spinnerC;
    JButton button;

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        spinnerC = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerR = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        button = new JButton("Create");

        add(label);
        add(spinnerC);
        add(spinnerR);
        add(button);
        button.addActionListener(e ->{
            int rows = (int) spinnerR.getValue();
            int cols = (int) spinnerC.getValue();
            frame.getCanvas().init(rows, cols);
            frame.getGame().reset();
            frame.getCanvas().repaint();
        });

    }

    public JSpinner getRows() {
        return spinnerR;
    }

    public JSpinner getCols() {
        return spinnerC;
    }
}
