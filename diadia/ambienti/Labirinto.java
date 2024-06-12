package diadia.ambienti;

import java.io.FileNotFoundException;
import diadia.FormatoFileNonValidoException;
import java.util.HashMap;
import java.util.Map;

import diadia.CaricatoreLabirinto;
import diadia.attrezzi.Attrezzo;
import diadia.personaggi.Cane;
import diadia.personaggi.Mago;
import diadia.personaggi.Strega;

/**
 * Classe Labirinto - un labirinto in un gioco di ruolo.
 * Un labirinto contiene le stanze.
 * Contiene la stanza vincente.
 * @author Matteo Cerretani,Daniele Granato
 * @see Stanza
 * @version 4.0
 */


public class Labirinto {
	private Stanza stanzaVincente;
	private Stanza stanzaIniziale;
	
	private Labirinto(String nomeFile) throws FileNotFoundException, FormatoFileNonValidoException {
		CaricatoreLabirinto c =new CaricatoreLabirinto(nomeFile);
		c.carica();
		this.stanzaIniziale = c.getStanzaIniziale();
		this.stanzaVincente = c.getStanzaVincente();
	}
    /**
     * Crea tutte le stanze e le porte di collegamento
    
   		public void creaStanze() {

		// crea gli attrezzi 
    	Attrezzo lanterna = new Attrezzo("lanterna",3);
		Attrezzo osso = new Attrezzo("osso",1);
    	
		// crea stanze del labirinto 
		Stanza atrio = new Stanza("Atrio");
		Stanza aulaN11 = new Stanza("Aula N11");
		Stanza aulaN10 = new Stanza("Aula N10");
		Stanza laboratorio = new Stanza("Laboratorio Campus");
		Stanza biblioteca = new Stanza("Biblioteca");
		
		// collega le stanze
		atrio.impostaStanzaAdiacente("nord", biblioteca);
		atrio.impostaStanzaAdiacente("est", aulaN11);
		atrio.impostaStanzaAdiacente("sud", aulaN10);
		atrio.impostaStanzaAdiacente("ovest", laboratorio);
		aulaN11.impostaStanzaAdiacente("est", laboratorio);
		aulaN11.impostaStanzaAdiacente("ovest", atrio);
		aulaN10.impostaStanzaAdiacente("nord", atrio);
		aulaN10.impostaStanzaAdiacente("est", aulaN11);
		aulaN10.impostaStanzaAdiacente("ovest", laboratorio);
		laboratorio.impostaStanzaAdiacente("est", atrio);
		laboratorio.impostaStanzaAdiacente("ovest", aulaN11);
		biblioteca.impostaStanzaAdiacente("sud", atrio);

        // pone gli attrezzi nelle stanze 
		aulaN10.addAttrezzo(lanterna);
		atrio.addAttrezzo(osso);

		// il gioco comincia nell'atrio
        stanzaCorrente = atrio;  
		stanzaVincente = biblioteca;
    }
	*/
    /**
	 * Restituisce la stanza vincente
	 * @return  stanza vincente
	 */
	public Stanza getStanzaVincente() {
		return stanzaVincente;
	}
	/**
	 * Permette di impostare la stanza corrente
	 * @param stanzaCorrente
	 */
	public void setStanzaCorrente(Stanza stanzaCorrente) {
		this.stanzaIniziale = stanzaCorrente;
	}
	/**
	 * Restituisce la stanza corrente
	 * @return stanza corrente
	 */
	public Stanza getStanzaCorrente() {
		return this.stanzaIniziale;
	}
	/**
	 * Permette di impostare la stanza vincente
	 * @param s
	 */
	public void setStanzaVincente(Stanza s) {
		this.stanzaVincente=s;
		
	}
	
