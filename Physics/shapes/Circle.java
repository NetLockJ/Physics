package shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import helper.Vec;

public class Circle extends Shape {
    private int radius = -1;
    private double mass = -1;
    
    private Color color = new Color(255, 0 , 0);

    public Circle(int x, int y, int radius) {
        this.mass = getArea() / 100;
        // convert to real radius (based on how graphics works)
        this.radius = 2 * radius;
        center = new Vec(x - radius * 0.5d, y - radius * 0.5d);
    }

    public Circle(int x, int y, int radius, Color c) {
        this(x, y, radius);
        this.color = c;
    }

    public int getRadius() {
        return radius;
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
        g.fillOval((int) center.getX(), (int) center.getY(), radius, radius);
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
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
