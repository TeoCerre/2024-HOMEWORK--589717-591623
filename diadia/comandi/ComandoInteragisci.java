package diadia.comandi;

import diadia.Partita;
import diadia.personaggi.AbstractPersonaggio;

/**

 * Questa classe modella il comando interagisci
 * ovvero il comando che permette di interagire con i personaggi nelle stanze.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoInteragisci extends AbstractComando{
	private final static String nome= "interagisci";
	private String messaggio;
	private static final String MESSAGGIO_CON_CHI =
			"Con chi dovrei interagire?...";
	@Override
	public void esegui(Partita partita) {
		AbstractPersonaggio personaggio;
		personaggio = partita.getLabirinto().getStanzaCorrente().getPersonaggio();
		if (personaggio!=null) {
			this.messaggio = personaggio.agisci(partita);
			this.getIo().mostraMessaggio(this.messaggio);
		} else this.getIo().mostraMessaggio(MESSAGGIO_CON_CHI);
	}
	
	public String getMessaggio() {
		return this.messaggio;
	}
	
	@Override
	public void setParametro(String parametro) {
		
	}
	
	@Override
	public String getNome() {
		return nome;
	}
}
