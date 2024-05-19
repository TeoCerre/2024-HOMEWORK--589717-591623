package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Stanza;

/**

 * Questa classe modella il comando vai
 * ovvero il comando che permette di spostarsi da una stanza all'altra.
 * @author Matteo Cerretani,Daniele Granato
 * @version 3.0
*/

public class ComandoVai implements Comando {
    private String direzione;
    private IOConsole IO = new IOConsole();

    public ComandoVai(String direzione) {
        this.direzione = direzione;
    }

    public ComandoVai() {
		
	}
	/**
	 * Cerca di andare in una direzione. Se c'e' una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
    @Override
    public void esegui(Partita partita) {
    	Stanza stanzaCorrente = partita.getLabirinto().getStanzaCorrente();
    	Stanza prossimaStanza = null;

    	if(direzione == null) {
    		IO.mostraMessaggio("Dove vuoi andare? (Devi specificare una direzione)");
    		return;
    	}

    	prossimaStanza = stanzaCorrente.getStanzaAdiacente(this.direzione);

    	if(prossimaStanza == null) {
    		IO.mostraMessaggio("DIREZIONE INESISTENTE");
    		return;
    	}

    	partita.getLabirinto().setStanzaCorrente(prossimaStanza);
    	IO.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
    	partita.getGiocatore().setCFU(partita.getGiocatore().getCFU() - 1);
    	IO.mostraMessaggio("CFU rimasti:" + partita.getGiocatore().getCFU());
    }

    @Override
    public void setParametro(String param) {
    	this.direzione = param;
    }
    
    @Override
	public void setIO(IO io) {
		
	}
    
    @Override
	public String getParametro() {
		return null;
	}

	@Override
	public String getNome() {
		return null;
	}

}
