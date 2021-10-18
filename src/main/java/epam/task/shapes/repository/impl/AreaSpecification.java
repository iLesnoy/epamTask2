package epam.task.shapes.repository.impl;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.repository.Specification;

public class AreaSpecification implements Specification {
    private double minArea;
    private double maxArea;

    public AreaSpecification(double minArea, double maxArea) {
        this.minArea = minArea;
        this.maxArea = maxArea;
    }

    @Override
    public boolean specify(Tetrahedron tetra) {
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double area = calculation.tetrahedronArea(tetra);
        boolean isSpecified = (area >= minArea && area <= maxArea);
        return isSpecified;
    }
}