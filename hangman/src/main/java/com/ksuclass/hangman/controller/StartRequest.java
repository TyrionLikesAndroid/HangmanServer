package com.ksuclass.hangman.controller;

public class StartRequest {

    private final String name;

    StartRequest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "StartRequest{" +
                "name='" + name + '\'' +
                '}';
    }
}