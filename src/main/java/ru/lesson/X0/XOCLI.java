package ru.lesson.X0;

import ru.lesson.X0.model.Field;
import ru.lesson.X0.model.Figure;
import ru.lesson.X0.model.Game;
import ru.lesson.X0.model.Player;
import ru.lesson.X0.view.ConsoleView;

public class XOCLI {
    public static void main(final String[] args) {
        final String name1 = "Max";
        final String name2 = "Slava";

        final Player[] players = new Player[2];
        players[0] = new Player(name1, Figure.X);
        players[1] = new Player(name2, Figure.O);

        final Game game = new Game(players, new Field(3), "X0");

        final ConsoleView consoleView = new ConsoleView();
        consoleView.show(game);
        while (consoleView.move(game))
            consoleView.show(game);
    }
}
