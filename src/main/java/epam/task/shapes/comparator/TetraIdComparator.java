package epam.task.shapes.comparator;

import epam.task.shapes.entity.Tetrahedron;

import java.util.Comparator;

public class TetraIdComparator implements Comparator<Tetrahedron> {

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return Long.compare(o1.getTetraId(),o2.getTetraId());
    }
}
