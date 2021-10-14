package epam.task.shapes.action.impl;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import epam.task.shapes.filereader.CustomFileReader;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TetrahedronCalculationImplTest {


    @Test
    void tetrahedronArea() throws CustomException {
        TetrahedronCalculationImpl  calculation = new TetrahedronCalculationImpl();
        Point point = new Point(1,2,3);
        Tetrahedron tetrahedron = ShapeFactory.createTetra(1,2,3,4,5);
        double actualArea = calculation.tetrahedronArea(tetrahedron);
        double expectedArea = 2.94;
        assertEquals(actualArea,expectedArea,0.001);

    }

    @Test
    void tetrahedronVolume() {
    }

    @Test
    void tetrahedronVolumeRatio() {
    }

    @Test
    void isTetrahedron() {
    }

    @Test
    void isBaseOnPlane() {
    }
}