package Parsers;

import Entities.Word;
import Helpers.ConnectorDB;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;


public class BDParser extends AbstractParser implements AbstractParserInterface {

    private static final Logger LOGGER_INFO = Logger.getLogger(BDParser.class);

    private static final Logger LOGGER_ERR = Logger.getLogger(BDParser.class);

    private Connection connection;

    public BDParser() throws SQLException {

        setConnection(ConnectorDB.getConnection());
        LOGGER_INFO.info("BD: Connection established");
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    public static final String SQL_SELECT_ALL_CITIES = "SELECT `city_name_en` FROM `cities`";

    @Override
    public HashMap<Word, Boolean> parse() {
        HashMap<Word, Boolean> cities = new HashMap<>();
        Statement st;
        try {

            st = getConnection().createStatement();
            LOGGER_INFO.info("BD: Statement created");

            ResultSet rs = st.executeQuery(SQL_SELECT_ALL_CITIES);
            while (rs.next()) {

                Word word = new Word(rs.getString(1));
                cities.put(word, true);

            }

        } catch (SQLException e) {
            LOGGER_ERR.error("SQL Exception: " + e);
            e.printStackTrace();
        }

        return cities;
    }
}
