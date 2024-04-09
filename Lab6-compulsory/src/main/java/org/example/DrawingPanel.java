package org.example;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DrawingPanel extends JPanel {
    private final MainFrame frame;
    int rows, cols;
    int canvasWidth = 400, canvasHeight = 400;
    int boardWidth, boardHeight;
    int cellWidth, cellHeight;
    int padX, padY;
    int stoneSize = 20;
    private List<Stick> generatedSticks = new ArrayList<>();

    public DrawingPanel(MainFrame frame) {
        this.frame = frame;
        init(10, 10);
    }

    public void init(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.padX = stoneSize + 10;
        this.padY = stoneSize + 10;
        this.cellWidth = (canvasWidth - 2 * padX) / (cols - 1);
        this.cellHeight = (canvasHeight - 2 * padY) / (rows - 1);
        this.boardWidth = (cols - 1) * cellWidth;
        this.boardHeight = (rows - 1) * cellHeight;
        setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        generateSticks();
        MouseListener[] mouseListeners = getMouseListeners();
        for (MouseListener listener : mouseListeners) {
            removeMouseListener(listener);
        }
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (frame.getGame().countNeighbors() == 0) {
                    if(frame.getGame().isPlayer1()) {
                        JOptionPane.showMessageDialog(getTopLevelAncestor(), "Game over! Player 2 wins!");
                        System.out.println("Game over! Player 2 wins!");
                    } else {
                        JOptionPane.showMessageDialog(getTopLevelAncestor(), "Game over! Player 1 wins!");
                        System.out.println("Game over! Player 1 wins!");
                    }
                } else if (frame.getGame().isAvailable(new Point(e.getX(), e.getY()))) {
                    if(frame.getGame().isPlayer1()) {
                        frame.getGame().setPlayer1(false);
                        colorStone(e.getY() / cellHeight, e.getX() / cellWidth, Color.RED);
                    } else {
                        frame.getGame().setPlayer1(true);
                        colorStone(e.getY() / cellHeight, e.getX() / cellWidth, Color.BLUE);

                    }
                }
            }

        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, canvasWidth, canvasHeight);
        paintGrid(g);
        paintSticks(g);
        colorStones(g);
    }

    private void paintGrid(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        //horizontal lines
        for (int row = 0; row < rows; row++) {
            int x1 = padX;
            int y1 = padY + row * cellHeight;
            int x2 = padX + boardWidth;
            int y2 = y1;
            g.drawLine(x1, y1, x2, y2);
        }
        //vertical lines

        for (int col = 0; col < cols; col++) {
            int x1 = padX + col * cellWidth;
            int y1 = padY;
            int x2 = x1;
            int y2 = padY + boardHeight;
            g.drawLine(x1, y1, x2, y2);
        }
        //intersections
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = padX + col * cellWidth;
                int y = padY + row * cellHeight;
                g.setColor(Color.LIGHT_GRAY);
                g.drawOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public int getPadX() {
        return padX;
    }

    public int getPadY() {
        return padY;
    }

    public int getCellHeight() {
        return cellHeight;
    }

    public int getCellWidth() {
        return cellWidth;
    }

    public int getBoardHeight() {
        return boardHeight;
    }

    public int getBoardWidth() {
        return boardWidth;
    }
    private void paintSticks (Graphics2D g) {
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(5));
        for(var stick : generatedSticks) {
            g.drawLine(stick.getStartPoint().x, stick.getStartPoint().y, stick.getEndPoint().x, stick.getEndPoint().y);
        }
    }
    private void generateSticks() {
        this.generatedSticks.clear();
        for (int row = 0; row < getRows(); row++) {
            for(int col = 0; col < getCols() - 1; col++) {
                double random = Math.random();
                if(random > 0.4) {
                    int x1 = getPadX() + col * getCellWidth();
                    int y1 = getPadY() + row * getCellHeight();
                    int x2 = x1 + getCellWidth();
                    int y2 = y1;
                    Stick stick = new Stick(new Point(x1, y1), new Point(x2, y2));
                    generatedSticks.add(stick);
                }
            }
        }
        for (int col = 0; col < getCols(); col++) {
            for(int row = 0; row < getRows() - 1; row++) {
                double random = Math.random();
                if(random > 0.4) {
                    int x1 = getPadX() + col * getCellWidth();
                    int y1 = getPadY() + row * getCellHeight();
                    int x2 = x1;
                    int y2 = y1 + getCellHeight();
                    Stick stick = new Stick(new Point(x1, y1), new Point(x2, y2));
                    generatedSticks.add(stick);
                }
            }
        }
    }

    public List<Stick> getGeneratedSticks() {
        return generatedSticks;
    }
    public List<Stone> getAvailableStones() {
        List<Stone> stones = new ArrayList<>();
        for (int row = 0; row < getRows(); row++) {
            for (int col = 0; col < getCols(); col++) {
                int x = getPadX() + col * getCellWidth();
                int y = getPadY() + row * getCellHeight();
                Stone stone = new Stone(new Point(x, y), stoneSize, stoneSize);
                for (var stick : generatedSticks) {
                    if((stick.getStartPoint().x == stone.getPosition().x && stick.getStartPoint().y == stone.getPosition().y) || (stick.getEndPoint().x == stone.getPosition().x && stick.getEndPoint().y == stone.getPosition().y)) {
                        if(!stones.contains(stone)) {
                            stones.add(stone);
                        }
                    }
                }
            }
        }
        return stones;
    }
    public void colorStone(int row, int col, Color color) {
        Graphics2D g = (Graphics2D) getGraphics();
        g.setColor(color);
        int x = getPadX() + col * getCellWidth();
        int y = getPadY() + row * getCellHeight();
        g.fillOval(x - stoneSize / 2, y - stoneSize / 2, stoneSize, stoneSize);
    }
    public void exportToPNG(String filename) {
        BufferedImage image = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        paint(g);
        g.dispose();

        try {
            ImageIO.write(image, "png", new File(filename));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void colorStones(Graphics2D g) {
        for (var stone : frame.getGame().getColoredStones().entrySet()) {
            g.setColor(stone.getValue());
            g.fillOval(stone.getKey().getPosition().x - stoneSize / 2, stone.getKey().getPosition().y - stoneSize / 2, stoneSize, stoneSize);
        }
    }

    public void setGeneratedSticks(List<Stick> generatedSticks) {
        this.generatedSticks = generatedSticks;
    }
}
