package epam.task.shapes.entity;

import epam.task.shapes.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Warehouse {

    private static final Logger logger = LogManager.getLogger();
    private static Warehouse instance;
    private Map<Long, TetraParameters> mapParameters;


    public Warehouse() {
        this.mapParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public TetraParameters putById(Long tetraId, TetraParameters tetraParameters) {
        return mapParameters.put(tetraId, tetraParameters);
    }

    public int warehouseSize() {
        return mapParameters.size();
    }

    public TetraParameters removeById(Long tetraId) {
        return mapParameters.remove(tetraId);
    }

    public TetraParameters getById(Long tetraId) throws CustomException {
        TetraParameters tetraParameters = mapParameters.get(tetraId);
        if (tetraParameters == null) {
            logger.log(Level.ERROR, " no such element by id " + tetraId);
            throw new CustomException(" no such element by id " + tetraId);
        }
        return tetraParameters;
    }

}
