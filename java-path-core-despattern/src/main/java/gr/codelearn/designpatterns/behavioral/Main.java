package gr.codelearn.designpatterns.behavioral;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
	private static final Logger logger = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
		Encryptor encryptor = new Encryptor();

		EncryptionStrategy aesStrategy = new AESEncryptionStrategy();
		EncryptionStrategy rsaStrategy = new RSAEncryptionStrategy();

		encryptor.setStrategy(aesStrategy);
		logger.info("{}", encryptor.encrypt("This is a text"));

		encryptor.setStrategy(rsaStrategy);
		logger.info("{}", encryptor.encrypt("This is a text"));
	}
}
