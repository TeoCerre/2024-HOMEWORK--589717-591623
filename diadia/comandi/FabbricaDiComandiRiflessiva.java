package diadia.comandi;

import java.util.Scanner;

import diadia.IO;
/**
 * Classe che costruisce i comandi implementando
 * l'interfaccia FabbricaDiComandi
 *
 * @author  Matteo Cerretani,Daniele Granato 
 *          
 * @version 4.0
 **/
public class FabbricaDiComandiRiflessiva implements FabbricaDiComandi {

    IO io;

    public FabbricaDiComandiRiflessiva(IO io) {
        this.io = io;
    }
    
    public Comando costruisciComando(String istruzione) throws Exception{
    	Scanner scannerDiParole = new Scanner(istruzione); // es. ‘vai sud’
		String nomeComando = null; // es. ‘vai’
		String parametro = null; // es. ‘sud’
		Comando comando = null;
		
		if (scannerDiParole.hasNext())
			nomeComando = scannerDiParole.next();
		if (scannerDiParole.hasNext())
			parametro = scannerDiParole.next();
		StringBuilder nomeClasse = new StringBuilder("diadia.comandi.Comando");
		nomeClasse.append( Character.toUpperCase(nomeComando.charAt(0)) );
		nomeClasse.append( nomeComando.substring(1) ) ;
		comando = (Comando)Class.forName(nomeClasse.toString()).newInstance();
		comando.setParametro(parametro);
		comando.setIO(io);
		return comando;
	}	
}
