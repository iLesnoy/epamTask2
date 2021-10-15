package epam.task.shapes.action.impl;

import epam.task.shapes.action.TetrahedronCalculation;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;


public class TetrahedronCalculationImpl implements TetrahedronCalculation {

    @Override
    public double tetrahedronArea(Tetrahedron tetra) {
        double tetrahedronArea = Math.sqrt(3)* Math.pow(tetra.getEdge(),2);
        double lateralSurfaceArea = (3*Math.sqrt(3))/4 * Math.pow(tetra.getEdge(),2);
        return tetrahedronArea;
    }

    @Override
    public double tetrahedronVolume(Tetrahedron tetra) {
        double tetrahedronArea = Math.sqrt(3)* Math.pow(tetra.getEdge(),2);
        return 1/3 * tetrahedronArea * tetra.getHeight();
    }

    @Override
    public double tetrahedronVolumeRatio(Tetrahedron tetra,Point point) throws CustomException {
        if (point.getZ() <= tetra.getCenter().getZ() || point.getZ() >= tetra.getCenter().getZ() + tetra.getHeight()) {
            throw new CustomException(" No sections from point " + point.toString());
        } else {
            double secondHeight = point.getZ() - tetra.getCenter().getZ();
            double firstHeight = tetra.getHeight() - secondHeight;
            double firstEdge = firstHeight * tetra.getEdge() / tetra.getHeight();
            double firstTetraVolume = tetrahedronVolume(new Tetrahedron(tetra.getCenter(), /*firstRadius,*/ firstHeight,firstEdge));
            double secondConeVolume = tetrahedronVolume(tetra) - firstTetraVolume;
            return firstTetraVolume / secondConeVolume;
        }
    }

    @Override
    public boolean isTetrahedron( double edge, double height) {
        return edge > 0 && height > 0;
    }

    @Override
    public boolean isBaseOnPlane(Tetrahedron tetra) {
        return tetra.getCenter().getZ() == 0;
    }
}
