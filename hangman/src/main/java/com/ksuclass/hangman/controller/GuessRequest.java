package com.ksuclass.hangman.controller;

public class GuessRequest {

    private final int gameId;
    private final String letter;

    GuessRequest(int gameId, String letter)
    {
        this.gameId = gameId;
        this.letter = letter;
    }

    public int getGameId() {
        return gameId;
    }

    public String getLetter() {
        return letter;
    }

    @Override
    public String toString() {
        return "GuessRequest{" +
                "gameId=" + gameId +
                ", letter='" + letter + '\'' +
                '}';
    }
}
