package ru.lesson.X0.controllers;

import ru.lesson.X0.model.Field;
import ru.lesson.X0.model.Figure;
import ru.lesson.X0.model.exceptions.InvalidPointException;

import java.awt.*;

public class CurrentMoveController {

    public Figure currentFigure(final Field field) {
        int currentFigure = 0;

        for (int x = 0; x < field.getSize(); x++) {
            currentFigure += countFiguresInTheRow(field, x);
        }

        if (currentFigure == field.getSize() * field.getSize())
            return null;

        if (currentFigure % 2 == 0)
            return Figure.X;

        return Figure.O;
    }

    private int countFiguresInTheRow(final Field field, final int row) {
        int currentFigure = 0;

        for (int x = 0; x < field.getSize(); x++) {
            try {
                if (field.getFigure(new Point(x, row)) != null)
                    currentFigure++;
                } catch (final InvalidPointException e) {
                    e.printStackTrace();
                }
            }
        return currentFigure;
    }
}
