package shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import helper.Vec;

public class Rectangle extends Shape {

    private int length = -1;
    private int width = -1;
    private double mass = -1;

    private Color color = new Color(255, 0 , 0);

    private Rectangle() {
        mass = getArea() / 100;
    }


    public Rectangle(int x, int y, int length, int width) {
        this();
        this.length = length;
        this.width = width;
        center = new Vec(x - length * 0.5d, y - width * 0.5d);
    }

    public Rectangle(int x, int y, int length, int width, Color c) {
        this(x, y, length, width);
        this.color = c;
    }

    public Rectangle(int x, int y, int length) {
        this();
        this.length = length;
        this.width = length;
        center = new Vec(x - length * 0.5d, y - width * 0.5d);
    }

    public int getLength() {
        return length;
    }

    @Override
    public Vec getCenter() {
        return center;
    }

    @Override
    public void setCenter(Vec v) {
        center = v;
    }

    @Override
    public void drawShape(Graphics2D g) {
        g.setColor(color);
        g.fillRect((int) center.getX(), (int) center.getY(), width, length);
    }

    @Override
    public double getArea() {
        return length * width;
    }

    @Override
    public String toString() {
        return super.toString() + " Center: " + center;
    }

    @Override
    public void setVelocity(Vec v) {
        velocity = v;
    }
    
}
