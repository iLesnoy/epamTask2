package epam.task.shapes.comparator;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.Tetrahedron;

import java.util.Comparator;

public class TetraVolumeComparator implements Comparator<Tetrahedron> {

    @Override
    public int compare(Tetrahedron o1, Tetrahedron o2) {
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double firsTetraVolume = calculation.tetrahedronVolume(o1);
        double secondTetraVolume = calculation.tetrahedronVolume(o2);

        return Double.compare(firsTetraVolume,secondTetraVolume);
    }
}