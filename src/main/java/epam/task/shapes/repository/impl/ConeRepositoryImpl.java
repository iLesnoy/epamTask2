package epam.task.shapes.repository.impl;

import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.repository.Specification;
import epam.task.shapes.repository.TetraRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;
import java.util.stream.Collectors;

public class ConeRepositoryImpl implements TetraRepository {

    private static Logger logger = LogManager.getLogger();
    private static ConeRepositoryImpl instance;
    private List<Tetrahedron> tetraList;

    public ConeRepositoryImpl() {
        tetraList = new ArrayList<>();
    }

    public static ConeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new ConeRepositoryImpl();
        }
        return instance;
    }

    public int size() {
        return tetraList.size();
    }

    public List<Tetrahedron> getTetraList() {
        return Collections.unmodifiableList(tetraList);
    }

    public Tetrahedron get(int index) {
        return tetraList.get(index);
    }


    @Override
    public void addTetrahedron(Tetrahedron tetra) {
        tetraList.add(tetra);
    }

    @Override
    public void addAllTetrahedrons(Collection<Tetrahedron> tetra) {
        tetraList.addAll(tetra);
    }

    @Override
    public void removeTetrahedron(Tetrahedron tetra) {
         tetraList.remove(tetra);
    }

    @Override
    public boolean removeAllTetrahedrons(Collection<Tetrahedron> tetra) {
        return tetraList.removeAll(tetra);
    }

    @Override
    public List<? super Tetrahedron> query(Specification specification) {
        List<Tetrahedron> finalList = tetraList.stream().
                filter(specification::specify).
                collect(Collectors.toList());
        return finalList;
    }

    @Override
    public List sort(Comparator<? super Tetrahedron> comparator) {
        List<Tetrahedron> finalList = tetraList.stream().
                sorted(comparator).
                collect(Collectors.toList());
        return finalList;
    }
}
