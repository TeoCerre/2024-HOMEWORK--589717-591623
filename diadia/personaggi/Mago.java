package diadia.personaggi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**
 * Una classe mago che se ottiene un regalo
 * ne dimezza il peso
 * @author  Matteo Cerretani,Daniele Granato
 * @version 4.0
 */
public class Mago extends AbstractPersonaggio {
	private static final String MESSAGGIO_DONO = "Sei un vero simpaticone, " +
			"con una mia magica azione, troverai un nuovo oggetto " +
			"per il tuo borsone!";
	private static final String MESSAGGIO_SCUSE = "Mi spiace, ma non ho piu' nulla...";
	private Attrezzo attrezzo;
	public Mago(String nome, String presentazione, Attrezzo attrezzo) {
		super(nome, presentazione);
		this.attrezzo = attrezzo;
	}
	@Override
	public String agisci(Partita partita) {
		String msg;
		if (this.attrezzo!=null) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.attrezzo);
			this.attrezzo = null;
			msg = MESSAGGIO_DONO;
		}
		else {
			msg = MESSAGGIO_SCUSE;
		}
		return msg;
	}
	
	@Override
	public String riceviRegalo(Attrezzo attrezzo,Partita partita) {
		StringBuilder risposta = new StringBuilder("Grazie, lo modificho un po' e lo rilascio... ");
		attrezzo.setPeso(attrezzo.getPeso()/2);
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		return risposta.toString();
	}
}