	public static LabirintoBuilder newBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
		return new LabirintoBuilder(labirinto);
	}
	
	public static class LabirintoBuilder {
		
		private Labirinto labirinto;
		private Stanza stanzaAttuale;
		private Map<String, Stanza> stanze;
		
		public LabirintoBuilder(String labirinto) throws FileNotFoundException, FormatoFileNonValidoException {
			this.labirinto=new Labirinto(labirinto);
			this.stanze=new HashMap<String, Stanza>();
		}
		
		public Labirinto getLabirinto() {
			return this.labirinto;
		}
		/**
		 * Restituisce la mappa delle stanze aggiunte al labirinto.
		 * @return la mappa delle stanze aggiunte al labirinto
		 */
		public Map<String, Stanza> getStanze(){
			return this.stanze;
		}
		
		public void setStanzaAttuale(Stanza stanzaAttuale) {
			this.stanzaAttuale=stanzaAttuale;
		}
		/**
		 * Aggiunge una stanza al labirinto.
		 * @param stanzaAttuale la stanza da aggiungere
		 */
		public void aggiungiStanza(Stanza stanzaAttuale) {
			this.setStanzaAttuale(stanzaAttuale);
			this.stanze.put(stanzaAttuale.getNome(),stanzaAttuale);
		}
		/**
		 * Aggiunge una stanza di partenza al labirinto.
		 * @param stanzaPartenza il nome della stanza di partenza
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addStanzaPartenza(String stanzaPartenza) {
			Stanza s=new Stanza(stanzaPartenza);
			this.labirinto.setStanzaCorrente(s);
			this.aggiungiStanza(s);
			return this;
		}
		/**
		 * Aggiunge una stanza vincente al labirinto.
		 * @param stanzaVincente il nome della stanza vincente
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addStanzaVincente(String stanzaVincente) {
			Stanza s=new Stanza(stanzaVincente);
			this.labirinto.setStanzaVincente(s);
			this.aggiungiStanza(s);
			return this;
		}
		/**
		 * Aggiunge una stanza normale al labirinto.
		 * @param stanzaNormale il nome della stanza normale
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addStanzaNormale(String stanzaNormale) {
			Stanza s=new Stanza(stanzaNormale);
			this.aggiungiStanza(s);
			return this;
		}
		/**
		 * Collega due stanze nel labirinto
		 * Collega la prima stanza fornita con la seconda nella
		 * direzione passata e viceversa sfruttando il metodo
		 * calcola direzione opposta in modo tale che il 
		 * collegamento sia bilaterale.
		 * @param direzione la direzione in cui collegare le stanze
		 * @param stanzaAttuale il nome della stanza attuale
		 * @param stanzaAdiacente il nome della stanza adiacente
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder collegaStanze(Direzione direzione, String stanzaAttuale, String stanzaAdiacente) {
		    Stanza attuale = this.stanze.get(stanzaAttuale);
		    Stanza adiacente = this.stanze.get(stanzaAdiacente);
		    attuale.impostaStanzaAdiacente(direzione, adiacente);
		    Direzione direzioneOpposta = calcolaDirezioneOpposta(direzione);
		    adiacente.impostaStanzaAdiacente(direzioneOpposta, attuale);
		    return this;
		}
		/**
		 * Calcola la direzione opposta a quella specificata.
		 * @param direzione la direzione di partenza
		 * @return la direzione opposta
		 */
		private Direzione calcolaDirezioneOpposta(Direzione direzione) {
		    switch (direzione) {
		        case nord: return Direzione.sud;
		        case sud: return Direzione.nord;
		        case est: return Direzione.ovest;
		        case ovest: return Direzione.est;
		        default: return null;
		    }
		}
		/**
		 * Aggiunge un attrezzo alla stanza attuale, se presente
		 * altrimenti non lo aggiunge.
		 * @param nomeAttrezzo il nome dell'attrezzo da aggiungere
		 * @param peso il peso dell'attrezzo da aggiungere
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addAttrezzo(String nomeAttrezzo,int peso) {
			Attrezzo attrezzo=new Attrezzo(nomeAttrezzo,peso);
			if(this.stanzaAttuale==null) return this;
			this.stanzaAttuale.addAttrezzo(attrezzo);
			return this;
		}
		/**
		 * Aggiunge una stanza magica al labirinto.
		 * @param stanzaMagica il nome della stanza magica
		 * @param soglia la soglia magica della stanza
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addStanzaMagica(String stanzaMagica,int soglia) {
			Stanza s = new StanzaMagica(stanzaMagica,soglia);
			this.aggiungiStanza(s);
			return this;
		}
		/**
		 * Aggiunge una stanza bloccata al labirinto.
		 * @param stanzaBloccata il nome della stanza bloccata
		 * @param attrezzoChiave il nome dell'attrezzo chiave per sbloccare la stanza
		 * @param direzioneBloccata la direzione bloccata dalla stanza
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addStanzaBloccata(String stanzaBloccata, String attrezzoChiave, Direzione direzioneBloccata) {
			Stanza s = new StanzaBloccata(stanzaBloccata,direzioneBloccata,attrezzoChiave);
			this.aggiungiStanza(s);
			return this;
		}
		/**
		 * Aggiunge una stanza buia al labirinto.
		 * @param stanzaBuia il nome della stanza buia
		 * @param attrezzoBuio il nome dell'attrezzo che permette di vedere nella stanza buia
		 * @return il LabirintoBuilder per il chaining dei metodi
		 */
		public LabirintoBuilder addStanzaBuia(String stanzaBuia,String attrezzoBuio) {
			Stanza s = new StanzaBuia(stanzaBuia,attrezzoBuio);
			this.aggiungiStanza(s);
			return this;
		}
		/**
		 * Restituisce una copia della mappa delle stanze.
		 * @return una copia della mappa delle stanze
		 */
		public Map<String, Stanza> getListaStanze() {
	        return new HashMap<>(this.stanze);
	    }
		
		public LabirintoBuilder addCane(String nome,String saluto) {
			Cane c=new Cane(nome,saluto);
			if(this.stanzaAttuale==null) return this;
			this.stanzaAttuale.setPersonaggio(c);
			return this;
		}
		
		public LabirintoBuilder addMago(String nome,String saluto,Attrezzo attrezzo) {
			Mago m=new Mago(nome,saluto,attrezzo);
			if(this.stanzaAttuale==null) return this;
			this.stanzaAttuale.setPersonaggio(m);
			return this;
		}
		
		public LabirintoBuilder addStrega(String nome,String saluto) {
			Strega s=new Strega(nome,saluto);
			if(this.stanzaAttuale==null) return this;
			this.stanzaAttuale.setPersonaggio(s);
			return this;
		}
	}


}
