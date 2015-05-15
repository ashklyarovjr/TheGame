package Factory;


import Parsers.BDParser;
import Parsers.ExcelParser;
import Parsers.FileParser;
import Parsers.XMLParser.XMLParser;

public class ParsersFactory implements AbstractParsersFactory {

    @Override
    public BDParser getBDParser() {
        return null;
    }

    @Override
    public ExcelParser getExcelParser() {
        return null;
    }

    @Override
    public FileParser getFileParser() {
        return null;
    }

    @Override
    public XMLParser getXMLParser() {
        return null;
    }
}
