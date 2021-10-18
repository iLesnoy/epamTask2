package epam.task.shapes.repository.impl;

import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.repository.Specification;

public class IdSpecification implements Specification {

    private long figureId;

    public IdSpecification(long figureId) {
        this.figureId = figureId;
    }


    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        boolean isSpecified = tetrahedron.getTetraId() == figureId;
        return isSpecified;
    }
}
