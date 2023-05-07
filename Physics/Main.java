import engine.*;
import renderer.*;
import shapes.Circle;
import helper.*;

public class Main {
    public static void main(String[] args) {
        Window physicsWindow = new Window();
        Timer.start();

        while(true) {
            PhysicsEngine.updatePhysics();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            physicsWindow.getGraphicsPanel().updateGraphics();
        }
    }
}