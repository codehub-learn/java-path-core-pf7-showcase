package gr.codelearn.designpatterns.behavioral;

public class Encryptor {
	private EncryptionStrategy strategy;

	public void setStrategy(EncryptionStrategy strategy){
		this.strategy = strategy;
	}

	public String encrypt(String plainText){
		return strategy.encryptData(plainText);
	}
}
