package epam.task.shapes.service;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.TetraParameters;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomRepositoryServiceTest {

    @Test
    void fillConeRepository(){
        Tetrahedron tetra = ShapeFactory.createTetra(1,2,3,4,5);
        TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
        TetraParameters parameters = new TetraParameters(calculation.tetrahedronArea(tetra),calculation.tetrahedronVolume(tetra));
        Warehouse warehouse = new Warehouse();
        warehouse.putById(4L,parameters);
        CustomWarehouseService filler = new CustomWarehouseService();
        filler.fillConeWarehouse(tetra);
        int expectedWarehouseSize = 1;
        assertEquals(expectedWarehouseSize,warehouse.warehouseSize());
    }

}