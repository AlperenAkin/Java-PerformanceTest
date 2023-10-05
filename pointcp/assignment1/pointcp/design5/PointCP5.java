package assignment1;



public abstract class PointCP5 {

    double xOrRho;
    double yOrTheta;

    public PointCP5(char type, double xOrRho, double yOrTheta) {
        if (type != 'C' && type != 'P') {
            throw new IllegalArgumentException();
        }
    }

    public abstract double getX();

    public abstract double getY();

    public abstract double getRho();

    public abstract double getTheta();

    /**
     * Uses current values of xOrRho and yOrTheta to return a PointCP5 object
     * that stores polar coordinates only, generating cartesian coordinates on
     * demand.
     */
    public abstract PointCP5 convertStorageToPolar();

    /**
     * Uses current values of xOrRho and yOrTheta to return a PointCP5 object
     * that stores cartesian coordinates only, generating polar coordinates on
     * demand.
     */
    public abstract PointCP5 convertStorageToCartesian();

    /**
     * Calculates the distance in between two points using the Pythagorean
     * theorem (C ^ 2 = A ^ 2 + B ^ 2). Not needed until E2.30.
     *
     * @param pointA The first point.
     * @param pointB The second point.
     * @return The distance between the two points.
     */
    public final double getDistance(PointCP pointB) {
        // Obtain differences in X and Y, sign is not important as these values
        // will be squared later.
        double deltaX = getX() - pointB.getX();
        double deltaY = getY() - pointB.getY();

        return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2)));
    }

    /**
     * Rotates the specified point by the specified number of degrees.
     * Not required until E2.30
     *
     * @param point    The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    public abstract PointCP5 rotatePoint(double rotation);

    /**
     * Returns information about the coordinates.
     *
     * @return A String containing information about the coordinates.
     */
    public abstract String toString();
}
