package Entities;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class User extends Player {


    public User(String name) {
        super(name);
    }

    private String consoleInput() {
        String word = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            word = reader.readLine();

        } catch (IOException e) {
            System.out.println("Invalid input value, try again!");
        }

    return word;
}

    @Override
    public Word makeAMove() {
        String inputWord = consoleInput();
        return new Word(inputWord);
    }
}
