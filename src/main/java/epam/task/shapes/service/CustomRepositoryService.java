package epam.task.shapes.service;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import epam.task.shapes.repository.impl.ConeRepositoryImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CustomRepositoryService {

    private static Logger logger = LogManager.getLogger();

    public void fillConeRepository(Point center, double edge, double height) {
        Tetrahedron tetra = ShapeFactory.createTetra(center, edge, height);
        ConeRepositoryImpl repository = ConeRepositoryImpl.getInstance();
        repository.addTetrahedron(tetra);
        CustomWarehouseService filler = new CustomWarehouseService();
        filler.fillConeWarehouse(tetra);
        logger.log(Level.INFO, "add cone " + tetra + " to repository");
    }

    public void fillConeRepository(double x, double y, double z, double edge, double height) throws  CustomException {
        Tetrahedron tetra = ShapeFactory.createTetra(x, y, z, edge, height);
        ConeRepositoryImpl repository = ConeRepositoryImpl.getInstance();
        repository.addTetrahedron(tetra);
        CustomWarehouseService filler = new CustomWarehouseService();
        filler.fillConeWarehouse(tetra);
        logger.log(Level.INFO, "add cone " + tetra + " to repository");
    }

    public void fillConeRepository(double[] array){
        Tetrahedron tetra = ShapeFactory.createTetra(array);
        ConeRepositoryImpl repository = ConeRepositoryImpl.getInstance();
        repository.addTetrahedron(tetra);
        CustomWarehouseService filler = new CustomWarehouseService();
        filler.fillConeWarehouse(tetra);
        logger.log(Level.INFO, "add cone " + tetra + " to repository");
    }
}
