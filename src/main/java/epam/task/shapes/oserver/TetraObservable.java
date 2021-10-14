package epam.task.shapes.oserver;

import epam.task.shapes.exception.CustomException;

public interface TetraObservable<T extends TetrahedronObserver> {

    void attach(T observer);

    void detach(T observer);

    void notifyObservers() throws CustomException;


}
