package diadia.personaggi;

import java.util.List;

import diadia.Partita;
import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

/**
 * Una classe strega si ruba l'attrezzo
 *  che le viene regalato e ride
 * @author  Matteo Cerretani,Daniele Granato
 * @version 4.0
 */

public class Strega extends AbstractPersonaggio {
	private static final String MESSAGGIO_SALUTATA = "Mi hai salutata,"
			+ "ti porto nella stanza più vicina con più attrezzi";
	private static final String MESSAGGIO_NON_SALUTATA = "Non mi hai salutata,"
			+ "ti porto nella stanza più vicina con meno attrezzi";
	
	public Strega(String nome, String presentazione) {
		super(nome, presentazione);
	}
	
	@Override
	public String agisci(Partita partita) {
		String messaggio;
		List<Stanza> stanzeAdiacenti = partita.getLabirinto().getStanzaCorrente().getStanzeAdiacenti();
		Stanza max = stanzeAdiacenti.get(0);
		Stanza min = stanzeAdiacenti.get(0);
		for(Stanza stanza : stanzeAdiacenti) {
			if(stanza != null) {
				if(stanza.getNumeroAttrezzi() > max.getNumeroAttrezzi())
					max = stanza;
				if(stanza.getNumeroAttrezzi() < min.getNumeroAttrezzi())
					min = stanza;
			}
		}
		if(this.haSalutato()) {
			partita.getLabirinto().setStanzaCorrente(max);
			messaggio = MESSAGGIO_SALUTATA;
		} else {
			partita.getLabirinto().setStanzaCorrente(min);
			messaggio = MESSAGGIO_NON_SALUTATA;
		}

		return messaggio;
	}
	@Override
	public String riceviRegalo(Attrezzo attrezzo, Partita partita) {
		partita.getGiocatore().getBorsa().removeAttrezzo(attrezzo.getNome());
		return "AHAHAHAHAHAHHA";
	}
}
