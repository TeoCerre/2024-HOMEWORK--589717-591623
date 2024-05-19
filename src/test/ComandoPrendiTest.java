package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.LabirintoBuilder;
import diadia.attrezzi.Attrezzo;
import diadia.comandi.Comando;
import diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
	Labirinto labirinto = new LabirintoBuilder()
			.addStanzaPartenza("Atrio")
			.addAttrezzo("martello", 3)
			.addStanzaVincente("Biblioteca")
			.collegaStanze("nord","Atrio", "Biblioteca")
			.getLabirinto();
	private Partita partita= new Partita(labirinto);
	private Attrezzo attrezzo= new Attrezzo("chiave", 2);
	private Attrezzo attrezzo2=new Attrezzo("martello", 11);
	private Comando comando=new ComandoPrendi();

	
	@Test
	public void testAttrezzoPreso() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
	}
	
	@Test
	public void testAttrezzoPesante() {
		partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo2);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo2.getNome()));
	}
	
	@Test
	public void testAttrezzoInesistente() {
		comando.setParametro("bastone");
		comando.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("bastone"));
	}

}
