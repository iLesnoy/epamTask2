package epam.task.shapes.repository;

import epam.task.shapes.entity.Tetrahedron;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public interface Repository {

    void addTetrahedron(Tetrahedron tetra);

    boolean removeTetrahedron(Tetrahedron tetra);

    void addAllTetrahedrons(Collection<Tetrahedron> tetra);

    boolean removeAllTetrahedrons(Collection<Tetrahedron> tetra);

    /*List<? super Tetrahedron> query( );

    List sort(Comparator<? super Tetrahedron> comparator);*/
}
