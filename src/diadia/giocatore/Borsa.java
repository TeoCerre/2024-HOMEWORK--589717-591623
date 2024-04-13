package diadia.giocatore;

import diadia.attrezzi.Attrezzo;

/**
 * Una classe borsa che contiene gli attrezzi
 * Il peso massimo è di 10 Kg
 * Permette di prendere e posare oggetti dalla borsa
 *
 * @author  docente di POO,Matteo Cerretani,Daniele Granato
 * @see Attrezzo
 * @version 1.0
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Attrezzo[] attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.numeroAttrezzi = 0;
	}
	/**
     * Mette un attrezzo nella borsa.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		if (this.numeroAttrezzi==10)
			return false;
		this.attrezzi[this.numeroAttrezzi] = attrezzo;
		this.numeroAttrezzi++;
		return true;
	}
	/**
     * Restituisce il peso massimo della borsa.
	 * @return un intero pari al peso massimo
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	/**
     * Restituisce la collezione di attrezzi presenti nella borsa.
     * @return la collezione di attrezzi nella stanza.
     */
	public Attrezzo[] getAttrezzi() {
        return this.attrezzi;
    }
	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i]!=null) {
				if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
					a = attrezzi[i];
			}
		}
		return a;
	}
	/**
	* Prende il peso totale della borsa
	* Somma tutti i pesi degli attrezzi nella borsa.
	* @return un intero pari al peso complessivo.
	*/
	public int getPeso() {
		int peso = 0;
		for (int i= 0; i<this.numeroAttrezzi; i++) {
			if(this.attrezzi[i]!=null) {
				peso += this.attrezzi[i].getPeso();
			}
		}
		return peso;
	}
	/**
	* Controlla se la borsa è vuota.
	* @return true se la borsa è vuota,0 altrimenti.
	*/
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	/**
	* Controlla se un attrezzo esiste nella borsa (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	/**
	 * Rimuove un attrezzo dalla borsa (ricerca in base al nome).
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String attrezzo) {
	    for(int i=0;i<10;i++) {
	        if(this.attrezzi[i]!= null && attrezzo.equals(this.attrezzi[i].getNome())) {
	            this.attrezzi[i]=null;
	            for(int j=i; j<9;j++)
	            	this.attrezzi[j]=this.attrezzi[j+1];
	            this.numeroAttrezzi--;
	            this.attrezzi[9]=null;
	            return true;
	         }
	    }
	    return false;
	}
	/**
	 * Ritorna una stringa con tutte le informazioni della bors
	 * @return stringa con le informazioni necessarie
	 */
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			for (int i= 0; i<this.numeroAttrezzi; i++)
				s.append(attrezzi[i].toString()+" ");
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}
}
