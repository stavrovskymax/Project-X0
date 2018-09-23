package ru.lesson.X0.controllers;

import ru.lesson.X0.model.Field;
import ru.lesson.X0.model.Figure;
import ru.lesson.X0.model.exceptions.AlreadyOccupiedException;
import ru.lesson.X0.model.exceptions.InvalidPointException;

import java.awt.*;

public class MoveController {

    public void applyFigure(final Field field,
                            final Point point,
                            final Figure figure) throws InvalidPointException,
                                                        AlreadyOccupiedException {
        if (field.getFigure(point) != null) {
            throw new AlreadyOccupiedException();
        }

        field.setFigure(point, figure);
    }
}
