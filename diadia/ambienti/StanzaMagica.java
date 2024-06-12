package diadia.ambienti;

import diadia.attrezzi.Attrezzo;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * dopo N volte  viene posato un qualsiasi attrezzo da parte 
 * del giocatore, la stanza
 * inizierà a comportarsi «magicamente» ovvero:
 *  ogni volta che posiamo un attrezzo, la stanza "inverte" il nome
 * dell'attrezzo e ne raddoppia il peso.
 * altrimenti si comporterà normalmente
 * @author docente di POO,Matteo Cerretani,Daniele Granato
 * @see Attrezzo
 * @version 4.0
*/

public class StanzaMagica extends Stanza {
	final static private int SOGLIA_MAGICA_DEFAULT = 3;
	private int contatoreAttrezziPosati;
	private int sogliaMagica;
	
	public StanzaMagica(String nome) {
		this(nome, SOGLIA_MAGICA_DEFAULT);
	}
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}
	/**
     * Mette un attrezzo nella stanza. Aumentando il contatore
     * Se il numero di attrezzi supera la soglia magica la stanza inizia a comportarsi magicamente
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		this.contatoreAttrezziPosati++;
		if (this.contatoreAttrezziPosati>this.sogliaMagica)
		attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}
	
	/**
     * Modifica un attrezzo della stanza
     * invertendo il nome dell'attrezzo e raddoppiandone il peso il peso.
     * @param attrezzo, attrezzo da modificare.
     * @return l'attrezzo modificato.
     */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),pesoX2);
		return attrezzo;
	}
}
