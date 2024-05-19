package diadia.ambienti;


/**
 * Classe Stanza Bloccata- una stanza in un gioco di ruolo.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione, ma una di queste è bloccata
 * Per sbloccarla sarà necesssario possedere un determinato oggetto.
 * 
 * @author Matteo Cerretani,Daniele Granato
 * @version 3.0
*/
public class StanzaBloccata extends Stanza{
	private String direzioneBloccata;
	private String attrezzoChiave;
	
	public StanzaBloccata(String nome,String direzioneBloccata,String attrezzoChiave){
		super(nome);
		this.direzioneBloccata=direzioneBloccata;
		this.attrezzoChiave=attrezzoChiave;
	}
	
	/**
     * Restituisce la stanza adiacente nella direzione specificata
     * solo se è presente l'attrezzo che la sblocca nella stanza
     * @param direzione
     */
	@Override
    public Stanza getStanzaAdiacente(String dir) {
		if(direzioneBloccata.equals(dir) && this.hasAttrezzo(attrezzoChiave)==false) {
			return this;
		}else {
			return super.getStanzaAdiacente(dir);
		}
    }
	@Override
	public String getDescrizione() {
		if(!this.hasAttrezzo(attrezzoChiave))
			return "Stanza bloccata nella direzione: "+ direzioneBloccata+"\nLascia nella stanza attuale l'attrezzo: " + attrezzoChiave;
		return super.getDescrizione();
	}
	
}
