package com.ksuclass.hangman.controller;

import com.ksuclass.hangman.model.GameIdNotFoundException;
import com.ksuclass.hangman.model.GamePlayManager;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class HangmanController {

    @CrossOrigin(allowedHeaders = "Content-Type")
    @PostMapping("/startGame")
    public ResponseEntity<StartResult> startGame(@RequestBody StartRequest request)
    {
        System.out.println(request);

        StartResult result = GamePlayManager.getInstance().createNewGame(request.getName());
        System.out.println(result);

        return ResponseEntity.status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @CrossOrigin(allowedHeaders = "Content-Type")
    @PostMapping("/guessLetter")
    public ResponseEntity<GuessResult> guessLetter(@RequestBody GuessRequest request)
    {
        HttpStatus outStatus = HttpStatus.OK;
        GuessResult result = null;
        System.out.println(request);

        try
        {
            result = GamePlayManager.getInstance().guessLetter(request);
            System.out.println(result);
        }
        catch (GameIdNotFoundException e)
        {
            System.out.println(e);
            outStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(outStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }

    @CrossOrigin(allowedHeaders = "Content-Type")
    @PostMapping("/guessPhrase")
    public ResponseEntity<GuessResult> guessPhrase(@RequestBody FinalGuess request)
    {
        HttpStatus outStatus = HttpStatus.OK;
        GuessResult result = null;
        System.out.println(request);

        try
        {
            result = GamePlayManager.getInstance().guessPhrase(request);
            System.out.println(result);
        }
        catch (GameIdNotFoundException e)
        {
            System.out.println(e);
            outStatus = HttpStatus.BAD_REQUEST;
        }

        return ResponseEntity.status(outStatus)
                .contentType(MediaType.APPLICATION_JSON)
                .body(result);
    }
}
