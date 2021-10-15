package epam.task.shapes.entity;

public class TetraParameters {
    private double area;
    private double volume;

    public TetraParameters(double area, double volume) {
        this.area = area;
        this.volume = volume;
    }

    public double getSurfaceArea() {
        return area;
    }

    public void setSurfaceArea(double surfaceArea) {
        this.area = surfaceArea;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TetraParameters that = (TetraParameters) o;
        return Double.compare(that.area, area) == 0 && Double.compare(that.volume, volume) == 0;
    }

    @Override
    public int hashCode() {
        int result = 11;
        long longBits = Double.doubleToLongBits(this.area);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.volume);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("TetraParameters{");
        builder.append("surfaceArea=").append(area);
        builder.append(", volume=").append(volume);
        builder.append("}");
        return builder.toString();
    }
}
