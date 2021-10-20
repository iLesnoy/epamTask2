package epam.task.shapes.repository.impl;

import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.repository.Specification;

public class SquareSpecification implements Specification {

    @Override
    public boolean specify(Tetrahedron tetra) {
        boolean isSpecified = (tetra.getCenter().getX() > 0 && tetra.getCenter().getY() > 0 && tetra.getCenter().getZ() > 0);

        return isSpecified;
    }
}
