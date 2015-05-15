package Factory;


import Parsers.BDParser;
import Parsers.ExcelParser;
import Parsers.FileParser;
import Parsers.XMLParser.XMLParser;

public interface AbstractParsersFactory {
    BDParser getBDParser();

    ExcelParser getExcelParser();

    FileParser getFileParser();

    XMLParser getXMLParser();
}
