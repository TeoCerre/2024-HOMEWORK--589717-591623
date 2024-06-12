package diadia.comandi;

import diadia.Partita;

/**

 * Questa classe modella il comando aiuto
 * ovvero il comando che stampa tutti i possibili comandi da poter eseguire.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/
public class ComandoAiuto extends AbstractComando {
	
	static final private String[] elencoComandi = {"vai", "prendi", "posa", "guarda", "aiuto", "fine"};
	private final static String nome= "aiuto";
	
	// implementazioni dei comandi dell'utente:

		/**
		 * Stampa informazioni di aiuto.
		 */
	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("\nI comandi sono: ");
		for(int i=0; i< elencoComandi.length; i++) 
			this.getIo().mostraMessaggio(elencoComandi[i] + " ");
		this.getIo().mostraMessaggio("");
	}
	/*
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
	*/
	@Override
	public String getNome() {
		return nome;
	}
	
}
