package diadia.comandi;

import diadia.IO;
import diadia.Partita;

/**

 * Questa classe modella il comando saluta
 * ovvero il comando che permette di salutare
 * i personaggi nelle stanze.
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoSaluta extends AbstractComando {
	private final static String nome= "saluta";
	private IO io;
	@Override
	public void esegui(Partita partita) {
		if(partita.getLabirinto().getStanzaCorrente().getPersonaggio()!=null)
			io.mostraMessaggio(partita.getLabirinto().getStanzaCorrente().getPersonaggio().saluta());
		else 
			io.mostraMessaggio("Non c'e' alcun personaggio in questa stanza!");
	}
	
	@Override
	public void setIO(IO io) {
		this.io = io;
	}
	
	@Override
	public String getNome() {
		return nome;
	}

}
