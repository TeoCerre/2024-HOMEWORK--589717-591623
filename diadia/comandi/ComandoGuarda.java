package diadia.comandi;

import diadia.Partita;

/**

 * Questa classe modella il comando guarda
 * ovvero il comando che mostra il contenuto della borsa o della stanza.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoGuarda extends AbstractComando{
	private final static String nome = "guarda";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		this.getIo().mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		this.getIo().mostraMessaggio("Hai ancora: "+partita.getGiocatore().getCFU()+ "CFU");
		

	}
	/*
	@Override
	public void setParametro(String param) {
		this.cosaGuardare = param;
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
