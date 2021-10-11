import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PolinomiosTest {
	
	@Test
	void testPolinomioGrado0() {
		
		Polinomio p = new Polinomio(new double[] {3});
		double x = 0;
		double resultado = 3;
		
		testResultado(p, x, resultado);
		
		x = 4.22;
		testResultado(p, x, resultado);
		
		x = 13;
		testResultado(p, x, resultado);
		
		
	}
	
	@Test
	void testPolinomioGrado4() {
		
		Polinomio p = new Polinomio(new double[] {8.32, 2.21, 3, 14.5, 4.44});
		double x = 0;
		double resultado = 4.44;
		
		testResultado(p, x, resultado);
		
		x = 4.22;
		resultado = 2923.737299;
		testResultado(p, x, resultado);
		
		x = 13;
		resultado = 243182.83;
		testResultado(p, x, resultado);
	}
	
	@Test
	void testPolinomioGrado8() {
		Polinomio p = new Polinomio(new double[] {0.16, -1.8, -6, 12.7, 9.12, 0, 7.44, 3.24, 0});
		double x = 0;
		double resultado = 0;
		
		testResultado(p, x, resultado);
		
		x = 4.22;
		resultado = -40659.090948;
		testResultado(p,x,resultado);
		
		x = 13;
		resultado = -6414072.34;
		testResultado(p,x,resultado);
	}
	
	void testResultado(Polinomio p, double x, double resultado) {
		assertEquals(resultado, p.evaluarMSucesivas(x), 0.000001);
		assertEquals(resultado, p.evaluarRecursiva(x), 0.000001);
		assertEquals(resultado, p.evaluarRecursivaPar(x), 0.000001);
		assertEquals(resultado, p.evaluarProgDinamica(x), 0.000001);
		assertEquals(resultado, p.evaluarMejorada(x), 0.000001);
		assertEquals(resultado, p.evaluarPow(x), 0.000001);
		assertEquals(resultado, p.evaluarHorner(x), 0.000001);
	}

}
