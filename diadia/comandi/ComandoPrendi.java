package diadia.comandi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**

 * Questa classe modella il comando prendi
 * ovvero il comando che prende un oggetto dalla stanza attuale
 * e lo aggiunge, se possibile, nella borsa.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoPrendi extends AbstractComando {

	private final static String nome= "prendi";
	//private String attrezzo;
	/*
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
	@Override
	public void esegui(Partita partita) {
	    Attrezzo a = partita.getLabirinto().getStanzaCorrente().getAttrezzo(this.getParametro());
	    if (a == null) {
	        this.getIo().mostraMessaggio("Attrezzo inesistente");
	    } else if (partita.getGiocatore().getBorsa().addAttrezzo(a)) {
	        partita.getLabirinto().getStanzaCorrente().removeAttrezzo(a);
	        this.getIo().mostraMessaggio("Hai preso: " + a);
	        this.getIo().mostraMessaggio("Borsa: " + partita.getGiocatore().getBorsa().toString());
	    } else {
	        this.getIo().mostraMessaggio("Attrezzo troppo pesante per la borsa");
	    }
	}

	/*
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
	*/
	
	@Override
	public String getNome() {
		return nome;
	}

}
