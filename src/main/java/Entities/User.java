package Entities;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class User extends Player {

    private static final Logger LOGGER_ERR = Logger.getLogger(User.class);

    public User(String name) {
        super(name);
    }


    @Override
    public Word makeAMove(BufferedReader reader)  {

        String inputWord;

        System.out.println("Enter word, please.");

        try {
            inputWord = reader.readLine();

            if (!inputWord.isEmpty()) {
                return new Word(inputWord);
            }
            else
                throw new IOException();

        } catch (IOException  e) {

            System.out.println("Incorrect value, please try again!");
            LOGGER_ERR.warn("Incorrect value, please try again!");

            makeAMove(reader);
        }
        return null;
    }
}
