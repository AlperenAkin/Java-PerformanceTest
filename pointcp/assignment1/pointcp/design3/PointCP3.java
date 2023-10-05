package assignment1;

public class PointCP3 extends PointCP5 {

    /**
     * Constructs a coordinate object which stores coordinates in cartesian form.
     */
    public PointCP3(char type, double xOrRho, double yOrTheta) {
        super(type, xOrRho, yOrTheta);
        if (type == 'C') {
            this.xOrRho = xOrRho;
            this.yOrTheta = yOrTheta;
        } else if (type == 'P') {
            this.xOrRho = Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
            this.yOrTheta = Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
        }
    }

    @Override
    public double getX() {
        return this.xOrRho;
    }

    @Override
    public double getY() {
        return this.yOrTheta;
    }

    @Override
    public double getRho() {
        return Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
    }

    @Override
    public double getTheta() {
        return Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
    }

    @Override
    public PointCP2 convertStorageToPolar() {
        return new PointCP2('C', this.xOrRho, this.yOrTheta);
    }

    @Override
    public PointCP3 convertStorageToCartesian() {
        return new PointCP3('C', this.xOrRho, this.yOrTheta);
    }

    /**
     * Rotates the specified point by the specified number of degrees. Not
     * required until E2.30
     *
     * @param point    The point to rotate
     * @param rotation The number of degrees to rotate the point.
     * @return The rotated image of the original point.
     */
    @Override
    public PointCP3 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP3('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information containing the cartesian coordinates.
     *
     * @return A String containing information about the cartesian coordinates.
     */
    @Override
    public String toString() {
        return "Stored as " + "Cartesian  (" + getX() + "," + getY() + ")\n";
    }
}
