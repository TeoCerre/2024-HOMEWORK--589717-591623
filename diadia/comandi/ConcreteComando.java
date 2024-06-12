package diadia.comandi;

import diadia.Partita;

/**

 * Questa classe modella un comando concreto
 * in modo di poterli creare per effettuare i test
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ConcreteComando extends AbstractComando{

	public final static String MESSAGGIO= "Grazie di aver giocato!";

	@Override
	public void esegui(Partita partita) {
		partita.setFinita();
	}

	

}