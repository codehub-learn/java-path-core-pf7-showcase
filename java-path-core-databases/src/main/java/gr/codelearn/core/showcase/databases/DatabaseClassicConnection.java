package gr.codelearn.core.showcase.databases;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.exit;
import static org.h2.tools.Server.startWebServer;

public class DatabaseClassicConnection {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseClassicConnection.class);
	private static final Lorem generator = LoremIpsum.getInstance();

	private static final String DB_CONNECTION_URL_FILE_MODE = "jdbc:h2:~/sample";
	private static final String DB_CONNECTION_URL_MEMORY_MODE = "jdbc:h2:mem:sample";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";

	private final Properties sqlCommands = new Properties();
	private Server server;

	public static void main(String[] args) {
		if (args.length == 0) {
			logger.debug("No arguments passed.");
		}

		DatabaseClassicConnection demo = new DatabaseClassicConnection();
		demo.loadSqlCommands();
		demo.startH2Server();
		demo.loadDatabaseDriver();

		// We need to share the connection otherwise we want be able to see memory databases. Following a different
		// scenario, we will need to utilize file mode(store db files in a specific file location.
		Connection connection = demo.getConnection();

		demo.createTable(connection);
		demo.insertData(connection);

		// Commit transaction
		demo.commitData(connection);

		demo.insertGeneratedData(connection, 20);
		demo.readData(connection);

		demo.commitData(connection);
		demo.rollbackData(connection);
		demo.readData(connection);
		demo.insertGeneratedData(connection, 30);
		demo.readData(connection);
		demo.updateData(connection);
		demo.readData(connection);
		demo.deleteData(connection);
		demo.readData(connection);

		demo.stopH2Server();
	}

	private void insertGeneratedData(Connection connection, int numberOfInserts) {

		//INSERT INTO Registration VALUES (?, ?, ?, ?);
		//INSERT INTO Registration VALUES (101, 'John', 'Smith', 18);

		try (PreparedStatement preparedStatement = connection.prepareStatement(
				sqlCommands.getProperty("insert.table.000"))) {

			int maximumIdValue = findMaximumIdValue(connection);
			batchInsert(preparedStatement, numberOfInserts, maximumIdValue);

			int[] rowsAffectedArray = preparedStatement.executeBatch();
			logger.info("Insert batch command were successful with {} row(s) affected.", Arrays.stream(
					rowsAffectedArray).summaryStatistics().getSum());

		} catch (SQLException ex) {
			logger.error("Error while inserting data.", ex);

		}
	}

	private int findMaximumIdValue(Connection connection) {
		try (Statement statement = connection.createStatement(); ResultSet resultSet = statement.executeQuery(
				sqlCommands.getProperty("select.table.002"))) {

			// isBeforeFirst returns false if the cursor is not before the first record or if there are no rows in the
			// ResultSet.
			if (resultSet.isBeforeFirst()) {
				resultSet.next();

				logger.info("---------------------------------------------------------------------");
				logger.info("Maximum id value found is {}.", resultSet.getInt(1));
				logger.info("---------------------------------------------------------------------");

				return resultSet.getInt(1);
			}

		} catch (SQLException ex) {
			logger.error("Error while reading data.", ex);
		}

		return 0;

	}

	private void batchInsert(PreparedStatement preparedStatement, int numberOfInserts, int maximumIdValue) {
		for (int i = 1; i <= numberOfInserts; i++) {
			try {
				preparedStatement.clearParameters();
				preparedStatement.setInt(1, maximumIdValue + i);
				preparedStatement.setString(2, generator.getFirstName());
				preparedStatement.setString(3, generator.getLastName());
				preparedStatement.setInt(4, ThreadLocalRandom.current().nextInt(18, 75));
				preparedStatement.addBatch();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void rollbackData(Connection connection) {
		try {
			connection.rollback();
			logger.info("Uncommitted data was rolled back from the database");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private void readData(Connection connection) {
		try (Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
															  ResultSet.CONCUR_READ_ONLY);
			 ResultSet resultSet = statement.executeQuery(sqlCommands.getProperty("select.table.001"))) {

			logger.info("---------------------------------------------------------------------");
			int rowCount = 1;
			while (resultSet.next()) {
				logger.info("{}. {}:{}, {}:{}, {}:{}, {}:{}", rowCount++, resultSet.getMetaData().getColumnName(1),
							resultSet.getString(1), resultSet.getMetaData().getColumnName(2), resultSet.getString(2),
							resultSet.getMetaData().getColumnName(3), resultSet.getString(3),
							resultSet.getMetaData().getColumnName(4), resultSet.getString(4));
			}
			logger.info("---------------------------------------------------------------------");

		} catch (SQLException ex) {
			logger.error("Error while reading data.", ex);
		}
	}

	private void commitData(Connection connection) {
		try {
			connection.commit();
			logger.info("Data was commited in the database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void insertData(Connection connection) {
		try (Statement statement = connection.createStatement()) {
			runInsertCommands(statement, sqlCommands.getProperty("insert.table.001"),
							  sqlCommands.getProperty("insert.table.002"), sqlCommands.getProperty("insert.table.003"),
							  sqlCommands.getProperty("insert.table.004"));

			connection.setAutoCommit(false);
			statement.addBatch(sqlCommands.getProperty("insert.table.005"));
			statement.addBatch(sqlCommands.getProperty("insert.table.006"));
			statement.addBatch(sqlCommands.getProperty("insert.table.007"));
			statement.addBatch(sqlCommands.getProperty("insert.table.008"));
			statement.addBatch(sqlCommands.getProperty("insert.table.009"));
			statement.addBatch(sqlCommands.getProperty("insert.table.010"));
			int[] rowsAffectedArray = statement.executeBatch();
			logger.info("Insert command was successful with {} rows updated", Arrays.stream(rowsAffectedArray)
																					.summaryStatistics().getSum());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void updateData(final Connection connection) {
		try (Statement statement = connection.createStatement()) {
			logger.info("Update command was successful with {} row(s) affected",
						statement.executeUpdate(sqlCommands.getProperty("update.table.001")));
		} catch (SQLException ex) {
			logger.error("Error while updating data.", ex);
		}
	}

	private void deleteData(final Connection connection) {
		try (Statement statement = connection.createStatement()) {
			logger.info("Delete command was successful with {} row(s) affected",
						statement.executeUpdate(sqlCommands.getProperty("delete.table.001")));
		} catch (SQLException ex) {
			logger.error("Error while deleting data.", ex);
		}
	}

	private void runInsertCommands(Statement statement, String... commands) {
		for (String command : commands) {
			try {
				statement.executeUpdate(command);
				logger.info("Execute update successful: {}", command);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	private void createTable(Connection connection) {
		// createStatement by default:
		// TYPE_FORWARD_ONLY: you can only move forward on the result set, not backward, so you get an exception when
		// you try to go back
		// CONCUR_READ_ONLY: This type of result set is not updatable. i.e. once you get a ResultSet object you cannot update its contents.
		try (Statement statement = connection.createStatement()) {
			String sqlText = sqlCommands.getProperty("create.table");
			int result = statement.executeUpdate(sqlText);
			logger.info("Created table command was successful with result {}.", result);
		} catch (SQLException ex) {
			logger.error("Error while creating table(s).", ex);
			exit(-1);
		}
	}

	private void loadSqlCommands() {
		try (InputStream is = DatabaseClassicConnection.class.getClassLoader().getResourceAsStream("sql.properties")) {
			if (is != null) {
				sqlCommands.load(is);
				logger.info("SQL commands were loaded");
			} else {
				logger.info("SQL commands were not loaded");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_CONNECTION_URL_MEMORY_MODE, DB_USERNAME, DB_PASSWORD);
			logger.info("Database connection was successful");
		} catch (SQLException e) {
			logger.info("Error while getting database connection");
			e.printStackTrace();
			System.exit(-1);
		}
		return connection;
	}

	private void loadDatabaseDriver() {
		org.h2.Driver.load();
		//		try {
		//			Class.forName("org.h2.Driver");
		//		} catch (ClassNotFoundException e) {
		//			e.printStackTrace();
		//		}
	}

	private void startH2Server() {
		try {
			server = Server.createTcpServer("-tcpAllowOthers", "-tcpDaemon");
			server.start();
			logger.info("Server H2 has started");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void stopH2Server() {
		if (server == null) {
			return;
		}
		if (server.isRunning(true)) {
			server.stop();
			server.shutdown();
			logger.info("H2 server has been shut down");
		}
	}

}
