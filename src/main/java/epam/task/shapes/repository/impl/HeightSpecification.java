package epam.task.shapes.repository.impl;

import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.repository.Specification;

public class HeightSpecification implements Specification {
    private double minHeight;
    private double maxHeight;

    public HeightSpecification(double minHeight, double maxHeight) {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    @Override
    public boolean specify(Tetrahedron tetra) {
        boolean isSpecified = (tetra.getHeight() >= minHeight && tetra.getHeight() <= maxHeight);
        return isSpecified;
    }
}