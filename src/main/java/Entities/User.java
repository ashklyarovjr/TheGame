package Entities;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;

public class User extends Player {


    public User(String name) {
        super(name);
    }


    @Override
    public Word makeAMove(BufferedReader reader) throws IOException {

        String inputWord ;

        System.out.println("Enter word, please.");

        inputWord = reader.readLine();

        return new Word(inputWord);
    }
}
