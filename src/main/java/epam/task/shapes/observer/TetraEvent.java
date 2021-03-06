package epam.task.shapes.observer;

import epam.task.shapes.entity.Tetrahedron;

import java.util.EventObject;

public class TetraEvent extends EventObject {

    public TetraEvent(Tetrahedron source) {
        super(source);
    }

    @Override
    public Tetrahedron getSource() {
        return (Tetrahedron) super.getSource();
    }
    /*Возврещеает источник события* (observera)*/

}
