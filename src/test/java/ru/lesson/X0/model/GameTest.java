package ru.lesson.X0.model;

import org.junit.Test;
import static org.junit.Assert.*;

public class GameTest {

    public static final String inputPlayer = "Max";
    public static final Figure inputFigure = Figure.O;

    @Test
    public void testGetPlayers() {
        final Player player[] = new Player[1];
        player[0] = new Player(inputPlayer, inputFigure);

        final Field field = new Field();
        final Game game = new Game(player, field, inputPlayer);

        final Player[] actualValue = game.getPlayers();

        assertSame(player, actualValue);
    }
}