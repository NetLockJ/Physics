package engine;

import helper.*;
import shapes.*;
import renderer.*;

/**
 * Updates all Physics for the engine based on real physics
 */
public class PhysicsEngine {

    public static final double GRAVITY = 9.81;
    public static final double REBOUND_CONSTANT = 0.8;
    public static final int SPEED_MULTIPLIER = 7;
    public static final double COEFFICENT_OF_FRICTION = 0.4;

    public static void updatePhysics() {
        double deltaTime = Timer.getDeltaTime() * SPEED_MULTIPLIER;
        for (Shape s : ShapesHolder.shapes) {
            updatePosition(s, deltaTime);
            calculateFriction(s, deltaTime);
            System.out.println(s.center);
        }
    }

    /**
     * Updates gravity related physics
     * @param sh shape
     * @param deltaTime time since last check
     */
    private static void updatePosition(Shape sh, double deltaTime) {
        if (checkEdges(sh)) {
            sh.velocity.setY((GRAVITY * deltaTime) + sh.velocity.getY());
            sh.updateCenter(deltaTime);
        }
    }

    /**
     * Checks to make sure the shape is within bounds relative to the edges of the screen
     * @param sh shape
     * @return true if shape is within bounds, false otherwise
     */
    private static boolean checkEdges(Shape sh) {
        boolean ret = true;
        double yVelocity = sh.velocity.getY();
        double xVelocity = sh.velocity.getX();

        if (sh instanceof Circle c) {
            // Off the screen in vertical direction
            if (c.getRadius() + c.center.getY() > GraphicsPanel.HEIGHT) {
                yVelocity *= -REBOUND_CONSTANT;
                c.center = new Vec(c.center.getX(), GraphicsPanel.HEIGHT - c.getRadius());
                ret = false;
            }

            if(c.center.getX() < 0 || c.center.getX() + c.getRadius() > GraphicsPanel.WIDTH) {
                xVelocity *= -REBOUND_CONSTANT;
                c.center = new Vec(c.center.getX() < 0 ? 0 : GraphicsPanel.WIDTH - c.getRadius(), c.center.getY());
            }
        } else if (sh instanceof Rectangle r) {
            // Off the screen in Vertical direciton
            if (r.getLength() + r.center.getY() > GraphicsPanel.HEIGHT) {
                yVelocity *= -REBOUND_CONSTANT;
                r.center = new Vec(r.center.getX(), GraphicsPanel.HEIGHT - r.getLength());
                ret = false;
            }

            if(r.center.getX() < 0 || r.center.getX() + r.getLength() > GraphicsPanel.WIDTH) {
                xVelocity *= -1;
                r.center = new Vec(r.center.getX() + r.getLength() > GraphicsPanel.WIDTH ? GraphicsPanel.WIDTH - r.getLength() : 0, r.center.getY());
            }   
        }

        sh.velocity = new Vec(xVelocity, yVelocity);
        return ret;
    }

    /**
     * Updates motion related to friction
     * @param sh shape
     */
    public static void calculateFriction(Shape sh, double deltaTime) {
        // Friction changes based on direction of motion
        int frictionDirection = 1;
        if(sh instanceof Rectangle r) {
            if(r.center.getY() + r.getLength() >= GraphicsPanel.HEIGHT) {
                frictionDirection = r.velocity.getX() > 0 ? -1 : 1;
                r.velocity.setX(Math.abs(r.velocity.getX()) > 0.05 ? (r.velocity.getX() + 
                    (r.getFrictionAcceleration() * deltaTime * frictionDirection)) : 0);
            }
        }
    }

}
