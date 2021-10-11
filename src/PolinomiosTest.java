import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolinomiosTest {

	@Test
	void evaluarMSucesivas() {
		
		Polinomio p = new Polinomio(new double[] {8, 2, 3, 14, 4});
		
		System.out.println(p.evaluarMejorada(3));
		assertEquals(743, p.evaluarMejorada(3));
	}

}
