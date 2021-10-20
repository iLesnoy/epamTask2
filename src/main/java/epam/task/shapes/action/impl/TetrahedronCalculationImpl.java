package epam.task.shapes.action.impl;

import epam.task.shapes.action.TetrahedronCalculation;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;

import java.text.DecimalFormat;


public class TetrahedronCalculationImpl implements TetrahedronCalculation {

    @Override
    public double tetrahedronArea(Tetrahedron tetra) {
        double scale = Math.pow(10, 2);
        double tetrahedronArea = Math.round(scale * Math.sqrt(3)* Math.pow(tetra.getEdge(),2))/scale;
        return tetrahedronArea;
    }

    @Override
    public double tetrahedronVolume(Tetrahedron tetra) {
        double scale = Math.pow(10, 2);
        double tetrahedronArea = Math.sqrt(3)* Math.pow(tetra.getEdge(),2);
        return Math.round(scale * 1/3 * tetrahedronArea * tetra.getHeight())/scale;
    }

    @Override
    public double tetrahedronVolumeRatio(Tetrahedron tetra,Point point) throws CustomException {
        double scale = Math.pow(10, 2);
        if (point.getZ() <= tetra.getCenter().getZ() || point.getZ() >= tetra.getCenter().getZ() + tetra.getHeight()) {
            throw new CustomException(" No sections from point " + point.toString());
        } else {
            double secondHeight = point.getZ() - tetra.getCenter().getZ();
            double firstHeight = tetra.getHeight() - secondHeight;
            double firstEdge = firstHeight * tetra.getEdge() / tetra.getHeight();
            double firstTetraVolume = tetrahedronVolume(new Tetrahedron(tetra.getCenter(),firstHeight,firstEdge));
            double secondConeVolume = tetrahedronVolume(tetra) - firstTetraVolume;
            return Math.round(scale * firstTetraVolume / secondConeVolume)/scale;
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
