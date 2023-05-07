package helper;

/**
 * Class for holding all vector information of velocity, centers, etc 
 */
public class Vec {
    private double x;
    private double y;

    public Vec(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getMagnitude() {
        return Math.sqrt(x * x + y * y);
    }

    public double getAngle() {
        return Math.toDegrees(Math.atan(x / y));
    }

    public static int getDot(Vec v1, Vec v2) {
        return (int) (v1.getX() * v2.getX() + v1.getY() * v2.getY());
    }

    public static double getAngleBetween(Vec v1, Vec v2) {
        return Math.toDegrees(Math.acos(getDot(v1, v2) / (v1.getMagnitude() * v2.getMagnitude())));
    }

    @Override
    /**
     * Returns true if the vectors have the same x && y
     */
    public boolean equals(Object v2) {
        if(v2 instanceof Vec v) {
            return this.getX() == v.getX() && this.getY() == v.getY();
        } 
        return false;
    }

    @Override
    public String toString() {
        return "[{X: " + getX() + "} {Y: " + getY() + "} {Magnitude: " + getMagnitude() + "} " +
         "{Angle: " + getAngle() + "}]";
    }
}
