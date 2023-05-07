package engine;

import helper.*;
import shapes.*;
import renderer.*;

/**
 * Updates all Physics for the engine based on real physics
 */
public class PhysicsEngine {

    private static final double GRAVITY = 9.81;
    private static final double REBOUND_CONSTANT = 0.5;
    private static final int SPEED_MULTIPLIER = 5;

    public static void updatePhysics() {
        double deltaTime = Timer.getDeltaTime() * SPEED_MULTIPLIER;
        for (Shape s : ShapesHolder.shapes) {
            // Vec v = s.getCenter();
            // s.setCenter(new Vec(v.getX(), v.getY() + deltaTime));
            updatePosition(s, deltaTime);

        }
    }

    /**
     * Updates gravity related physics
     * 
     * @param sh        Shape
     * @param deltaTime time since last check
     */
    private static void updatePosition(Shape sh, double deltaTime) {
        if (checkEdges(sh)) {
            sh.velocity.setY((GRAVITY * deltaTime) + sh.velocity.getY());
            sh.updateCenter(deltaTime);
        }
    }

    /*
     * If shape hits the edge, it will invert its y velocity (elastic collision(at least partially))
     */
    private static boolean checkEdges(Shape sh) {
        boolean ret = true;
        if (sh instanceof Circle c) {
            if (c.getRadius() + c.center.getY() > GraphicsPanel.HEIGHT) {
                c.velocity = new Vec(c.velocity.getX(), -c.velocity.getY() * REBOUND_CONSTANT);
                c.center = new Vec(c.center.getX(), GraphicsPanel.HEIGHT - c.getRadius());
                ret = false;
            }
        } else if (sh instanceof Rectangle r) {
            if (r.getLength() + r.center.getY() > 500) {
                r.velocity = new Vec(r.velocity.getX(), -r.velocity.getY() * REBOUND_CONSTANT);
                r.center = new Vec(r.center.getX(), 500 - r.getLength());
                ret = false;
            }
        }

        return ret;
    }

}
