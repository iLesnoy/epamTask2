package epam.task.shapes.repository;

import epam.task.shapes.entity.Tetrahedron;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface TetraRepository {

    void addTetrahedron(Tetrahedron tetra);

    void addAllTetrahedrons(Collection<Tetrahedron> tetra);

    boolean removeTetrahedron(Tetrahedron tetra);

    boolean removeAllTetrahedrons(Collection<Tetrahedron> tetra);

    List<? super Tetrahedron> query(Specification specification );

    List sort(Comparator<? super Tetrahedron> comparator);
}
