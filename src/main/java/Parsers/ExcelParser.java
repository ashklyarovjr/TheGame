package Parsers;

import Entities.Word;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelParser extends AbstractParser implements AbstractParserInterface {

    public ExcelParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        HashMap<Word, Boolean> cities = new HashMap<>();
        InputStream in;
        HSSFWorkbook workBook;

        try {

            in = new FileInputStream(getFilePath());
            workBook = new HSSFWorkbook(in);

            Sheet sheet = workBook.getSheetAt(0);

            for (Row row : sheet) {

                for (Cell cell : row) {

                    int cellType = cell.getCellType();

                    switch (cellType) {

                        case Cell.CELL_TYPE_STRING:

                            Word word = new Word(cell.getStringCellValue());
                            cities.put(word, true);
                            break;
                    }
                }
            }
            workBook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }
}
