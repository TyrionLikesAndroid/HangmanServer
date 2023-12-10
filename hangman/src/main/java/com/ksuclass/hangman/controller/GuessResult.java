package com.ksuclass.hangman.controller;

public class GuessResult {

    public final int gameId;
    public final String wordFormat;
    public final String usedLetters;
    public final int numMisses;
    public final String gameStatus;

    public GuessResult(int gameId, String wordFormat, String usedLetters, int numMisses, String gameStatus) {
        this.gameId = gameId;
        this.wordFormat = wordFormat;
        this.usedLetters = usedLetters;
        this.numMisses = numMisses;
        this.gameStatus = gameStatus;
    }

    public int getGameId() {
        return gameId;
    }

    public String getWordFormat() {
        return wordFormat;
    }

    public String getUsedLetters() {
        return usedLetters;
    }

    public int getNumMisses() {
        return numMisses;
    }

    public String getGameStatus() {
        return gameStatus;
    }

    @Override
    public String toString() {
        return "GuessResult{" +
                "gameId=" + gameId +
                ", wordFormat='" + wordFormat + '\'' +
                ", usedLetters='" + usedLetters + '\'' +
                ", numMisses=" + numMisses +
                ", gameStatus=" + gameStatus + '\'' +
                '}';
    }
}
