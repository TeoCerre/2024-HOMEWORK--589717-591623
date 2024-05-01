package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

/**

 * Questa classe modella il comando posa
 * ovvero il comando che permette di posare un attrezzo nella stanza attuale.
 * @author Matteo Cerretani,Daniele Granato
 * @version 2.0
*/
public class ComandoPosa implements Comando{

	private String attrezzo;
	private IOConsole IO = new IOConsole();

	public ComandoPosa(String param) {
		this.attrezzo = param;
	}

	public ComandoPosa() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Cerca di posare un attrezzo
	 * se la borssa è vuota o se l'attrezzo non è presente nella borsa stampa un messaggio di errore
	 * altrimenti aggiunge l'attrezzo nella stanza corrente e lo rimuove dalla borsa stampandone il contenuto aggiornato
	 * @param nomeAttrezzo
	 */
	@Override
	public void esegui(Partita partita) {

		if(this.attrezzo==null)
	        this.IO.mostraMessaggio("Quale Attrezzo vuoi posare?");
	    if(partita.getGiocatore().getBorsa().getAttrezzi()[0]!=null) {
	      if(partita.getGiocatore().getBorsa().hasAttrezzo(this.attrezzo)==true) {
	          partita.getLabirinto().getStanzaCorrente().addAttrezzo(partita.getGiocatore().getBorsa().getAttrezzo(this.attrezzo));
	          partita.getGiocatore().getBorsa().removeAttrezzo(this.attrezzo);
	          this.IO.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	      } else {
	          this.IO.mostraMessaggio("Attrezzo inesistente");
	      }
	    } else
	    	this.IO.mostraMessaggio("Borsa vuota");
}

	@Override
	public void setParametro(String param) {
		this.attrezzo = param;
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
