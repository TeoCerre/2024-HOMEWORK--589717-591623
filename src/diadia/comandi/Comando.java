package diadia.comandi;

import diadia.IO;
import diadia.Partita;

/**

 * Questa classe modella un comando.
 * Un comando consiste al piu' di due parole:
 * il nome del comando ed un parametro
 * su cui si applica il comando.
 * @author  docente di POO,Matteo Cerretani,Daniele Granato
 * @version 2.0
 */

public interface Comando {
	
	public void esegui(Partita partita);
	
	public void setParametro(String param) ;
	
	public String getParametro();
	
	public String getNome();
	
	public void setIO(IO io);
		
}
