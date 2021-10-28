package epam.task.shapes.factory;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;

public class ShapeFactory {


    public static Tetrahedron createTetra(Point point,double edge, double height){
        return new Tetrahedron(point,edge,height);
    }

    public static Tetrahedron createTetra(double x, double y, double z, double edge, double height){
        return createTetra(new Point(x, y, z), edge, height);
    }

    public static Tetrahedron createTetra(double[] parameters) {
        Point points = new Point(parameters[0], parameters[1], parameters[2]);
        double edge = parameters[3];
        double height = parameters[4];
        return createTetra(points, edge, height);
    }


}
