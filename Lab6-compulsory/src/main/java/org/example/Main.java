package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new MainFrame().setVisible(true);
        SwingUtilities.invokeLater(MainFrame::new);
    }
}