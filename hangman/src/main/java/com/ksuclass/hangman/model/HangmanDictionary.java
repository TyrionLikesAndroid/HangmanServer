package com.ksuclass.hangman.model;

import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;

public class HangmanDictionary {

    private static HangmanDictionary instance;
    private final Vector<HangmanPhrase> phrases;

    public static HangmanDictionary getInstance()
    {
        if(instance == null)
            instance = new HangmanDictionary();

        return instance;
    }

    public HangmanDictionary()
    {
        phrases = new Vector<>();

        // Initialize by hand for now, later we can drive with a file
        // if we need expand this list to something bigger
        phrases.add(new HangmanPhrase("SONG", "SWEET HOME ALABAMA"));
        phrases.add(new HangmanPhrase("SONG", "Gimme Shelter"));
        phrases.add(new HangmanPhrase("SONG", "Smells Like Teen Spirit"));
        phrases.add(new HangmanPhrase("SONG", "Bohemian Rhapsody"));
        phrases.add(new HangmanPhrase("SONG", "Hotel California"));
        phrases.add(new HangmanPhrase("SONG", "Another Brick in the Wall"));
        phrases.add(new HangmanPhrase("SONG", "Smoke on the Water"));
        phrases.add(new HangmanPhrase("SONG", "Stairway to heaven"));
        phrases.add(new HangmanPhrase("SONG", "Billie Jean"));
        phrases.add(new HangmanPhrase("INDIAN SONG", "Awaara Hoon"));
        phrases.add(new HangmanPhrase("INDIAN SONG", "I am a Disco Dancer"));
        phrases.add(new HangmanPhrase("INDIAN SONG", "Jimmy Jimmy Aaja Aaja"));
        phrases.add(new HangmanPhrase("INDIAN SONG", "Mera Joota Hai Japaani"));
        phrases.add(new HangmanPhrase("MOVIE", "Avatar"));
        phrases.add(new HangmanPhrase("MOVIE", "The Lion King"));
        phrases.add(new HangmanPhrase("MOVIE", "The Jazz Singer"));
        phrases.add(new HangmanPhrase("MOVIE", "The Avengers"));
        phrases.add(new HangmanPhrase("MOVIE", "Black Panther"));
        phrases.add(new HangmanPhrase("MOVIE", "Beauty and the Beast"));
        phrases.add(new HangmanPhrase("MOVIE", "The Dark Knight Rises"));
        phrases.add(new HangmanPhrase("MOVIE", "Harry Potter and the Sorcerers Stone"));
        phrases.add(new HangmanPhrase("MOVIE", "Doctor Strange in the Multiverse of Madness"));
        phrases.add(new HangmanPhrase("MOVIE", "Oppenheimer"));
        phrases.add(new HangmanPhrase("MOVIE", "Finding Nemo"));
        phrases.add(new HangmanPhrase("MOVIE", "Harry Potter and the Order of the Phoenix"));
        phrases.add(new HangmanPhrase("MOVIE", "Independence Day"));
        phrases.add(new HangmanPhrase("MOVIE", "Slumdog Millionaire"));
        phrases.add(new HangmanPhrase("MOVIE", "The Kite Runner"));
        phrases.add(new HangmanPhrase("MOVIE", "Gone with the Wind"));
        phrases.add(new HangmanPhrase("MOVIE", "The Hunger Games"));
        phrases.add(new HangmanPhrase("MOVIE", "The Godfather"));
        phrases.add(new HangmanPhrase("MOVIE", "Pride and Prejudice"));
        phrases.add(new HangmanPhrase("BOOK", "A Tale of Two Cities"));
        phrases.add(new HangmanPhrase("BOOK", "The Little Prince"));
        phrases.add(new HangmanPhrase("BOOK", "A Tale of Two Cities"));
        phrases.add(new HangmanPhrase("BOOK", "And Then There Were None"));
        phrases.add(new HangmanPhrase("BOOK", "The Hobbit"));
        phrases.add(new HangmanPhrase("BOOK", "The Da Vinci Code"));
        phrases.add(new HangmanPhrase("BOOK", "Harry Potter and the Goblet of Fire"));
        phrases.add(new HangmanPhrase("BOOK", "The Alchemist"));
        phrases.add(new HangmanPhrase("BOOK", "One Hundred Years of Solitude"));
        phrases.add(new HangmanPhrase("US STATES", "South Carolina"));
        phrases.add(new HangmanPhrase("US STATES", "North Dakota"));
        phrases.add(new HangmanPhrase("US STATES", "Washington"));
        phrases.add(new HangmanPhrase("US STATES", "Mississippi"));
        phrases.add(new HangmanPhrase("US STATES", "Oregon"));
        phrases.add(new HangmanPhrase("US STATES", "Ohio"));
        phrases.add(new HangmanPhrase("US STATES", "New Hampshire"));
        phrases.add(new HangmanPhrase("US STATES", "Florida"));
        phrases.add(new HangmanPhrase("US STATES", "New Mexico"));
        phrases.add(new HangmanPhrase("US STATES", "California"));
        phrases.add(new HangmanPhrase("US STATES", "Kansas"));
        phrases.add(new HangmanPhrase("US STATES", "Maine"));
        phrases.add(new HangmanPhrase("US STATES", "Nebraska"));
        phrases.add(new HangmanPhrase("US STATES", "Nevada"));
    }

    public HangmanPhrase getNextPhrase()
    {
        int random = new Random().nextInt(phrases.size());
        return phrases.get(random);
    }
}
