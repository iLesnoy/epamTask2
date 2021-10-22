package epam.task.shapes.repository.impl;

import epam.task.shapes.comparator.TetraHeightComparator;
import epam.task.shapes.comparator.TetraIdComparator;
import epam.task.shapes.entity.Point;
import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.service.CustomRepositoryService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ConeRepositoryImplTest {
    
    Point point = new Point(1,2,3);
    Tetrahedron tetra = new Tetrahedron(point,2,10);
    Tetrahedron tetra1 = new Tetrahedron(point,3,9);
    ConeRepositoryImpl repository = new ConeRepositoryImpl();
    Collection<Tetrahedron> tetraList = new ArrayList<>();

    

    @Test
    void size() {
        repository.addTetrahedron(tetra);
        assertEquals(repository.size(),1);
    }


    @Test
    void get() {
        repository.addTetrahedron(tetra);
        assertEquals(repository.get(0), tetra);
    }

    @Test
    void addTetrahedron() {
        repository.addTetrahedron(tetra);
        int expectedSizeAfterRemove = 1;
        assertEquals(expectedSizeAfterRemove, repository.size());
    }


    @Test
    void addAllTetrahedrons() {
        tetraList.add(tetra);
        tetraList.add(tetra1);
        repository.addAllTetrahedrons(tetraList);
        assertTrue(tetraList.contains(repository.get(0)));
    }

    @Test
    void removeTetrahedron() {
        addAllTetrahedrons();
        repository.removeTetrahedron(tetra);
        int expectedSizeAfterRemove = 1;
        assertEquals(expectedSizeAfterRemove, repository.size());
    }

    @Test
    void removeAllTetrahedrons() {
        addAllTetrahedrons();
        assertTrue(repository.removeAllTetrahedrons(tetraList));
    }

    @Test
    void query() {
        addTetrahedron();
        IdSpecification specification = new IdSpecification(1);
        assertEquals(repository.query(specification),repository.get(0));
    }

    @Test
    void sort() {
        addAllTetrahedrons();
        TetraHeightComparator comparator = new TetraHeightComparator();
        repository.sort(comparator);
        assertEquals(repository.get(0), tetra);
    }
}