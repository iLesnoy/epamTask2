package epam.task.shapes.observer;

import epam.task.shapes.exception.CustomException;

public interface TetrahedronObserver {

    void updateTetraVolume(TetraEvent event) ;

    void updateArea(TetraEvent event);

}
