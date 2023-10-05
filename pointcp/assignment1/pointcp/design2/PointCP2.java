package assignment1;


public class PointCP2 extends PointCP5 {

    /**
     * Constructs a coordinate object which stores coordinates in polar form.
     */
    public PointCP2(char type, double xOrRho, double yOrTheta) {
        super(type, xOrRho, yOrTheta);
        if (type == 'C') {
            this.xOrRho = Math.sqrt(Math.pow(xOrRho, 2) + Math.pow(yOrTheta, 2));
            this.yOrTheta = Math.toDegrees(Math.atan2(yOrTheta, xOrRho));
        } else if (type == 'P') {
            this.xOrRho = xOrRho;
            this.yOrTheta = yOrTheta;
        }
    }

    @Override
    public double getX() {
        return Math.cos(Math.toRadians(yOrTheta)) * xOrRho;
    }

    @Override
    public double getY() {
        return Math.sin(Math.toRadians(yOrTheta)) * xOrRho;
    }

    @Override
    public double getRho() {
        return this.xOrRho;
    }

    @Override
    public double getTheta() {
        return this.yOrTheta;
    }

    @Override
    public PointCP2 convertStorageToPolar() {
        return new PointCP2('P', this.xOrRho, this.yOrTheta);
    }

    @Override
    public PointCP3 convertStorageToCartesian() {
        return new PointCP3('P', this.xOrRho, this.yOrTheta);
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
    public PointCP2 rotatePoint(double rotation) {
        double radRotation = Math.toRadians(rotation);
        double X = getX();
        double Y = getY();

        return new PointCP2('C', (Math.cos(radRotation) * X) - (Math.sin(radRotation) * Y),
                (Math.sin(radRotation) * X) + (Math.cos(radRotation) * Y));
    }

    /**
     * Returns information containing the polar coordinates.
     *
     * @return A String containing information about the polar coordinates.
     */
    @Override
    public String toString() {
        return "Stored as " + "Polar [" + getRho() + "," + getTheta() + "]\n";
    }


}
