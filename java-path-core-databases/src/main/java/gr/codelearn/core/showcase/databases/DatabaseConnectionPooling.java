package gr.codelearn.core.showcase.databases;
import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.h2.message.DbException;
import org.h2.tools.Server;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;

import static java.lang.System.exit;

public class DatabaseConnectionPooling {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseConnectionPooling.class);
	private static final Lorem generator = LoremIpsum.getInstance();

	private static final String DB_CONNECTION_URL_FILE_MODE = "jdbc:h2:~/sample";
	private static final String DB_CONNECTION_URL_MEMORY_MODE = "jdbc:h2:mem:sample";
	private static final String DB_USERNAME = "sa";
	private static final String DB_PASSWORD = "";
	private final Properties sqlCommands = new Properties();
	private Server server;
	private HikariDataSource hikariDataSource;

	public static void main(String[] args) {
		if (args.length == 0) {
			logger.debug("No arguments passed.");
		}

		DatabaseConnectionPooling demo = new DatabaseConnectionPooling();

		demo.loadSqlCommands();
		demo.startH2Server();
		demo.loadDatabaseDriver();

		// Initializing Connection Pooling mechanism
		demo.initializeHikariConnectionPooling();

		demo.createTable();
		demo.insertData();
		demo.insertGeneratedData(20);
		demo.readData();
		demo.insertGeneratedData(30);
		demo.readData();
		demo.updateData();
		demo.readData();
		demo.deleteData();
		demo.readData();

		demo.stopH2Server();
	}

	private void loadSqlCommands() {
		try (InputStream inputStream = DatabaseConnectionPooling.class.getClassLoader().getResourceAsStream(
				"sql.properties")) {
			if (inputStream == null) {
				logger.error("Sorry, unable to find sql.properties, exiting application.");
				// Abnormal exit
				exit(-1);
			}

			//load a properties file from class path, inside static method
			sqlCommands.load(inputStream);
		} catch (IOException ex) {
			logger.error("Sorry, unable to parse sql.properties, exiting application.", ex);
			// Abnormal exit
			exit(-1);
		}
	}

	private void createTable() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			int result = statement.executeUpdate(sqlCommands.getProperty("create.table"));
			logger.info("Created table command was successful with result {}.", result);
		} catch (SQLException ex) {
			logger.error("Error while creating table(s).", ex);
			exit(-1);
		}
	}

	private void insertData() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			// Classic insert statements
			//@formatter:off
			runInsertCommands(statement,
							  sqlCommands.getProperty("insert.table.001"),
							  sqlCommands.getProperty("insert.table.002"),
							  sqlCommands.getProperty("insert.table.003"),
							  sqlCommands.getProperty("insert.table.004"));
			//@formatter:on

			// Insert data in batch mode
			statement.addBatch(sqlCommands.getProperty("insert.table.005"));
			statement.addBatch(sqlCommands.getProperty("insert.table.006"));
			statement.addBatch(sqlCommands.getProperty("insert.table.007"));
			statement.addBatch(sqlCommands.getProperty("insert.table.008"));
			statement.addBatch(sqlCommands.getProperty("insert.table.009"));
			statement.addBatch(sqlCommands.getProperty("insert.table.010"));

			int[] rowsAffectedArray = statement.executeBatch();
			logger.info("Insert commands were successful with {} row(s) affected.", Arrays.stream(rowsAffectedArray)
																						  .summaryStatistics()
																						  .getSum());
		} catch (SQLException ex) {
			logger.error("Error while inserting data.", ex);
		}
	}

	private void runInsertCommands(Statement statement, String... commands) throws SQLException {
		for (String command : commands) {
			logger.info("Insert command was successful with {} row(s) affected.", statement.executeUpdate(command));
		}
	}

	private void insertGeneratedData(int howManyStatements) {
		try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(
				sqlCommands.getProperty("insert.table.000"))) {

			batchInsert(preparedStatement, howManyStatements);

			int[] rowsAffectedArray = preparedStatement.executeBatch();
			logger.info("Insert batch command were successful with {} row(s) affected.", Arrays.stream(
					rowsAffectedArray).summaryStatistics().getSum());

		} catch (SQLException ex) {
			logger.error("Error while inserting data.", ex);
		}
	}

	private void batchInsert(PreparedStatement preparedStatement, int howManyStatements) throws SQLException {
		int maximumIdValue = findMaximumIdValue();

		for (int i = 1; i <= howManyStatements; i++) {
			// Clear parameters from the statement so it can be reused
			preparedStatement.clearParameters();

			preparedStatement.setInt(1, maximumIdValue + i);
			preparedStatement.setString(2, generator.getFirstName());
			preparedStatement.setString(3, generator.getLastName());
			preparedStatement.setInt(4, ThreadLocalRandom.current().nextInt(18, 70));

			// Add command to batch
			preparedStatement.addBatch();
		}
	}

	private void updateData() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			int rowsAffected = statement.executeUpdate("UPDATE Registration SET age = age + 10 WHERE id > 130");

			logger.info("Update command was successful with {} row(s) affected.", rowsAffected);
		} catch (SQLException ex) {
			logger.error("Error while updating data.", ex);
		}
	}

	private void deleteData() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement()) {
			int rowsAffected = statement.executeUpdate("DELETE FROM Registration WHERE id > 120");

			logger.info("Delete command was successful with {} row(s) affected.", rowsAffected);
		} catch (SQLException ex) {
			logger.error("Error while updating data.", ex);
		}
	}

	private void readData() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			 ResultSet resultSet = statement.executeQuery(sqlCommands.getProperty("select.table.001"))) {

			logger.info("---------------------------------------------------------------------");
			//@formatter:off
			int rowCount =1;
			while (resultSet.next()) {
				logger.info("{}. {}:{}, {}:{}, {}:{}, {}:{}", rowCount++,
							resultSet.getMetaData().getColumnName(1), resultSet.getString(1),
							resultSet.getMetaData().getColumnName(2), resultSet.getString(2),
							resultSet.getMetaData().getColumnName(3), resultSet.getString(3),
							resultSet.getMetaData().getColumnName(4), resultSet.getString(4));
			}
			//@formatter:on
			logger.info("---------------------------------------------------------------------");

		} catch (SQLException ex) {
			logger.error("Error while reading data.", ex);
		}
	}

	private int findMaximumIdValue() {
		try (Connection connection = getConnection(); Statement statement = connection.createStatement();
			 ResultSet resultSet = statement.executeQuery(sqlCommands.getProperty("select.table.002"))) {

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

	private void initializeHikariConnectionPooling() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl(DB_CONNECTION_URL_MEMORY_MODE);
		config.setUsername(DB_USERNAME);
		config.setPassword(DB_PASSWORD);

		// This property controls the maximum size that the pool is allowed to reach, including both idle and in-use
		// connections.
		// Defaults to 10.
		config.setMaximumPoolSize(10);

		// This property controls the minimum number of idle connections that HikariCP tries to maintain in the pool.
		// Defaults to maximumPoolSize value.
		config.setMinimumIdle(3);

		// This property controls the maximum number of milliseconds that a client (that's you) will wait for a
		// connection from the pool.
		// Defaults to 30000ms (30secs).
		config.setConnectionTimeout(10000);

		// This property controls the maximum amount of time that a connection is allowed to sit idle in the pool.
		// This setting only applies when minimumIdle is defined to be less than maximumPoolSize.
		// Defaults to 600000ms (10mins).
		config.setIdleTimeout(60000);

		// This property controls the maximum lifetime of a connection in the pool. An in-use connection will never be
		// retired, only when it is closed will it then be removed.
		// Defaults to 1800000ms (30mins).
		config.setMaxLifetime(1800000);

		// This property controls the default auto-commit behavior of connections returned from the pool.
		// Defaults to true.
		config.setAutoCommit(true);

		config.addDataSourceProperty("cachePrepStmts", "true");
		config.addDataSourceProperty("prepStmtCacheSize", "250");
		config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
		config.addDataSourceProperty("useServerPrepStmts", "true");

		hikariDataSource = new HikariDataSource(config);
	}

	private Connection getConnection() throws SQLException {
		return hikariDataSource.getConnection();
	}

	private void startH2Server() {
		try {
			server = Server.createTcpServer("-tcpAllowOthers", "-tcpDaemon");
			server.start();
		} catch (SQLException e) {
			//
			logger.error("Error while starting H2 server.", DbException.convert(e));
			exit(-1);
		}
		logger.info("H2 server has started with status '{}'.", server.getStatus());
	}

	private void stopH2Server() {
		if (server == null) {
			return;
		}
		if (server.isRunning(true)) {
			server.stop();
			server.shutdown();
			logger.info("H2 server has been shutdown.");
		}
		server = null;
	}

	private void loadDatabaseDriver() {
		org.h2.Driver.load();

		// Traditional way of loading database driver
		// H2 driver from http://www.h2database.com
		/*
		try {
			Class.forName("org.h2.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		*/
		logger.info("H2 JDBC driver server has been successfully loaded.");
	}
}
