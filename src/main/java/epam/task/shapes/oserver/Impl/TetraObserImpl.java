package epam.task.shapes.oserver.Impl;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.TetraParameters;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.oserver.TetraEvent;
import epam.task.shapes.oserver.TetrahedronObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetraObserImpl implements TetrahedronObserver {

    private static Logger logger = LogManager.getLogger();

    @Override
    public void updateTetraVolume(TetraEvent event) throws CustomException {
        Tetrahedron tetra = event.getSource();
        long id = tetra.getId();
        Warehouse warehouse = Warehouse.getInstance();
        TetraParameters parameters = warehouse.get(id);
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double volume = calculation.tetrahedronVolume(tetra);
        parameters.setVolume(volume);
    }

    @Override
    public void updateArea(TetraEvent event) throws CustomException {
        Tetrahedron tetra = event.getSource();
        long id = tetra.getId();
        Warehouse warehouse = Warehouse.getInstance();
        TetraParameters parameters = warehouse.get(id);
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double volume = calculation.tetrahedronArea(tetra);
        parameters.setSurfaceArea(volume);
    }
}
