package epam.task.shapes.observer.Impl;

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
        Tetrahedron tetra = event.getSource();             /*извекли объект*/
        long id = tetra.getTetraId();                         /*извекли ID объектa*/
        Warehouse warehouse = Warehouse.getInstance();          /*получили доступ к warehouse*/
        TetraParameters parameters = null;          /*извекли параметры по ID из warehouse*/
        try {
            parameters = warehouse.get(id);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double volume = calculation.tetrahedronVolume(tetra);
        parameters.setVolume(volume);
    }

    @Override
    public void updateArea(TetraEvent event){
        Tetrahedron tetra = event.getSource();
        long id = tetra.getTetraId();
        Warehouse warehouse = Warehouse.getInstance();
        TetraParameters parameters = null;
        try {
            parameters = warehouse.get(id);
        } catch (CustomException e) {
            e.printStackTrace();
        }
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        double volume = calculation.tetrahedronArea(tetra);
        parameters.setSurfaceArea(volume);
    }
}
