package gr.codelearn.core.showcase.exception;

import gr.codelearn.core.showcase.exception.domain.Directory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BuiltInCheckedExceptionTester {

	private static final Logger logger = LoggerFactory.getLogger(BuiltInCheckedExceptionTester.class);

	public static void main(String[] args) {
		init();
		//loadClassInformation();
		//connectToDatabase();
		String filename = "test.txt";
		writeBytesToFileTryWithResources(filename);
		readBytesFromFileTryWithResources(filename);
	}

	public static void loadClassInformation() {
		try {
			Class.forName("gr.codelearn.core.showcase.exception.MyClass");
		} catch (ClassNotFoundException e) {
			logger.info("Exception thrown with message: {}", e.getMessage());
		}
	}

	public static void connectToDatabase() {
		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB");
			Statement statement = connection.createStatement();
			statement.executeQuery("SELECT * FROM students");
			connection.close();
		} catch (SQLException e) {
			logger.info("Exception thrown with message: {}", e.getMessage());
		}
	}

	public static void connectToDatabaseTryWithResources() {
		try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myDB");
			 Statement statement = connection.createStatement()){
			statement.executeQuery("SELECT * FROM students");
		} catch (SQLException e) {
			logger.info("Exception thrown with message: {}", e.getMessage());
		}
	}

	public static void writeBytesToFileTryCatchFinally() {
		// not recommended
		FileOutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("C:/Users/mcjohn1/data_files/test.txt");
			outputStream.write(80);
		} catch (IOException e) {
			logger.info("Exception thrown with message: {}", e.getMessage());
		} finally {
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeBytesToFileTryWithResources(String filename) {
		try (FileOutputStream outputStream = new FileOutputStream(Directory.FILE_DIRECTORY.getPath() + filename)) {
			outputStream.write(80);
			outputStream.write(75);
			outputStream.write(90);
			outputStream.write(56);
			outputStream.write(67);
		} catch (IOException e) {
			logger.info("Exception thrown with message: '{}'", e.getMessage());
		}
	}

	public static void readBytesFromFileTryWithResources(String filename){
		try(FileInputStream inputStream = new FileInputStream(Directory.FILE_DIRECTORY.getPath() + filename)){
			int next;
			while ((next = inputStream.read()) != -1){
				logger.info("The byte you read is the following: '{}'", (char) next);
			}
		} catch (IOException e) {
			logger.info("Exception thrown with message: '{}'", e.getMessage());
		}
	}

	public static void init(){
		File fileDirectory = new File(Directory.FILE_DIRECTORY.getPath());
		if (!fileDirectory.exists()){
			logger.info("File Directory does not exist, so it needs to be created.");
			fileDirectory.mkdir();
			return;
		}
		logger.info("File Directory exists, so it does not need to be created.");
	}
}
