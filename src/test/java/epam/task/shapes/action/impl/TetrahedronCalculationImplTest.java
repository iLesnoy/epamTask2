package epam.task.shapes.action.impl;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;
import epam.task.shapes.factory.ShapeFactory;
import epam.task.shapes.filereader.CustomFileReader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TetrahedronCalculationImplTest {

    TetrahedronCalculationImpl  calculation = new TetrahedronCalculationImpl();

    @Test
    void tetrahedronArea() throws CustomException {
        Tetrahedron tetrahedron = ShapeFactory.createTetra(1,2,3,4,5);
        double actualArea = calculation.tetrahedronArea(tetrahedron);
        double expectedArea = 27.71;
        assertEquals(actualArea,expectedArea,0.01);

    }

    @Test
    void tetrahedronVolume() throws CustomException {
        Tetrahedron tetrahedron = ShapeFactory.createTetra(1,2,3,4,5);
        double actualVolume = calculation.tetrahedronVolume(tetrahedron);
        double expectedVolume = 7.54;
        assertEquals(actualVolume,expectedVolume,0.01);
    }

    @Test
    void tetrahedronVolumeRatio() throws CustomException {
        Point point = new Point(1,2,3);
        Tetrahedron tetrahedron = ShapeFactory.createTetra(5,4,2,4,5);
        double actualVolumeRatio = calculation.tetrahedronVolumeRatio(tetrahedron,point);
        double expectedVolumeRatio = 1.78;
        assertEquals(actualVolumeRatio,expectedVolumeRatio,0.01);
    }

    @Test
    void isTetrahedron() {
        boolean isTetrahedron = calculation.isTetrahedron(4,-6);
        assertFalse(isTetrahedron);
    }

    @Test
    void isBaseOnPlane() throws CustomException {
        Tetrahedron tetrahedron = ShapeFactory.createTetra(0,4,0,4,5);
        calculation.isBaseOnPlane(tetrahedron);
        boolean isBaseOnPlane = calculation.isBaseOnPlane(tetrahedron);
        assertTrue(isBaseOnPlane);
    }
}