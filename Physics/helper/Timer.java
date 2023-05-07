package helper;

/**
 * Helper Timer for updating based on elapsed period
 */
public class Timer {
    private static long startTime = 0l;
    private static long deltaTime = 0l;

    private static double dTime = 0.0;

    public static double getDeltaTime() {
        deltaTime = (System.currentTimeMillis() - startTime);
        startTime = System.currentTimeMillis();
        // converts Long deltaTime to double dTime
        updateDouble();
        return dTime;
    }

    public static void start() {
        startTime = System.currentTimeMillis();
    }

    public static double deltaTime() {
        return dTime;
    }

    public static double getFPS() {
        return 1 / dTime;
    }

    private static void updateDouble() {
        dTime = (double) deltaTime * 0.001;
    }

    @Override
    public String toString() {
        return "" + deltaTime;
    }
}
