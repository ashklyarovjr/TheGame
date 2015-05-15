package Parsers;

import Entities.Word;
import Helpers.ConnectorDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;


public class BDParser extends AbstractParser implements AbstractParserInterface {

    private Connection connection;

    public BDParser() throws SQLException {
        setConnection(ConnectorDB.getConnection());
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        return null;
    }
}
