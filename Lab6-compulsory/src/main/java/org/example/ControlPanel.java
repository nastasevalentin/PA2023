package org.example;

import javax.swing.*;
import java.awt.*;
import java.io.*;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("exit");
    JButton loadBtn = new JButton("load");
    JButton saveBtn = new JButton("save");
    JButton exportBtn = new JButton("export");
    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }
    private void init(){
        setLayout(new GridLayout(1, 4));
        add(saveBtn);
        add(loadBtn);
        add(exportBtn);
        add(exitBtn);
        exportBtn.addActionListener(e -> frame.getCanvas().exportToPNG("gameBoard.png"));
        exitBtn.addActionListener(e -> exitGame());
        saveBtn.addActionListener(e -> saveGame("gameState.ser"));
        loadBtn.addActionListener(e -> loadGame("gameState.ser"));
    }
    private void exitGame(){
        frame.dispose();
    }
    public void saveGame(String filename) {
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(filename))) {
            o.writeObject(frame.getGame());
        } catch (IOException e) {
            System.out.println("Error saving game: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void loadGame(String filename) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            Game loadedGame = (Game) ois.readObject();
            frame.setGame(loadedGame);
            frame.getCanvas().setGeneratedSticks(loadedGame.getSticks());
            frame.getCanvas().repaint();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading game: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
