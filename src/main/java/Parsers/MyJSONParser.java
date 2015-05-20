package Parsers;


import Entities.Word;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class MyJSONParser extends AbstractParser implements AbstractParserInterface {

    public MyJSONParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        HashMap<Word, Boolean> cities = new HashMap<>();
        try {
            FileReader reader = new FileReader(getFilePath());

            JSONParser jsonParser = new JSONParser();

            JSONObject jsonObject = (JSONObject) jsonParser.parse(reader);
            JSONArray city = (JSONArray) jsonObject.get("City");
            for (Object aLang : city) {

                Word word = new Word((String) aLang);
                cities.put(word, true);

            }
        } catch (IOException | NullPointerException | ParseException e) {


        }
        return cities;


    }
}
