package diadia.comandi;

import diadia.IO;
import diadia.Partita;

/**

 * Questa classe modella un comando.
 * @author  docente di POO,Matteo Cerretani,Daniele Granato
 * @version 4.0
 */

public interface Comando {
	
	public void esegui(Partita partita);
	
	public void setParametro(String param) ;
	
	public String getParametro();
	
	public String getNome();
	
	public void setIO(IO io);
		
}
