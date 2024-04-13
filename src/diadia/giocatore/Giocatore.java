package diadia.giocatore;


/**
 * Una classe Giocatore con le sue caratteristiche
 * il giocatore parte con 20 cfu
 * @author  Matteo Cerretani,Daniele Granato
 * @version 1.0
 */

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	
	private Borsa borsa = new Borsa();
	private int cfu = 0;
	
	public Giocatore() {
		this.cfu=CFU_INIZIALI;
	}
	/**
	* Prende il numero dei cfu del giocatore
	* Somma tutti i pesi degli attrezzi nella borsa.
	* @return un intero pari al numero di cfu del giocatore.
	*/
	public int getCFU() {
		return this.cfu;
	}
	/**
	* Imposta il numero dei cfu del giocatore
	* @param intero pari al numero di cfu da impostare.
	*/
	public void setCFU(int cfu) {
		this.cfu = cfu;		
	}
	/**
	* Prende l'oggetto borsa del giocatore
	* @return borsa del giocatore.
	*/
	public Borsa getBorsa() {
		return this.borsa;	
	}
}

