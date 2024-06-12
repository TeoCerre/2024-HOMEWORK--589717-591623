package diadia;
import java.util.Scanner;

import diadia.ambienti.Labirinto;
import diadia.comandi.Comando;
import diadia.comandi.FabbricaDiComandiRiflessiva;
/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il letodo gioca
 *
 * Questa e' la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO,Matteo Cerretani,Daniele Granato 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 *          
 * @version 4.0
 */

public class DiaDia {

	static final private String MESSAGGio_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.";
	

	private Partita partita;
	private IO io;

	public DiaDia(IO console,Labirinto labirinto) {
		this.io = console;
		this.partita = new Partita(labirinto);
	}

	public void gioca() throws Exception{
		String istruzione;
		//Scanner scannerdiLinee;

		io.mostraMessaggio(MESSAGGio_BENVENUTO);
				
		do {	
			istruzione = io.leggiRiga();
		}while (!processaIstruzione(istruzione));
	}   



	/**
	 * Processa una istruzione 
	 *
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione) throws Exception {
		Comando comandoDaEseguire;
		FabbricaDiComandiRiflessiva factory = new FabbricaDiComandiRiflessiva(this.io);
		try {
			comandoDaEseguire = factory.costruisciComando(istruzione);
		} catch (ClassNotFoundException cne) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		} catch (NullPointerException npe) {
			comandoDaEseguire = factory.costruisciComando("NonValido");
		}
		comandoDaEseguire.esegui(this.partita);
		if (this.partita.vinta())
			io.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			io.mostraMessaggio("Hai esaurito i CFU...");
		return this.partita.isFinita();
	}

	public static void main(String[] argc) throws Exception{
		Scanner scanner = new Scanner(System.in);
		IO console = new IOConsole(scanner);
		Labirinto labirinto = Labirinto.newBuilder("labirinto.txt").getLabirinto();
		/*Labirinto labirinto = new LabirintoBuilder()
										.addStanzaPartenza("Atrio")
										.addAttrezzo("tubo", 5)
										.addStanzaNormale("N5")
										.addAttrezzo("lanterna", 6)
										.addStanzaBloccata("Scale","chiave","ovest")
										.addAttrezzo("bastone", 2)
										.addStanzaNormale("Bagno")
										.addAttrezzo("chiave",1)
										.addStanzaNormale("Mensa")
										.addStanzaVincente("Biblioteca")
										.collegaStanze("nord","Atrio","Scale")
										.collegaStanze("ovest","Scale","Biblioteca")
										.collegaStanze("est","Atrio","N5")
										.collegaStanze("nord","Mensa","Atrio")
										.collegaStanze("sud", "N5","Bagno")
										.collegaStanze("ovest","Bagno","Mensa")
										.getLabirinto();*/
		DiaDia gioco = new DiaDia(console, labirinto);
		gioco.gioca();
		scanner.close();
	}
}
