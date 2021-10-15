package epam.task.shapes.entity;

import epam.task.shapes.exception.CustomException;
import epam.task.shapes.oserver.Impl.TetraObserverImpl;
import epam.task.shapes.oserver.TetraEvent;
import epam.task.shapes.oserver.TetraObservable;
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
    /*private double radius;*/
    private long id;
    private List<TetraObserverImpl> observers = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setEdge(double edge) {
        this.edge = edge;
    }

    /*public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }*/

    public Tetrahedron(Point center, double edge, double height) {
        this.center = center;
        this.edge = edge;
        this.height = height;
        this.id = IdGenerator.idGenerate();
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tetrahedron that = (Tetrahedron) o;
        return Double.compare(that.edge, edge) == 0 &&
                Double.compare(that.height, height) == 0 &&
                /*Double.compare(that.radius, radius) == 0 &&*/
                id == that.id && Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, center, edge, height/*, radius*/);
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
        String builder = "Tetrahedron{" +
                "center=" + center +
                ", edge=" + edge +
                ", height=" + height +
                /*", redius=" + radius +*/
                ", id=" + id +
                '}';
        return builder;
    }
}
