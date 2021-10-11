import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class csvWriter {
	
	private FileOutputStream fos;
	private PrintWriter pw;
	
	public csvWriter(String nombreCsv) throws FileNotFoundException {
		this.fos = new FileOutputStream(nombreCsv, true);
		this.pw = new PrintWriter(fos);
	}
	
	public void agregarLinea(String linea) {
		pw.println(linea);
	}
	
	public void agregarTiemposDeEjecucion(String[] evaluadores, long[][] tiempos) {
		
		String toPrint = "";
		
		for(int i = 0; i<evaluadores.length; i++) {
			toPrint +=evaluadores[i] + ",";
			for(int j = 0; j<tiempos.length; j++) {
				toPrint += tiempos[j][i] + ",";
			}
			pw.println(toPrint);
			toPrint = "";
		}
	}
	
	public void close() {
		pw.close();
	}
	
}
