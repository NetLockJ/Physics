package renderer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import shapes.*;
import helper.*;


/**
 * Graphics for Physics Window
 */
public class GraphicsPanel extends JPanel {

    public static final int WIDTH = 500;
    public static final int HEIGHT = 500;

    public GraphicsPanel() {
        this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
        this.setBackground(Color.black);
        this.setVisible(true);

        new ShapesGenerator(20, 20);
        // ShapesGenerator.setRandomVelocity();
        
    }

    @Override
    /**
     * Redraw the screen
     */
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2D = (Graphics2D) g;
        g2D.setColor(Color.RED);
        g2D.drawString(Integer.toString((int) Timer.getFPS()), 480, 25);
        for (Shape s : ShapesHolder.shapes) {
             s.drawShape(g2D);
        }
    }

    public void updateGraphics() {
        repaint();
    }

}
