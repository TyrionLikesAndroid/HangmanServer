package com.ksuclass.hangman.controller;

public class StartResult {

    private final int gameId;
    private final String wordFormat;
    private final String topic;

    public StartResult(int gameId, String wordFormat, String topic)
    {
        this.gameId = gameId;
        this.wordFormat = wordFormat;
        this.topic = topic;
    }

    public int getGameId() {
        return gameId;
    }

    public String getWordFormat() {
        return wordFormat;
    }

    public String getTopic() {
        return topic;
    }

    @Override
    public String toString() {
        return "StartResult{" +
                "gameId=" + gameId +
                ", wordFormat='" + wordFormat + '\'' +
                ", topic='" + topic + '\'' +
                '}';
    }
}
