package diadia.comandi;

import diadia.Partita;
import diadia.ambienti.Direzione;
import diadia.ambienti.Stanza;

/**

 * Questa classe modella il comando vai
 * ovvero il comando che permette di spostarsi da una stanza all'altra.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoVai extends AbstractComando {
    //private String direzione;
    private final static String nome = "vai";

    /*public ComandoVai(String direzione) {
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

    	if(this.getParametro() == null) {
    		this.getIo().mostraMessaggio("Dove vuoi andare? (Devi specificare una direzione)");
    		return;
    	}

    	prossimaStanza = stanzaCorrente.getStanzaAdiacente(Direzione.valueOf(this.getParametro()));

    	if(prossimaStanza == null) {
    		this.getIo().mostraMessaggio("DIREZIONE INESISTENTE");
    		return;
    	}

    	partita.getLabirinto().setStanzaCorrente(prossimaStanza);
    	this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getNome());
    	partita.getGiocatore().setCFU(partita.getGiocatore().getCFU() - 1);
    	this.getIo().mostraMessaggio("CFU rimasti:" + partita.getGiocatore().getCFU());
    }
    /*
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
	*/
	@Override
	public String getNome() {
		return nome;
	}

}
