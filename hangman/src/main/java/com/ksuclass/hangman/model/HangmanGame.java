package com.ksuclass.hangman.model;

import com.ksuclass.hangman.controller.FinalGuess;
import com.ksuclass.hangman.controller.GuessRequest;
import com.ksuclass.hangman.controller.GuessResult;
import com.ksuclass.hangman.controller.StartResult;
import java.util.LinkedList;

public class HangmanGame {

    static final int MAX_MISSES = 6;
    static final String IN_PROGRESS = "IN_PROGRESS";
    static final String GAME_OVER_WINNER = "OVER_WINNER";
    static final String GAME_OVER_LOSER = "OVER_LOSER";
    private final String playerName;
    private final int gameId;
    private String targetPhrase;
    private String previousLetters = "";
    private int incorrectGuesses = 0;
    private String gameStatus = IN_PROGRESS;

    public HangmanGame(String playerName, int gameId) {
        this.playerName = playerName;
        this.gameId = gameId;
    }

    public int getGameId() {
        return gameId;
    }

    public StartResult start()
    {
        HangmanPhrase nextPhrase = HangmanDictionary.getInstance().getNextPhrase();
        targetPhrase = nextPhrase.getTargetPhrase().toUpperCase();
        return (new StartResult(gameId, obfuscatePhrase(), nextPhrase.getTopic()));
    }

    public GuessResult guessLetter(GuessRequest request)
    {
        String outputPhrase = null;

        if(gameStatus.equals(IN_PROGRESS)) {

            // Get the letter that has been guessed
            String guessLetter = request.getLetter().toUpperCase();
            outputPhrase = obfuscatePhrase();

            // See if we have guessed it already.  Be nice if they duplicate,
            // only run the game process if it is a letter we haven't seen already
            if (!previousLetters.contains(guessLetter)) {

                // Add the new letter to the guess list and prepare the obfuscated
                // response phrase
                previousLetters = previousLetters.concat(guessLetter);
                outputPhrase = obfuscatePhrase();

                // See if the new letter was a good one and test for game over
                // conditions
                if (targetPhrase.contains(guessLetter)) {

                    // If the obfuscated phase and target are the same, the game
                    // is over and they have figured it out
                    if (outputPhrase.equals(targetPhrase)) {
                        System.out.println("Game is over - player wins");
                        gameStatus = GAME_OVER_WINNER;
                    }
                } else {

                    // Increment the misses and see if they have exceeded the maximum
                    // number of missed.  If so, the game is over and they have lost.
                    incorrectGuesses++;
                    if (incorrectGuesses >= MAX_MISSES) {
                        System.out.println("Game is over = maximum guesses exceeded");
                        gameStatus = GAME_OVER_LOSER;
                        outputPhrase = targetPhrase;
                    }
                }
            }
        } else {

            // If the game is over, just return the target phrase
            outputPhrase = targetPhrase;
        }

        return new GuessResult(request.getGameId(), outputPhrase,
                previousLetters, incorrectGuesses, gameStatus);
    }

    private String obfuscatePhrase()
    {
        String obfuscated = new String();
        char[] targetArray = targetPhrase.toCharArray();

        for (char c : targetArray)
        {
            // Allow for spaces between words in the target phrase
            if (c == 32)
                obfuscated = obfuscated.concat(" ");
            else
            {
                // If they have successfully guessed one of the letters,
                // display it.  If not, put an underscore for the blank.
                if (previousLetters.indexOf((int) c) != -1)
                    obfuscated = obfuscated.concat(String.valueOf(c));
                else
                    obfuscated = obfuscated.concat("_");
            }

            //System.out.println(c);
        }

        return obfuscated;
    }

    public GuessResult guessPhrase(FinalGuess request)
    {
        // Allow a final guess if the game is in progress.  This is a quick way to
        // end the game if the player knows the answer, but they only have one chance
        // to spell it perfectly
        if(gameStatus.equals(IN_PROGRESS))
        {
            if (request.getPhrase().toUpperCase().equals(targetPhrase))
            {
                System.out.println("Game is over - correct guess");
                gameStatus = GAME_OVER_WINNER;
            }
            else
            {
                System.out.println("Game is over - bad guess");
                gameStatus = GAME_OVER_LOSER;
            }
        }

        return new GuessResult(request.getGameId(), targetPhrase,
                previousLetters, incorrectGuesses, gameStatus);
    }
}
