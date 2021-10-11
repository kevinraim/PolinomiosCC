
public class TiemposDeEjecucion {
	
	private Polinomio p;
	private double x;
	private long tInicio;
	
	public TiemposDeEjecucion(Polinomio p, double x) {
		super();
		this.p = p;
		this.x = x;
	}
	
	public long[] calcularTiemposDeEjecucion() {
		long[] tiempos = new long[7];
		
		tiempos[0] = calcularSucesivas();
		tiempos[1] = calcularRecursiva();
		tiempos[2] = calcularRecursivaPar();
		tiempos[3] = calcularDinamica();
		tiempos[4] = calcularMejorada();
		tiempos[5] = calcularPow();
		tiempos[6] = calcularHorner();
		
		return tiempos;
	}
	
	private long calcularSucesivas() {
		tInicio = System.nanoTime();
		p.evaluarMSucesivas(x);
		return System.nanoTime() - tInicio;
	}
	
	private long calcularRecursiva() {
		tInicio = System.nanoTime();
		p.evaluarRecursiva(x);
		return System.nanoTime() - tInicio;
	}
	
	private long calcularRecursivaPar() {
		tInicio = System.nanoTime();
		p.evaluarRecursivaPar(x);
		return System.nanoTime() - tInicio;
	}
	
	private long calcularDinamica() {
		tInicio = System.nanoTime();
		p.evaluarProgDinamica(x);
		return System.nanoTime() - tInicio;
	}
	
	private long calcularMejorada() {
		tInicio = System.nanoTime();
		p.evaluarMejorada(x);
		return System.nanoTime() - tInicio;
	}
	
	private long calcularPow() {
		tInicio = System.nanoTime();
		p.evaluarPow(x);
		return System.nanoTime() - tInicio;
	}
	
	private long calcularHorner() {
		tInicio = System.nanoTime();
		p.evaluarHorner(x);
		return System.nanoTime() - tInicio;
	}
	
}
