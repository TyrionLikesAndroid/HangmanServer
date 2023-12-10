package com.ksuclass.hangman.model;

public class HangmanPhrase {

    private final String topic;
    private final String targetPhrase;

    public HangmanPhrase(String topic, String targetPhrase) {
        this.topic = topic;
        this.targetPhrase = targetPhrase;
    }

    public String getTopic() {
        return topic;
    }

    public String getTargetPhrase() {
        return targetPhrase;
    }
}
