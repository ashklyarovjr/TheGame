package Factory;


import Exceptions.NoSuchParserException;
import Parsers.*;
import Parsers.XMLParser.XMLParser;

import java.sql.SQLException;

public abstract class AbstractParsersFactory {

    public abstract AbstractParserInterface getParser() throws NoSuchParserException, SQLException;


    BDParser getBDParser() throws SQLException {
        return new BDParser();
    }

    ExcelParser getExcelParser(String filePath){
        return new ExcelParser(filePath);
    }

    FileParser getFileParser(String filePath){
        return new FileParser(filePath);
    }

    XMLParser getXMLParser(String filePath){
        return new XMLParser(filePath);
    }

    MyJSONParser getJSONParser(String filePath) {return new MyJSONParser(filePath); }
}
