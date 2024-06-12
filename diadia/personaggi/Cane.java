package diadia.personaggi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**
 * Una classe cane che morde il giocatore nel
 * caso in cui non gli venga regalato il suo cibo preferito
 * altrimenti lascia un attrezzo collare
 * @author  Matteo Cerretani,Daniele Granato
 * @version 4.0
 */

public class Cane extends AbstractPersonaggio{
	private static String MESSAGGIO_CANE = "Arrrgh (con fare minaccioso)";
	private static String CIBO_PREFERITO= "croccantini";

	public Cane(String nome, String presentazione) {
		super(nome, presentazione);
	}

	@Override
	public String agisci(Partita partita) {
		String messaggio = MESSAGGIO_CANE;
		partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
		return messaggio;
	}

	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		StringBuilder risposta = new StringBuilder("Bau bau");
		if(attrezzo.getNome().equals(CIBO_PREFERITO)) {
			risposta.append("(scodinzola)");
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("collare", 1));
		} else {
			partita.getGiocatore().setCFU(partita.getGiocatore().getCFU()-1);
		}
		return risposta.toString();
	}
	
}
