package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
/**

 * Questa classe modella il comando fine
 * ovvero il comando che stampa il messaggio di partita finita all'utente.
 * @author Matteo Cerretani,Daniele Granato
 * @version 3.0
*/
public class ComandoFine implements Comando {
	private IOConsole IO = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio("\n\nGAME OVER\nGrazie di aver giocato!");  // si desidera smettere
	}

	@Override
	public void setParametro(String param) {

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
