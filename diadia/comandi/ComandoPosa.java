package diadia.comandi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**

 * Questa classe modella il comando posa
 * ovvero il comando che permette di posare un attrezzo nella stanza attuale.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/
public class ComandoPosa extends AbstractComando{

	private final static String nome = "posa";
	/*
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
		 Attrezzo a = partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
	        if (a == null) {
	            this.getIo().mostraMessaggio("Attrezzo inesistente");
	            return;
	        }
	        if(partita.getLabirinto().getStanzaCorrente().getNumeroAttrezziPossibili()>0) {
				partita.getLabirinto().getStanzaCorrente().addAttrezzo(a);
				partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			}
			else {
				this.getIo().mostraMessaggio("Non c'e' spazio nella stanza per poter inserire questo attrezzo!");
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
