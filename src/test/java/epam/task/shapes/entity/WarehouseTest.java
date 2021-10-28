package epam.task.shapes.entity;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import epam.task.shapes.service.CustomWarehouseService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WarehouseTest {

    private static final Logger logger = LogManager.getLogger(Warehouse.class);
    TetrahedronCalculationImpl calculation = new TetrahedronCalculationImpl();
    Warehouse warehouse = new Warehouse();
    Tetrahedron tetrahedron = ShapeFactory.createTetra(5,4,2,4,5);

    @BeforeEach
    @Test
    void putById(){
        double tetraVolume = calculation.tetrahedronVolume(tetrahedron);
        double tetraArea = calculation.tetrahedronArea(tetrahedron);
        TetraParameters parameters = new TetraParameters(tetraVolume,tetraArea);
        warehouse.putById(1L,parameters);
        assertEquals(1, warehouse.warehouseSize());
    }

    @Test
    void getById() {
        try {
            double tetraVolume = calculation.tetrahedronVolume(tetrahedron);
            double tetraArea = calculation.tetrahedronArea(tetrahedron);
            TetraParameters expectedParameters = new TetraParameters(tetraVolume,tetraArea);
            assertEquals(warehouse.getById(1L), expectedParameters);
        } catch (CustomException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }
    }

    @Test
    void removeById() {
        warehouse.removeById(1L);
        int expectedWarehouseSize = 0;
        assertEquals(expectedWarehouseSize, warehouse.warehouseSize());
    }
}