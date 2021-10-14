package epam.task.shapes.oserver;

import epam.task.shapes.entity.Tetrahedron;
import epam.task.shapes.exception.CustomException;

public interface TetrahedronObserver {

    void updateTetraVolume(TetraEvent event)throws CustomException;

    void updateArea(TetraEvent event) throws CustomException;

}
