package com.ksuclass.hangman.model;

import com.ksuclass.hangman.controller.FinalGuess;
import com.ksuclass.hangman.controller.GuessRequest;
import com.ksuclass.hangman.controller.GuessResult;
import com.ksuclass.hangman.controller.StartResult;

import java.util.HashMap;

public class GamePlayManager {

    private static GamePlayManager instance;
    private HashMap<Integer, HangmanGame> activeGames;
    private int nextGameId = 1;

    public static GamePlayManager getInstance()
    {
        if(instance == null)
            instance = new GamePlayManager();

        return instance;
    }

    public GamePlayManager()
    {
        activeGames = new HashMap<Integer, HangmanGame>();
    }

    public StartResult createNewGame(String playerName)
    {
        HangmanGame newGame = new HangmanGame(playerName, nextGameId);
        nextGameId++;
        activeGames.put(newGame.getGameId(), newGame);

        return newGame.start();
    }

    public GuessResult guessLetter(GuessRequest request) throws GameIdNotFoundException
    {
        HangmanGame game = activeGames.get(request.getGameId());

        if(game == null)
            throw new GameIdNotFoundException("Game Id Missing: " + request.getGameId());

        return game.guessLetter(request);
    }

    public GuessResult guessPhrase(FinalGuess request) throws GameIdNotFoundException
    {
        HangmanGame game = activeGames.get(request.getGameId());

        if(game == null)
            throw new GameIdNotFoundException("Game Id Missing: " + request.getGameId());

        return game.guessPhrase(request);
    }
}
