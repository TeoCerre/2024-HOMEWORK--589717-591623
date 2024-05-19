package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.LabirintoBuilder;
import diadia.attrezzi.Attrezzo;
import diadia.comandi.Comando;
import diadia.comandi.ComandoPosa;

public class ComandoPosaTest {
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaPartenza("Atrio")
			.addAttrezzo("seghetto", 3)
			.addStanzaVincente("Biblioteca")
			.collegaStanze("nord","Atrio", "Biblioteca")
			.getLabirinto();
	private Partita partita= new Partita(labirinto);
	private Attrezzo attrezzo= new Attrezzo("martello", 2);;
	private Comando comando= new ComandoPosa();
	
	@Test
	public void testAttrezzoPosatoInesistente() {
		comando.setParametro("scala");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("scala"));
	}
	
	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("seghetto"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
	}
	
	@Test
	public void testStanzaPiena() {
		for(int i= 0; i<10;i++) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("attrezzo"+i, 0));
		}
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
	}

}

