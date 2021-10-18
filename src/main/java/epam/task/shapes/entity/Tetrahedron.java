package epam.task.shapes.entity;

import epam.task.shapes.exception.CustomException;
import epam.task.shapes.observer.Impl.TetraObserverImpl;
import epam.task.shapes.observer.TetraEvent;
import epam.task.shapes.observer.TetraObservable;
import epam.task.shapes.service.IdGenerator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Tetrahedron implements TetraObservable<TetraObserverImpl> {

    private static Logger logger = LogManager.getLogger();
    private Point center;
    private double edge;
    private double height;
    private long tetraId;

    public Tetrahedron() {
    }

    public Tetrahedron(Point center, double edge, double height) {
        this.center = center;
        this.edge = edge;
        this.height = height;
        this.tetraId = IdGenerator.idGenerate();
    }

    private List<TetraObserverImpl> observers = new ArrayList<>();


    public long getTetraId() {
        return tetraId;
    }

    public void setTetraId(long tetraId) {
        this.tetraId = tetraId;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public double getEdge() {
        return edge;
    }

    public void setEdge(double edge) throws CustomException {
        this.edge = edge;
        notifyObservers();
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) throws CustomException {
        this.height = height;
        notifyObservers();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Double.compare(that.edge, edge) == 0 &&
                Double.compare(that.height, height) == 0 &&
                tetraId == that.tetraId && Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        int result = this.center.hashCode();
        long longBits = Double.doubleToLongBits(this.edge);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        longBits = Double.doubleToLongBits(this.height);
        result = 31 * result + (int) (longBits - (longBits >>> 32));
        return result;
    }

    @Override
    public void attach(TetraObserverImpl observer) {
        observers.add(observer);
    }

    @Override
    public void detach(TetraObserverImpl observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() throws CustomException {
        TetraEvent event = new TetraEvent(this);
        if (!observers.isEmpty()) {
            for (TetraObserverImpl observer : observers) {
                observer.updateArea(event);
                observer.updateTetraVolume(event);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Tetrahedron{");
        builder.append("center=").append(center);
        builder.append(", edge=").append(edge);
        builder.append(", height=").append(height);
        builder.append(", tetraId=").append(tetraId);
        builder.append('}');
        return builder.toString();
    }
}
