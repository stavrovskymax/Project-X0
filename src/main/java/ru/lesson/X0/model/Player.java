package ru.lesson.X0.model;

public class Player {

    private final String name;

    private final Figure figure;

    public Player(final String name, final Figure figure) {
        this.name = name;
        this.figure = figure;
    }

    public String getName() {
        return name;
    }
}
