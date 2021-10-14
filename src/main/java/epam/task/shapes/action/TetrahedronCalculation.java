package epam.task.shapes.action;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;

public interface TetrahedronCalculation {

    double tetrahedronArea(Tetrahedron tetra);

    double tetrahedronVolume(Tetrahedron tetra);

    double tetrahedronVolumeRatio(Tetrahedron tetra,Point point) throws CustomException;

    boolean isTetrahedron(double radius, double height);

    boolean isBaseOnPlane(Tetrahedron tetra);
}
