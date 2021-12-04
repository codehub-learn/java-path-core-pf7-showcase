package gr.codelearn.core.showcase.databases;

import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class DataBaseSimple {
    private static final Logger logger = LoggerFactory.getLogger(DataBaseSimple.class);


    private static final String DB_CONNECTION_URL_MEMORY_MODE = "jdbc:h2:mem:sample";
    private static final String DB_USERNAME = "sa";
    private static final String DB_PASSWORD = "";

    private static Server server;

    public static void main(String[] args) throws Exception {

        server = Server.createTcpServer("-tcpAllowOthers", "-tcpDaemon");
        server.start();
        logger.info("H2 server has started with status '{}'.", server.getStatus());

        org.h2.Driver.load();
        logger.info("H2 JDBC driver server has been successfully loaded.");

        Connection connection = DriverManager.getConnection(DB_CONNECTION_URL_MEMORY_MODE, DB_USERNAME, DB_PASSWORD);
        Statement statement = connection.createStatement();

        int result = statement.executeUpdate("CREATE TABLE IF NOT EXISTS Registration (" +
                " id INTEGER not NULL PRIMARY KEY, " +
                " first VARCHAR(20), " +
                " last VARCHAR(50), " +
                " age INTEGER " +
                ");"
        );
        logger.info("Created table command was successful with result {}.", result);

        int rowsAffected = statement.executeUpdate("INSERT INTO Registration VALUES (101, 'John', 'Smith', 18)");
        logger.info("Update command was successful with {} row(s) affected.", rowsAffected);

        ResultSet resultSet = statement.executeQuery("SELECT * FROM Registration");

        while (resultSet.next()) {
            logger.info("ID: {}, First Name:{}, Last Name:{}, Age: {}",
                    resultSet.getString("id"),
                    resultSet.getString("first"),
                    resultSet.getString("last"),
                    resultSet.getString("age"));
        }


        server.stop();
        server.shutdown();
        logger.info("H2 server has been shutdown.");
    }


}
