package Entities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class User extends Player {


    public User(String name) {
        super(name);
    }

    private String consoleInput() throws IOException {
        BufferedReader reader  =  new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    @Override
    Word makeAMove() throws IOException {
        String inputWord = consoleInput();
        return new Word(inputWord);
    }
}
