import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class Main {

	public static void main(String[] args) {
		Polinomio p0 = new Polinomio(new double[] {3}); //Polinomio grado 0
		Polinomio p4 = new Polinomio(new double[] {8.32, 2.21, 3, 14.5, 4.44}); //Polinomio grado 4
		Polinomio p8 = new Polinomio(new double[] {7.2, 4.55, 3.2, 9.7, 4.12, 6.65, 7.44, 3.24, 0}); //Polinomio grado 8
		
		String[] evaluadoresEnOrden = new String[7];
		evaluadoresEnOrden[0] = "Evaluar sucesivas: ";
		evaluadoresEnOrden[1] = "Evaluar recursiva: ";
		evaluadoresEnOrden[2] = "Evaluar recursiva par: ";
		evaluadoresEnOrden[3] = "Evaluar programacion dinamica: ";
		evaluadoresEnOrden[4] = "Evaluar mejorada: ";
		evaluadoresEnOrden[5] = "Evaluar Math.pow: ";
		evaluadoresEnOrden[6] = "Evaluar horner: ";
		
		long[] tiempos = new TiemposDeEjecucion(p8, 4).calcularTiemposDeEjecucion();
		
		try {
			FileOutputStream fos =  new FileOutputStream("TiemposDeEjecucion.csv", true);
			PrintWriter pw = new PrintWriter(fos);
			
			pw.println("Polinomio grado 0, X = 0");
			cargarTiemposDeEjecucionCSV(pw, evaluadoresEnOrden, tiempos);
			pw.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	static void cargarTiemposDeEjecucionCSV(PrintWriter pw, String[] evaluadores, long[] tiempos) {
		for(int i = 0; i<tiempos.length; i++) {
			pw.println(evaluadores[i] + "," + tiempos[i]);
		}
	}

}
