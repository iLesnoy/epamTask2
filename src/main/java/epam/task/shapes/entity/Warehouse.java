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


    private Warehouse() {
        this.mapParameters = new HashMap<>();
    }

    public static Warehouse getInstance() {
        if (instance == null) {
            instance = new Warehouse();
        }
        return instance;
    }

    public TetraParameters put(Long tetraId, TetraParameters tetraParameters) {
        return mapParameters.put(tetraId, tetraParameters);
    }

    public TetraParameters remove(Long coneId) {
        return mapParameters.remove(coneId);
    }

    public TetraParameters get(Long tetraID) throws CustomException {
        TetraParameters tetraParameters = mapParameters.get(tetraID);
        if (tetraParameters == null) {
            logger.log(Level.ERROR, " no such element by id " + tetraID);
            throw new CustomException(" no such element by id " + tetraID);
        }
        return tetraParameters;
    }
}
