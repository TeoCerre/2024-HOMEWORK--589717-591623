package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

/**

 * Questa classe modella il comando guarda
 * ovvero il comando che mostra il contenuto della borsa o della stanza.
 * @author Matteo Cerretani,Daniele Granato
 * @version 2.0
*/

public class ComandoGuarda implements Comando{
	private String cosaGuardare;
	private IOConsole IO = new IOConsole();

	public ComandoGuarda(String cosaGuardare) {
		this.cosaGuardare = cosaGuardare;
	}

	@Override
	public void esegui(Partita partita) {
		if(this.cosaGuardare == null) {
			IO.mostraMessaggio("Cosa vuoi guardare ? (Devi specificare se Stanza o Borsa)");
			return;
		}else if(this.cosaGuardare.equals("borsa") || this.cosaGuardare.equals("Borsa")) {
			IO.mostraMessaggio(partita.getGiocatore().getBorsa().toString());
		}else if(this.cosaGuardare.equals("stanza") || this.cosaGuardare.equals("Stanza")) {
			IO.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getDescrizione());
		} else IO.mostraMessaggio("COMANDO INESISTENTE");
	}

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
}
