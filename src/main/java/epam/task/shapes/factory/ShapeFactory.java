package epam.task.shapes.factory;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ShapeFactory {

    private static Logger logger = LogManager.getLogger();

    public static Tetrahedron createTetra(Point point,double edge, double height)  {
        Tetrahedron tetra = new Tetrahedron(point,edge,height);
        return tetra;
    }

    public static Tetrahedron createTetra(double x, double y, double z, double edge, double height) throws CustomException {
        return createTetra(new Point(x, y, z), edge, height);
    }

    public static Tetrahedron createTetra(double[] parameters) {
        Point points = new Point(parameters[0], parameters[1], parameters[2]);
        double edge = parameters[3];
        double height = parameters[4];
        return createTetra(points, edge, height);
    }


}
