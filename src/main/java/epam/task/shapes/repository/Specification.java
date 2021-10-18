package epam.task.shapes.repository;

import epam.task.shapes.entity.Tetrahedron;

public interface Specification {

        boolean specify(Tetrahedron tetrahedron);
}
