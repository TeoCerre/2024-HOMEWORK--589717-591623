package diadia.ambienti;

/**
 * Classe Stanza Bloccata- una stanza in un gioco di ruolo.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione
 * La sua descrizione stamperà un messaggio se non si possiede un oggetto per illuminarla
 * 
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/
public class StanzaBuia extends Stanza {
	private String attrezzoBuio;
	
	public StanzaBuia(String nome,String attrezzoBuio){
		super(nome);
		this.attrezzoBuio=attrezzoBuio;	
	}
	/**
	 * Restituisce la descrizione della stanza, ma se non ha un oggetto per illuminarla
	 * stampa il messaggio "qui c'è un buio pesto"
	 * @return stringa con una descrizione della stanza oppure "qui c'è un buio pesto"
	 */
	@Override
	public String getDescrizione() {
		if(this.hasAttrezzo(attrezzoBuio))
			return super.getDescrizione();
		return "qui c'è un buio pesto";
	}
	
}
