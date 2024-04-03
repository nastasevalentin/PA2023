package org.example;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("exit");
    JButton loadBtn = new JButton("load");
    JButton saveBtn = new JButton("save");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(exitBtn);

        exitBtn.addActionListener(e -> exitGame());
    }

    private void exitGame(){
        frame.dispose();
    }
}
