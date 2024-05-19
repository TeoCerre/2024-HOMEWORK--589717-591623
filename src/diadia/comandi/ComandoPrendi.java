package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**

 * Questa classe modella il comando prendi
 * ovvero il comando che prende un oggetto dalla stanza attuale
 * e lo aggiunge, se possibile, nella borsa.
 * @author Matteo Cerretani,Daniele Granato
 * @version 3.0
*/

public class ComandoPrendi implements Comando{

	private String attrezzo;
	private IOConsole IO = new IOConsole();

	public ComandoPrendi(String param) {
		this.attrezzo = param;
	}

	public ComandoPrendi() {
		
	}

	/**
	 * Cerca di prendere un attrezzo
	 * se la stanza non ha attrezzi o se l'attrezzo cercato non è presente stampa un messaggio di errore
	 * altrimenti se l'attrezzo è nella stanza aggiunge l'attrezzo nella borsa e ne stampa il contenuto
	 * @param nomeAttrezzo
	 */
	public void esegui(Partita partita) {
		Attrezzo a=partita.getLabirinto().getStanzaCorrente().getAttrezzo(attrezzo);
		if(this.attrezzo==null)
	        this.IO.mostraMessaggio("Quale attrezzo vuoi prendere ?");
	    if(partita.getLabirinto().getStanzaCorrente().getAttrezzi()!=null) { 
	      if(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(this.attrezzo)==true) {
	          partita.getGiocatore().getBorsa().addAttrezzo(partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.attrezzo));
	          partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
	          this.IO.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
	      } else {
	          this.IO.mostraMessaggio("Attrezzo inesistente");
	      }
	      }else
	    	  this.IO.mostraMessaggio("Non ci sono attrezzi nella stanza");
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
