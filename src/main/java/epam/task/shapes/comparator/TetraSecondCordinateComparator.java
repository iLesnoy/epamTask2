package epam.task.shapes.comparator;

import epam.task.shapes.entity.Tetrahedron;

import java.util.Comparator;

public class TetraSecondCordinateComparator implements Comparator<Tetrahedron> {

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        return Double.compare(o1.getCenter().getY(),o2.getCenter().getY());
    }
}
