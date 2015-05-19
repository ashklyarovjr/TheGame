package Factory;


import Exceptions.NoSuchParserException;
import Helpers.PathsKeeper;
import Parsers.AbstractParserInterface;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.ResourceBundle;

public class ParsersFactory extends AbstractParsersFactory {

    private static final Logger LOGGER_INFO = Logger.getLogger(ParsersFactory.class);

    private static final Logger LOGGER_ERR = Logger.getLogger(ParsersFactory.class);

    @Override
    public AbstractParserInterface getParser() throws NoSuchParserException {

        ResourceBundle resourceBundle = ResourceBundle.getBundle(PathsKeeper.propertiesFile);

        String type = resourceBundle.getString(PathsKeeper.parserChoice);

        switch (type) {
            case "xml":

                LOGGER_INFO.info("XML Parser returned");
                return getXMLParser(resourceBundle.getString(PathsKeeper.xmlSource));

            case "xls":

                LOGGER_INFO.info("Excel Parser returned");
                return getExcelParser(resourceBundle.getString(PathsKeeper.xlsSource));

            case "json":

                LOGGER_INFO.info("JSON Parser returned");
                return getJSONParser(resourceBundle.getString(PathsKeeper.jsonSource));

            case "txt":

                LOGGER_INFO.info("File Parser returned");
                return getFileParser(resourceBundle.getString(PathsKeeper.txtSource));

            case "db":

                LOGGER_INFO.info("BD Parser returned");
                return getBDParser();

            default:

                LOGGER_ERR.error("Factory: Parser not found!");
                throw new NoSuchParserException("You can't use such file as a cities source!!");
        }
    }
}
