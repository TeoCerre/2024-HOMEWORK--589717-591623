package diadia;
import java.util.Scanner;

/**

*Questa classe riorganizzia completamente la gestione dell’I/O,
*disaccoppiando il gioco dall’uso diretto e pervasivo di
*System.out/System.in,
*
@author  Matteo Cerretani,Daniele Granato
@version 4.0
*/
public class IOConsole implements IO{
	Scanner scannerDiLinee;
	public IOConsole(Scanner scanner) {
		this.scannerDiLinee = scanner;
	}
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	public String leggiRiga() {
		scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
		//scannerDiLinee.close();
		return riga;
	}
	
}
