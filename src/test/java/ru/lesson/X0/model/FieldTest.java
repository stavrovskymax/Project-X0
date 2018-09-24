package ru.lesson.X0.model;

import org.junit.Test;
import ru.lesson.X0.model.exceptions.AlreadyOccupiedException;
import ru.lesson.X0.model.exceptions.InvalidPointException;

import java.awt.*;

import static org.junit.Assert.*;

public class FieldTest {

    @Test
    public void testGetSize() throws Exception {
        final Field field = new Field(3);

        assertEquals(3, field.getSize());
    }

    @Test
    public void testSetFigure() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(0, 0);
        final Figure inputFigure = Figure.O;

        field.setFigure(inputPoint, inputFigure);
        final Figure actualFigure = field.getFigure(inputPoint);

        assertEquals(inputFigure, actualFigure);
    }

    @Test
    public void testGetFigureWhenFigureIsNotSet() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(0, 0);

        final Figure actualFigure = field.getFigure(inputPoint);

        assertNull(actualFigure);
    }

    @Test
    public void testGetFigureWhenXIsLessThenZero() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(-1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsLessThenZero() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(0, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXIsMoreThenSize() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(field.getSize() + 1, 0);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenYIsMoreThenSize() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(0, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXAndYIsLessThenZero() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(-1, -1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }

    @Test
    public void testGetFigureWhenXAndYIsMoreThenSize() throws Exception{
        final Field field = new Field(3);

        final Point inputPoint = new Point(field.getSize() + 1, field.getSize() + 1);

        try {
            field.getFigure(inputPoint);
            fail();
        } catch (final InvalidPointException e) {}
    }
}