package diadia.comandi;

import diadia.Partita;

/**

 * Questa classe modella il comando non valido
 * ovvero il comando che stampa il messaggio di errore se il comando non è valido.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoNonValido extends AbstractComando{


	private final static String nome = "non valido";

	@Override
	public void esegui(Partita partita) {
		this.getIo().mostraMessaggio("Comando sconosciuto");
	}
	/*
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
	*/
	@Override
	public String getNome() {
		return nome;
	}

}
