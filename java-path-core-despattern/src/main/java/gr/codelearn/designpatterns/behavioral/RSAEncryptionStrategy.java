package gr.codelearn.designpatterns.behavioral;

public class RSAEncryptionStrategy implements EncryptionStrategy {
	@Override
	public String encryptData(String text) {
		return text.hashCode() + " " + "RSA".hashCode()  ;
	}
}
