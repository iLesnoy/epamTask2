package epam.task.shapes.service;

import epam.task.shapes.action.impl.TetrahedronCalculationImpl;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.TetraParameters;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.entity.Warehouse;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomWarehouseService {
    private static Logger logger = LogManager.getLogger();

    public void fillConeWarehouse(Tetrahedron tetra) {
        long id = tetra.getTetraId();
        TetrahedronCalculationImpl calculationService = new TetrahedronCalculationImpl ();
        double tetraArea = calculationService.tetrahedronArea(tetra);
        double volume = calculationService.tetrahedronArea(tetra);
        TetraParameters parameters = new TetraParameters(tetraArea, volume);
        Warehouse warehouse = Warehouse.getInstance();
        warehouse.put(id, parameters);
        logger.log(Level.INFO, "add cone " + tetra + " to warehouse");
    }

    public void fillConeWarehouse(Point center, double edge, double height) throws CustomException {
        Tetrahedron tetra = ShapeFactory.createTetra(center, edge, height);
        fillConeWarehouse(tetra);
    }

    public void fillConeWarehouse(double x, double y, double z, double edge, double height) throws CustomException {
        Tetrahedron tetra = ShapeFactory.createTetra(x, y, z, edge, height);
        fillConeWarehouse(tetra);
    }

    public void fillConeWarehouse(double[] array) throws CustomException {
        Tetrahedron tetra = ShapeFactory.createTetra(array);
        fillConeWarehouse(tetra);
    }
}