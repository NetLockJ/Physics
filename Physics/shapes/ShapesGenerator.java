package shapes;

import java.awt.Color;
import java.util.Random;

import helper.Vec;

/**
 * Generates Shape objects to put in {@link ShapeHolder}  to be passed around the engine
 */
public class ShapesGenerator {

    public ShapesGenerator() {
        ShapesHolder.shapes.add(new Rectangle(50, 20, 40));
        ShapesHolder.shapes.add(new Circle(100, 20, 40));
    }

    public ShapesGenerator(int rectangles, int circles) {
        for(int i = 0; i < rectangles; i++) {
            ShapesHolder.shapes.add(new Rectangle(randPos(), randPos(), 50, 50, randColor()));
        }

        for(int i = 0; i < circles; i++) {
            ShapesHolder.shapes.add(new Circle(randPos(), randPos(), rand(10, 20), randColor()));
        }
    }

    private static int rand(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    private static Color randColor() {
        return new Color(rand(0, 255), rand(0, 255), rand(0, 255));
    }

    private static int randPos() {
        return (int) (Math.random() * 500) + 1;
    }

    private static double randVelocity() {
        return -Math.random() * 40;
    }

    public static void setRandomVelocity() {
        for(Shape s: ShapesHolder.shapes) {
            s.velocity = new Vec(randVelocity(), randVelocity());
        }
    }


}
