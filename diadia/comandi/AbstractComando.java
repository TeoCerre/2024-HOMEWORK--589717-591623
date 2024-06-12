package diadia.comandi;

import diadia.IO;
import diadia.Partita;

/**

 * Questa classe modella un comando astratto che fornisce i metodi 
 * utili per tutti i comandi successivi.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * @author  docente di POO,Matteo Cerretani,Daniele Granato
 * @version 4.0
 */

public abstract class AbstractComando implements Comando{
	private IO io;
	private String parametro;
	private final static String nome = "AbstractComando";
	
	abstract public void esegui(Partita partita);
	@Override
	public String getParametro() {
		return this.parametro;
	}
	
	@Override
	public void setParametro(String parametro) {
		this.parametro  = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	public IO getIo() {
		return io;
	}
	
	@Override
	public String getNome() {
		return nome;
	}
}
