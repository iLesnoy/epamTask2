package epam.task.shapes.repository.impl;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.repository.Specification;

public class VolumeSpecification implements Specification {

    private final double minVolume;
    private final double maxVolume;

    public VolumeSpecification(double minVolume, double maxVolume) {
        this.minVolume = minVolume;
        this.maxVolume = maxVolume;
    }

    @Override
    public boolean specify(Tetrahedron tetrahedron) {
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double volume = calculation.tetrahedronVolume(tetrahedron);
        return (minVolume <= volume && volume <= maxVolume);
    }
}
