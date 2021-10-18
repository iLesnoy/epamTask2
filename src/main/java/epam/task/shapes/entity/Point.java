package epam.task.shapes.entity;


public class Point {
    private double x;

    private double y;
    private double z;

    public Point() {
    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Point(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    @Override
    public int hashCode() {
        int result = 11;
        long longBits = Double.doubleToLongBits(this.x);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.y);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.z);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return  Double.compare(point.x, x) == 0 &&
                Double.compare(point.y, y) == 0 &&
                Double.compare(point.z, z) == 0;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Point{");
        builder.append(x).append(", ");
        builder.append(y).append(", ");
        builder.append(z).append("}");
        return builder.toString();
    }
}
