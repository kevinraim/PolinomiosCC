
public class Polinomio {
	
	private int grado;
	private double[] coeficientes;
		
	public Polinomio(double [] coeficientes) {
		this.grado = coeficientes.length - 1;
		this.coeficientes = coeficientes;
	}
	
	
	public double evaluarMSucesivas(double x) {
		
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
	
	
	
	public double evaluarRecursiva(double x){
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
	
	

	public double evaluarRecursivaPar(double x) {
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[grado - i] * potenciaRecursPar(x, i);
		}
		return total;
	}
	
	private double potenciaRecursPar(double x, int n) {
		if(n==1) {
			return x;
		}
		return n % 2 == 0 ? potenciaRecursPar(x*x, n/2) : x * potenciaRecursPar(x, n-1);
	}
	
	
	
	public double evaluarProgDinamica(double x){
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		double[] potencias = potenciaDinamica(x, grado);
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[i-1] * potencias[grado-i];
		}
		
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
	
	
	
	public double evaluarMejorada(double x) {
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
	
	
	
	public double evaluarPow(double x){
		double total = coeficientes[grado];
		
		if(grado < 1)
			return total;
		
		for(int i = grado; i>0; i--) {
			total += coeficientes[grado - i] * Math.pow(x, i);
		}

		return total;
	}
	
	

	public double evaluarHorner(double x) {
		double total = coeficientes[0];
		
		if(grado < 1)
			return total;
		
		for(int i = 1; i<coeficientes.length; i++) {
			total = coeficientes[i] + (total*x);
		}
		
		return total;
	}
	
}
