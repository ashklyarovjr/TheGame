package Parsers;

import Entities.Word;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;


public class FileParser extends AbstractParser implements AbstractParserInterface {


    public FileParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {

        HashMap<Word, Boolean> city = new HashMap<>();

        try {

            Scanner read = new Scanner(new File(getFilePath()));

            while (read.hasNextLine()) {

                city.put(new Word(read.nextLine()), true);

            }

            read.close();

        } catch (IOException e) {

            e.printStackTrace();
        }
        return city;
    }


}
