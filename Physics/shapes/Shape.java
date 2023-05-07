package shapes;

import java.awt.Graphics2D;

import helper.Vec;

public abstract class Shape {
    /**
     * Center of the shape
     */
    public Vec center;

    /**
     * Velocity of the shape
     */
    public Vec velocity = new Vec(0, 0);

    /**
     * Gets the center of the shape
     * 
     */
    public abstract Vec getCenter();

    /**
     * Set center to a Vector
     * @param v Vector to set the center to
     */
    public abstract void setCenter(Vec v);

    /**
     * Set the Velocity to the provided Vector
     * @param v Vector to set velocity to
     */

    public abstract void setVelocity(Vec v);


    /**
     * Draws the shape on the Window
     * @param g Grpahics object to draw on
     */
    public abstract void drawShape(Graphics2D g);

    /**
     * Gets the area of the shape
     * @return area of the shape
     */
    public abstract double getArea();


    /**
     * Updates the center of the shape based on the current velocity
     * @param deltaTime time passed since last update
     */
    public void updateCenter(double deltaTime) {
        setCenter(new Vec(center.getX() + velocity.getX() * deltaTime, center.getY() + velocity.getY() * deltaTime));
    }

}
