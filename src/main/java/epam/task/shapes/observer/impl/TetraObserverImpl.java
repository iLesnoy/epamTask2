package epam.task.shapes.observer.impl;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.TetraParameters;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.observer.TetraEvent;
import epam.task.shapes.observer.TetrahedronObserver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TetraObserverImpl implements TetrahedronObserver {

    private static Logger logger = LogManager.getLogger();


    @Override
    public void updateTetraVolume(TetraEvent event) {
        try {
            Tetrahedron tetra = event.getSource();
            long id = tetra.getTetraId();
            Warehouse warehouse = Warehouse.getInstance();
            TetraParameters parameters;
            parameters = warehouse.getById(id);
            TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
            double volume = calculation.tetrahedronVolume(tetra);
            parameters.setVolume(volume);
        } catch (CustomException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void updateArea(TetraEvent event) {
        try {
            Tetrahedron tetra = event.getSource();
            long id = tetra.getTetraId();
            Warehouse warehouse = Warehouse.getInstance();
            TetraParameters parameters;
            parameters = warehouse.getById(id);
            TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
            double volume = calculation.tetrahedronArea(tetra);
            parameters.setArea(volume);
        } catch (CustomException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }
}
