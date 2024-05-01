package diadia.comandi;
import java.util.Scanner;

/**
 * Classe che costruisce i comandi sovrascrivendo il metodo costruisciComando 
 * dell'interfaccia FabbricaDiComandi
 *
 * @author  Matteo Cerretani,Daniele Granato 
 *          
 * @version 2.0
 */
public class FabbricaDiComandiFisarmonica implements FabbricaDiComandi {
	@Override
	public Comando costruisciComando(String istruzione) {
		Scanner scannerDiParole = new Scanner(istruzione);
		String nomeComando = null;
		String parametro = null;
		Comando comando = null;
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next(); // prima parola: nome del comando
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next(); // seconda parola: eventuale parametro
		if (nomeComando == null)
			comando = new ComandoNonValido();
		else if (nomeComando.equals("vai"))
			comando = new ComandoVai(parametro);
		else if (nomeComando.equals("prendi"))
			comando = new ComandoPrendi(parametro);
		else if (nomeComando.equals("posa"))
			comando = new ComandoPosa(parametro);
		else if (nomeComando.equals("aiuto"))
			comando = new ComandoAiuto();
		else if (nomeComando.equals("fine"))
			comando = new ComandoFine();
		else if (nomeComando.equals("guarda"))
			comando = new ComandoGuarda(parametro);
		else comando = new ComandoNonValido();
		comando.setParametro(parametro);
		return comando;
}
}
