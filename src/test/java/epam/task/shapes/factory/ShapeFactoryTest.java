package epam.task.shapes.factory;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShapeFactoryTest {

    Tetrahedron actualTetra;
    Tetrahedron expectedTetrahedron;
    Point center = new Point(1,2,3);

    @Test
    void createTetra() throws CustomException {
        expectedTetrahedron = ShapeFactory.createTetra(1,2,3,4,5);
        actualTetra = ShapeFactory.createTetra(1,2,3,4,5);
        actualTetra.setTetraId(1);
        assertEquals(expectedTetrahedron,actualTetra);
    }

    @Test
    void CreateTetraByCenter(){
        actualTetra = ShapeFactory.createTetra(center,4,5);
        expectedTetrahedron = ShapeFactory.createTetra(1,2,3,4,5);
        expectedTetrahedron.setTetraId(1);
        assertEquals(actualTetra, expectedTetrahedron);
    }

    @Test
    void testCreateTetraByParam(){
        double [] actualTetraValues = {-4.0,8.0,5.0,1.4,1.6};
        actualTetra = ShapeFactory.createTetra(actualTetraValues);
        expectedTetrahedron = ShapeFactory.createTetra(-4.0,8.0,5.0,1.4,1.6);
        expectedTetrahedron.setTetraId(1);
        assertEquals(actualTetra, expectedTetrahedron);
    }
}