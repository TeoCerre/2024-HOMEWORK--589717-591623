package diadia.comandi;

import diadia.IOConsole;
import diadia.IO;
import diadia.Partita;

/**

 * Questa classe modella il comando aiuto
 * ovvero il comando che stampa tutti i possibili comandi da poter eseguire.
 * @author Matteo Cerretani,Daniele Granato
 * @version 3.0
*/
public class ComandoAiuto implements Comando {
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	private IOConsole IO = new IOConsole();
	
	// implementazioni dei comandi dell'utente:

		/**
		 * Stampa informazioni di aiuto.
		 */
	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio("\nI comandi sono: ");
		for(int i=0; i< elencoComandi.length; i++) 
			IO.mostraMessaggio(elencoComandi[i] + " ");
		IO.mostraMessaggio("");
	}

	@Override
	public void setParametro(String param) {
		
	}
	@Override
	public void setIO(IO io) {
		
	}
	@Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return null;
	}

}
