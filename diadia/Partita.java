package diadia;

import diadia.ambienti.Labirinto;

import diadia.giocatore.Giocatore;

/**
 * Questa classe modella una partita del gioco
 *
 * @author  docente di POO,Matteo Cerretani,Daniele Granato
 * @see Giocatore,Labirinto
 * @version 4.0
 */

public class Partita {

	private boolean finita;
	private Labirinto lab;
	private Giocatore giocatore;
	
	public Partita(Labirinto labirinto){
		this.finita = false;
		this.lab=labirinto;
		//lab.creaStanze();
		this.giocatore=new Giocatore();
	}	
	/**
	 * Restituisce vero se e solo se la partita e' stata vinta
	 * @return vero se partita vinta
	 */
	public boolean vinta() {
		return this.lab.getStanzaCorrente()== this.lab.getStanzaVincente();
	}

	/**
	 * Restituisce vero se e solo se la partita e' finita
	 * @return vero se partita finita
	 */
	public boolean isFinita() {
		return finita || vinta() || (this.giocatore.getCFU() == 0);
	}

	/**
	 * Imposta la partita come finita
	 *
	 */
	public void setFinita() {
		this.finita = true;
	}
	/**
	 * Ritorna il labirinto
	 * @return labirinto
	 */
	public Labirinto getLabirinto() {
		return this.lab;
	}
	/**
	 * Ritorna il giocatore
	 * @return giocatore
	 */
	public Giocatore getGiocatore() {
		return this.giocatore;
	}
	/**
	 * Verifica se il giocatore ha ancora cfu
	 * @return true se ha ancora cfu,false altrimenti
	 */
	public boolean giocatoreIsVivo() {
		return this.giocatore.getCFU()>0;
	}
	
}

