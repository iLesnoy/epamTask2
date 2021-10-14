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
            throw new CustomException("There are no sections from point " + point.toString());
        } else {
            double secondHeight = point.getZ() - tetra.getCenter().getZ();
            double firstHeight = tetra.getHeight() - secondHeight;
            double firstRadius = firstHeight * tetra.getRadius() / tetra.getHeight();
            double firstConeVolume = tetrahedronVolume(new Tetrahedron(tetra.getCenter(), firstRadius, firstHeight));
            double secondConeVolume = tetrahedronVolume(tetra) - firstConeVolume;
            /*logger.log(Level.INFO, "Volume ratio of cone " + cone.toString() + " and point " + point.toString() + ": " + coneVolumeRatio);*/
            return firstConeVolume / secondConeVolume;
        }
    }

    @Override
    public boolean isTetrahedron( double radius, double height) {
        return radius > 0 && height > 0;
    }

    @Override
    public boolean isBaseOnPlane(Tetrahedron tetra) {
        boolean isBaseOnPlane =  tetra.getCenter().getZ() == 0;
        return isBaseOnPlane;
    }
}
