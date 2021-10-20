package epam.task.shapes.repository.impl;

import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.service.CustomRepositoryService;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConeRepositoryImplTest {
    
    Point point = new Point(1,2,3);
    Tetrahedron tetra = new Tetrahedron(point,2,3);
    Tetrahedron tetra1 = new Tetrahedron(point,3,4);
    ConeRepositoryImpl repository = new ConeRepositoryImpl();
    Collection<Tetrahedron> tetraList;

    

    @Test
    void size() {
        repository.addTetrahedron(tetra);
        assertEquals(repository.size(),1);
    }


    @Test
    void get() {
        repository.addTetrahedron(tetra);
        assertTrue(repository.get(0).equals(tetra));
    }

    @Test
    void addTetrahedron() {
    }


    @Test
    void addAllTetrahedrons() {
        tetraList.add(tetra);
        tetraList.add(tetra1);
        System.out.println(tetraList);
        repository.addAllTetrahedrons(tetraList);
        assertTrue(repository.get(1).equals(tetra));
    }

    @Test
    void removeTetrahedron() {

    }

    @Test
    void removeAllTetrahedrons() {
    }

    @Test
    void query() {
    }

    @Test
    void sort() {
    }
}