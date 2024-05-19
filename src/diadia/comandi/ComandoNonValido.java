package diadia.comandi;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;

/**

 * Questa classe modella il comando non valido
 * ovvero il comando che stampa il messaggio di errore se il comando non è valido.
 * @author Matteo Cerretani,Daniele Granato
 * @version 3.0
*/

public class ComandoNonValido implements Comando{


	private IOConsole IO = new IOConsole();

	@Override
	public void esegui(Partita partita) {
		IO.mostraMessaggio("Comando sconosciuto");
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
