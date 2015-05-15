package Factory;


import Exceptions.NoSuchParserException;
import Helpers.PathsKeeper;
import Parsers.AbstractParserInterface;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class ParsersFactory extends AbstractParsersFactory {

    @Override
    public AbstractParserInterface getParser() throws NoSuchParserException, SQLException {
        ResourceBundle resourceBundle = ResourceBundle.getBundle(PathsKeeper.propertiesFile);
        String type = resourceBundle.getString(PathsKeeper.parserChoice);
        switch (type) {
            case "xml":
                return getXMLParser(resourceBundle.getString(PathsKeeper.xmlSource));
            case "xls":
                return getExcelParser(resourceBundle.getString(PathsKeeper.xlsSource));
            case "json":
                return getJSONParser(resourceBundle.getString(PathsKeeper.jsonSource));
            case "txt":
                return getFileParser(resourceBundle.getString(PathsKeeper.txtSource));
            case "db":
                return getBDParser();
            default:
                throw new NoSuchParserException("You can't use such file as a cities source!!");
        }
    }
}
