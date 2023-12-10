package com.ksuclass.hangman.controller;

public class FinalGuess {

    private final int gameId;
    private final String phrase;

    FinalGuess(int gameId, String phrase)
    {
        this.gameId = gameId;
        this.phrase = phrase;
    }

    public int getGameId() {
        return gameId;
    }

    public String getPhrase() {
        return phrase;
    }

    @Override
    public String toString() {
        return "FinalGuess{" +
                "gameId=" + gameId +
                ", letter='" + phrase + '\'' +
                '}';
    }
}
