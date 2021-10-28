package epam.task.shapes.observer.impl;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.TetraParameters;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import epam.task.shapes.observer.TetraEvent;
import epam.task.shapes.repository.impl.ConeRepositoryImpl;
import epam.task.shapes.service.CustomRepositoryService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TetraObserverImplTest {

    Point point = new Point(1,2,3);
    Tetrahedron tetrahedron = new Tetrahedron(point,2,3);
    CustomRepositoryService repositoryService = new CustomRepositoryService();

    @Test
    @DisplayName("VolumeUpdate")
    void updateTetraVolume(){
        repositoryService.fillConeRepository(point,2,3);
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        TetraParameters parameters = new TetraParameters(calculation.tetrahedronArea(tetrahedron),
                calculation.tetrahedronVolume(tetrahedron));
        parameters.setVolume(14);
        assertEquals(parameters.getVolume(),14);

    }

    @Test
    @DisplayName("AreaUpdate")
    void updateArea() {
        repositoryService.fillConeRepository(point,2,3);
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        TetraParameters parameters = new TetraParameters(calculation.tetrahedronArea(tetrahedron),
                calculation.tetrahedronArea(tetrahedron));
        parameters.setArea(19);
        assertEquals(parameters.getArea(),19);


    }
}