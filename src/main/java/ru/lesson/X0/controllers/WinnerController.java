package ru.lesson.X0.controllers;

import ru.lesson.X0.model.Field;
import ru.lesson.X0.model.Figure;
import ru.lesson.X0.model.exceptions.InvalidPointException;

import java.awt.*;

public class WinnerController {

    public Figure getWinner(final Field field) throws InvalidPointException {
        final int fieldSize = field.getSize();

        for (int i = 0; i < fieldSize; i++) {
            if (check(field, new Point(i, 0), p -> new Point(p.x, p.y + 1)))
                return field.getFigure(new Point(i, 0));

            if (check(field, new Point(0, i), p -> new Point(p.x + 1, p.y)))
                return field.getFigure(new Point(0, i));

            if (check(field, new Point(0, 0), p -> new Point(p.x + 1, p.y + 1)))
                return field.getFigure(new Point(0, 0));

            if (check(field, new Point(0, fieldSize - 1), p -> new Point(p.x + 1, p.y - 1)))
                return field.getFigure(new Point(0, fieldSize - 1));
        }
        return null;
    }

    private boolean check(final Field field,
                          final Point currentPoint,
                          final IPointGenerator pointGenerator) {
        final Figure currentFigure;
        final Figure nextFigure;
        final Point nextPoint = pointGenerator.next(currentPoint);
        try {
            currentFigure = field.getFigure(currentPoint);
            nextFigure = field.getFigure(nextPoint);

            if (currentFigure == null)
                return false;
        } catch (final InvalidPointException e) {
            return true;
        }

        if (currentFigure != nextFigure)
            return false;

        return check(field, nextPoint, pointGenerator);
    }

    private interface IPointGenerator {
        Point next(final Point point);
    }
}
