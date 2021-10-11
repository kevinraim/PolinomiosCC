
public class Polinomio {
	
	private int grado;
	private double[] coeficientes;

	// La posicion 0 del arreglo de coeficientes contiene el coeficiente de grado n
	// la posicion n contiene al termino independiente.
	
	
	public Polinomio(double [] coeficientes) {
		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}
	
	//Escribir evaluarMSucesivas utilizando cálculo de potencia por multiplicaciones sucesivas
	double evaluarMSucesivas(double x) {
		
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[grado - i] * potencia(x, i);
		}
		
		return total;
	}
	
	private double potencia(double x, int n) {
		
		double resultado = x;
		while(n>1) {
			resultado *= x;
			n--;
		}
		return resultado;
	}
	
	
	/*Escribir evaluarRecursiva utilizando el siguiente calculo de potencia recursiva:
	a) Sin considerar si el exponente es par o impar:
	potencia (x, n) = x * potencia(x, n-1)*/
	double evaluarRecursiva(double x){
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[grado - i] * potenciaRecurs(x, i);
		}
		return total;
	}
	
	private double potenciaRecurs(double x, int n) {
		if(n==1) {
			return x;
		}
		return x * potenciaRecurs(x, n-1);
	}
	
	
	double evaluarRecursivaPar(double x) {
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[grado - i] * potenciaRecursPar(x, i);
		}
		return total;
	}
	
	/*Escribir evaluarRecursiva utilizando el siguiente calculo de potencia recursiva:
	b) Considerando si el exponente es par o impar:
	Si n es par:
	potencia(x, n) = potencia(x*x, n/2)
	Si n es impar
	potencia(x, n) = x * potencia (x, n-1)*/
	private double potenciaRecursPar(double x, int n) {
		if(n==1) {
			return x;
		}
		return n % 2 == 0 ? potenciaRecursPar(x*x, n/2) : x * potenciaRecursPar(x, n-1);
	}
	
	
	double evaluarProgDinamica(double x){
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		double[] potencias = potenciaDinamica(x, grado);
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[i-1] * potencias[grado-i];
		}
		System.out.println("TT: " + total);
		return total;
	}
	
	private double[] potenciaDinamica(double x, int n) {
		double[] potencias = new double[n];
		
		potencias[0] = x;
		
		for(int i = 1; i<n; i++) {
			potencias[i] = potencias[i-1] * x;
		}
		return potencias;
	}
	
	
	double evaluarMejorada(double x) {
		double potencias = x;
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[i-1] * potencias;
			potencias *= x;
		}
		return total;
	}
	
	double evaluarPow(double x){
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[grado - i] * Math.pow(x, i);
		}

		return total;
	}
	

	double evaluarHorner(double x) {
		double total = coeficientes[0];
		
		if(grado < 1)
			return total;
		
		for(int i = 1; i<coeficientes.length; i++) {
			total = coeficientes[i] + (total*x);
		}

		return total;
	}
	
}
