package gr.codelearn.core.showcase.provider;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MathOperationsProviderTest {

	@Test
	void testAdd() {
		Assertions.assertEquals(3, MathOperationsProvider.add(2, 1));
	}

}
