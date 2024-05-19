package test;

import java.util.List;

import diadia.DiaDia;
import diadia.IOSimulator;
import diadia.ambienti.Labirinto;
import diadia.ambienti.LabirintoBuilder;
import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

public class SimulatorePartite {
	public static IOSimulator creaEGiocaPartita(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaPartenza("Atrio")
				.addAttrezzo("bastone", 4)
				.addStanzaVincente("Biblioteca")
				.collegaStanze("nord","Atrio", "Biblioteca")
				.collegaStanze("sud","Biblioteca", "Atrio")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	public static IOSimulator creaEGiocaPartitaDifficile(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaPartenza("Atrio")
				.addAttrezzo("bastone", 3)
				.addStanzaVincente("Biblioteca")
				.collegaStanze("nord","Atrio", "Biblioteca")
				.collegaStanze("sud","Biblioteca", "Atrio")
				.addStanzaNormale("Bagno")
				.collegaStanze("sud","Bagno", "Atrio")
				.collegaStanze("nord","Atrio", "Bagno")
				.addStanzaNormale("Ripostiglio")
				.collegaStanze("ovest","Ripostiglio", "Atrio")
				.collegaStanze("est","Atrio", "Ripostiglio")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, labirinto);
		gioco.gioca();
		return io;
	}
	public static IOSimulator creaEGIocaUnaStanza(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto singola = Labirinto.newBuilder()
				.addStanzaPartenza("biblioteca") 
				.addStanzaVincente("biblioteca") 
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, singola);
		gioco.gioca();
		return io;
	}
	
	
	public static IOSimulator creaEGiocaDueStanze(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto bilocale = Labirinto.newBuilder()
				.addStanzaPartenza("biblioteca")
				.addStanzaVincente("camera")
				.addAttrezzo("letto",10) 
				.collegaStanze("nord","biblioteca", "camera")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, bilocale);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator creaEGiocaTreStanze(List<String> daLeggere) {
		IOSimulator io = new IOSimulator(daLeggere);
		Labirinto trilocale = new LabirintoBuilder()
				.addStanzaPartenza("biblioteca")
				.addStanzaNormale("bagno")
				.addAttrezzo("pentola",1) 
				.addStanzaVincente("camera")
				.collegaStanze("nord","biblioteca", "bagno")
				.collegaStanze("ovest","bagno", "camera")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io, trilocale);
		gioco.gioca();
		return io;
	}

	public static Attrezzo creaAttrezzoEAggiugniAStanza(Stanza daRiempire, String nomeAttrezzo, int peso) {
		Attrezzo attrezzo = new Attrezzo(nomeAttrezzo, peso);
		daRiempire.addAttrezzo(attrezzo);
		return attrezzo;
	}

}
