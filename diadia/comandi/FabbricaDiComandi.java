package diadia.comandi;

/**
 * Interfaccia FabbricaDiComandiche fornisce il metodo costruisciCOmando
 *
 * @author  Matteo Cerretani,Daniele Granato 
 *          
 * @version 4.0
 */
public interface FabbricaDiComandi {
	public Comando costruisciComando(String istruzione) throws Exception;
}
