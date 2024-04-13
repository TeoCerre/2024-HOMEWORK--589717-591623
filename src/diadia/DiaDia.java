package diadia;
import java.util.Scanner;

import diadia.ambienti.Stanza;



/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO,Matteo Cerretani,Daniele Granato 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version 1.0
 */

public class DiaDia {

	static final private String MESSAGGio_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	
	static final private String[] elencoComandi = {"vai", "aiuto", "fine","prendi","posa"};

	private Partita partita;
	private IOConsole io;

	public DiaDia(IOConsole console) {
		this.io = console;
		this.partita = new Partita();
	}

	public void gioca() {
		String istruzione;
		Scanner scannerdiLinee;

		io.mostraMessaggio(MESSAGGio_BENVENUTO);
				
		do {	
			istruzione = io.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   


	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) {
		
		Comando comandoDaEseguire = new Comando(istruzione);
		
		if(comandoDaEseguire.sconosciuto()) {
			io.mostraMessaggio("Comando sconosciuto");
			return false;
		}
		else if (comandoDaEseguire.getNome().equals("fine")) {
			this.fine(); 
			return true;
		} 
		else if (comandoDaEseguire.getNome().equals("prendi"))
			this.prendi(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("posa"))
			this.posa(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("vai"))
			this.vai(comandoDaEseguire.getParametro());
		else if (comandoDaEseguire.getNome().equals("aiuto"))
			this.aiuto();
		else
			io.mostraMessaggio("Comando sconosciuto");
		if (this.partita.vinta()) {
			io.mostraMessaggio("Hai vinto!");
			return true;
		} else
			return false;

	}

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto() {
		for(int i=0; i< elencoComandi.length; i++) 
			io.mostraMessaggio(elencoComandi[i]+" ");
		io.mostraMessaggio("");
	}

	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(String direzione) {
		if(direzione==null)
			io.mostraMessaggio("Dove vuoi andare ?");
		Stanza prossimaStanza = null;
		prossimaStanza = this.partita.getLabirinto().getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			io.mostraMessaggio("Direzione inesistente");
		else {
			this.partita.getLabirinto().setStanzaCorrente(prossimaStanza);
			int cfu = this.partita.getGiocatore().getCFU();
			this.partita.getGiocatore().setCFU(cfu--);
		}
		io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
	}
	
	/**
	 * Cerca di prendere un attrezzo
	 * se la stanza non ha attrezzi o se l'attrezzo cercato non è presente stampa un messaggio di errore
	 * altrimenti se l'attrezzo è nella stanza aggiunge l'attrezzo nella borsa e ne stampa il contenuto
	 * @param nomeAttrezzo
	 */
	private void prendi(String nomeAttrezzo) {
	    if(nomeAttrezzo==null)
	        io.mostraMessaggio("Quale attrezzo vuoi prendere ?");
	    if(this.partita.getLabirinto().getStanzaCorrente().getAttrezzi()[0]!=null) { 
	      if(this.partita.getLabirinto().getStanzaCorrente().hasAttrezzo(nomeAttrezzo)==true) {
	          this.partita.getGiocatore().getBorsa().addAttrezzo(this.partita.getLabirinto().getStanzaCorrente().getAttrezzo(nomeAttrezzo));
	          this.partita.getLabirinto().getStanzaCorrente().removeAttrezzo(nomeAttrezzo);
	          io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	      } else {
	          io.mostraMessaggio("Attrezzo inesistente");
	      }
	      }else
	    	  io.mostraMessaggio("Non ci sono attrezzi nella stanza");
	}

	/**
	 * Cerca di posare un attrezzo
	 * se la borssa è vuota o se l'attrezzo non è presente nella borsa stampa un messaggio di errore
	 * altrimenti aggiunge l'attrezzo nella stanza corrente e lo rimuove dalla borsa stampandone il contenuto aggiornato
	 * @param nomeAttrezzo
	 */
	private void posa(String nomeAttrezzo) {
	    if(nomeAttrezzo==null)
	        io.mostraMessaggio("Quale Attrezzo vuoi posare?");
	    if(this.partita.getGiocatore().getBorsa().getAttrezzi()[0]!=null) {
	      if(this.partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)==true) {
	          this.partita.getLabirinto().getStanzaCorrente().addAttrezzo(this.partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo));
	          this.partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
	          io.mostraMessaggio(this.partita.getGiocatore().getBorsa().toString());
	      } else {
	          io.mostraMessaggio("Attrezzo inesistente");
	      }
	    } else
	    	io.mostraMessaggio("Borsa vuota");
	}

	/**
	 * Comando "Fine".
	 */
	private void fine() {
		io.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	public static void main(String[] argc) {
		IOConsole console = new IOConsole();
		DiaDia gioco = new DiaDia(console);
		gioco.gioca();
	}
}
