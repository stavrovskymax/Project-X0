package ru.lesson.X0.controllers;

import org.junit.Test;
import ru.lesson.X0.model.Field;
import ru.lesson.X0.model.Figure;

import java.awt.*;

import static org.junit.Assert.*;

public class WinnerControllerTest {

    @Test
    public void testGetWinnerWhenWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i=0; i<3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.X);
            final Figure expected = Figure.X;
            final Figure actual = winnerController.getWinner(field);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerRow() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i=0; i<3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(i,0), Figure.X);
            field.setFigure(new Point(i,1), Figure.X);
            field.setFigure(new Point(i,2), Figure.O);
            final Figure actual = winnerController.getWinner(field);
            assertNull(actual);
        }
    }

    @Test
    public void testGetWinnerWhenWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i=0; i<3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.X);
            final Figure expected = Figure.X;
            final Figure actual = winnerController.getWinner(field);
            assertEquals(expected, actual);
        }
    }

    @Test
    public void testGetWinnerWhenNoWinnerColumn() throws Exception {
        final WinnerController winnerController = new WinnerController();

        for (int i=0; i<3; i++) {
            final Field field = new Field(3);
            field.setFigure(new Point(0,i), Figure.X);
            field.setFigure(new Point(1,i), Figure.X);
            field.setFigure(new Point(2,i), Figure.O);
            final Figure actual = winnerController.getWinner(field);
            assertNull(actual);
        }
    }
}