package diadia;
import java.util.Scanner;

/**

*Questa classe riorganizzia completamente la gestione dell’I/O,
*disaccoppiando il gioco dall’uso diretto e pervasivo di
*System.out/System.in,
*
@author  Matteo Cerretani,Daniele Granato
@version 1.0
*/
public class IOConsole {
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
}
