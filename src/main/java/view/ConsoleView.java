package view;

import ru.lesson.X0.controllers.CurrentMoveController;
import ru.lesson.X0.controllers.MoveController;
import ru.lesson.X0.controllers.WinnerController;
import ru.lesson.X0.model.Field;
import ru.lesson.X0.model.Figure;
import ru.lesson.X0.model.Game;
import ru.lesson.X0.model.exceptions.AlreadyOccupiedException;
import ru.lesson.X0.model.exceptions.InvalidPointException;

import java.awt.*;
import java.util.Scanner;

public class ConsoleView {

    private CurrentMoveController currentMoveController = new CurrentMoveController();

    private WinnerController winnerController = new WinnerController();

    private MoveController moveController = new MoveController();

    public void show(final Game game) {
        System.out.format("Game name: %s\n", game.getName()); /// ???
        final Field field = game.getField();
        for (int x=0; x < field.getSize(); x++) {
            if (x != 0)
                printSeparator();
            printLine(field, x);
        }
    }

    public boolean move(final Game game) {
        final Field field = game.getField();
        final Figure currentFigure = currentMoveController.currentFigure(field);
        if (currentFigure == null) {
            final Figure winner = winnerController.getWinner(field);
            if (winner == null) {
                System.out.println("No winner and no moves left");
                return false;
            } else {
                System.out.format("Winner is: %s\n", winner);
                return false;
            }
        }
        System.out.format("Please enter move point for: %s", currentFigure);
        final Point point = askPoint();
        try {
            moveController.applyFigure(field, point, currentFigure);
        } catch (InvalidPointException | AlreadyOccupiedException e) {
            e.printStackTrace();
            System.out.println("Point is invalid");
        }
        return true;
    }

    private Point askPoint() {
        return new Point(askCoordinate("X")-1, askCoordinate("Y")-1);
    }

    private int askCoordinate(final String coordinateName) {
        System.out.format("Please input %s: ", coordinateName);
        final Scanner in = new Scanner(System.in);
        return in.nextInt();
    }

    private void printLine(final Field field, final int x) {
        for (int y=0; y < field.getSize(); y++) {
            if (y != 0)
                System.out.print("|");
            System.out.print(" ");
            final Figure figure;
            try {
                figure = field.getFigure(new Point(x, y));
            } catch (InvalidPointException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
            System.out.print(figure != null ? figure : " ");
            System.out.print(" ");
        }
        System.out.println();
    }

    private void printSeparator() {
        System.out.println("-----------");
    }
}
