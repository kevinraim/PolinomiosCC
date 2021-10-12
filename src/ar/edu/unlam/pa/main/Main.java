package ar.edu.unlam.pa.main;
import java.io.FileNotFoundException;
import java.io.IOException;

import ar.edu.unlam.pa.polinomio.Polinomio;
import ar.edu.unlam.pa.redimiento.tiempos.TiemposDeEjecucion;
import ar.edu.unlam.pa.redimiento.tiempos.csvWriter;

public class Main {

	public static void main(String[] args) {
		
		try {
			tiemposDeEjecucionCsv("TiemposDeEjecucion.csv");
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	static void tiemposDeEjecucionCsv(String nombreCsv) throws FileNotFoundException {
		
		Polinomio p0 = new Polinomio(new double[] {3}); //Polinomio grado 0
		Polinomio p4 = new Polinomio(new double[] {8.32, 2.21, 3, 14.5, 4.44}); //Polinomio grado 4
		Polinomio p8 = new Polinomio(new double[] {0.16, -1.8, -6, 12.7, 9.12, 0, 7.44, 3.24, 0}); //Polinomio grado 8
		
		String[] evaluadoresEnOrden = new String[7];
		evaluadoresEnOrden[0] = "Evaluar sucesivas: ";
		evaluadoresEnOrden[1] = "Evaluar recursiva: ";
		evaluadoresEnOrden[2] = "Evaluar recursiva par: ";
		evaluadoresEnOrden[3] = "Evaluar programacion dinamica: ";
		evaluadoresEnOrden[4] = "Evaluar mejorada: ";
		evaluadoresEnOrden[5] = "Evaluar Math.pow: ";
		evaluadoresEnOrden[6] = "Evaluar horner: ";
		
		csvWriter csv = new csvWriter(nombreCsv);
		
		csv.agregarLinea("X = 0, Polinomio grado 0, Polinomio grado 4, Polinomio grado 8");
		double x = 0;
		long[][] tiempos = new long[3][];
		tiempos[0] = new TiemposDeEjecucion(p0, x).calcularTiemposDeEjecucion();
		tiempos[1] = new TiemposDeEjecucion(p4, x).calcularTiemposDeEjecucion();
		tiempos[2] = new TiemposDeEjecucion(p8, x).calcularTiemposDeEjecucion();
		csv.agregarTiemposDeEjecucion(evaluadoresEnOrden, tiempos);
		
		csv.agregarLinea("\nX = 4.22, Polinomio grado 0, Polinomio grado 4, Polinomio grado 8");
		x = 4.22;
		tiempos[0] = new TiemposDeEjecucion(p0, x).calcularTiemposDeEjecucion();
		tiempos[1] = new TiemposDeEjecucion(p4, x).calcularTiemposDeEjecucion();
		tiempos[2] = new TiemposDeEjecucion(p8, x).calcularTiemposDeEjecucion();
		csv.agregarTiemposDeEjecucion(evaluadoresEnOrden, tiempos);
		
		csv.agregarLinea("\nX = 13, Polinomio grado 0, Polinomio grado 4, Polinomio grado 8");
		x = 13;
		tiempos[0] = new TiemposDeEjecucion(p0, x).calcularTiemposDeEjecucion();
		tiempos[1] = new TiemposDeEjecucion(p4, x).calcularTiemposDeEjecucion();
		tiempos[2] = new TiemposDeEjecucion(p8, x).calcularTiemposDeEjecucion();
		csv.agregarTiemposDeEjecucion(evaluadoresEnOrden, tiempos);
		
		csv.close();
	}

}
