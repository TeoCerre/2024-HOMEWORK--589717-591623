package diadia;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Classe che permette di caricare le costanti
 * da file testuale
 *
 * @author  Matteo Cerretani,Daniele Granato
 *          
 * @version 4.0
 */

public class Configuratore {
	private static final String DIADIA_PROPERTIES = "diadia.properties";
	private static final String PESO_MAX = "pesoMax";
	private static final String DIREZIONI_MAX= "direzioniMax";
	private static final String ATTREZZI_MAX="attrezziMax";
	private static final String CFU = "cfu";
	private static Properties properties = null;
	
	public static int getCFU() {
		if(properties == null)
			carica();
		return Integer.parseInt(properties.getProperty(CFU));
	}
	
	public static int getPesoMax() {
		if(properties == null)
			carica();
		return Integer.parseInt(properties.getProperty(PESO_MAX));
	}
	
	public static int getDirezioniMax() {
		if(properties == null)
			carica();
		return Integer.parseInt(properties.getProperty(DIREZIONI_MAX));	
	}
	
	public static int getAttrezziMax() {
		if(properties == null)
			carica();
		return Integer.parseInt(properties.getProperty(ATTREZZI_MAX));	
	}

	private static void carica() {
		properties = new Properties();
		try {
			FileInputStream input = new FileInputStream(DIADIA_PROPERTIES);
			properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
