package gr.codelearn.designpatterns.behavioral;

public class AESEncryptionStrategy implements EncryptionStrategy {
	@Override
	public String encryptData(String text) {
		return text.hashCode() + " " + "AES".hashCode()  ;
	}
}
