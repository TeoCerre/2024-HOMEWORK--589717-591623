package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.FormatoFileNonValidoException;
import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;

public class PartitaTest {
	Labirinto labirinto;
	Partita p;
	Stanza s;

	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 labirinto = Labirinto.newBuilder("test1.txt").getLabirinto();
				/*.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();*/
		 p = new Partita(labirinto);
		 s = new Stanza("Stanza");
	}

	

	@Test
	public void testPartitaVinta() {
		p.getLabirinto().setStanzaCorrente(p.getLabirinto().getStanzaVincente());
	    assertTrue(p.vinta());
	}
	@Test
	public void testPartitaNonVinta() {
	    assertFalse(p.vinta());
	}
	@Test
	public void testPartitaNonVintaAltraStanza() {
	    Stanza stanza2 = new Stanza("Stanza 2");
	    p.getLabirinto().setStanzaCorrente(stanza2);
	    assertFalse(p.vinta());
	}
	@Test
	public void testIsNotFinita() {
		assertFalse(p.isFinita());
	}
	@Test
	public void testIsFinitaSenzaCfu() {
		p.getGiocatore().setCFU(0);
		assertTrue(p.isFinita());
	}
	@Test
	public void testIsFinitaVinta() {
		p.getLabirinto().setStanzaCorrente(p.getLabirinto().getStanzaVincente());
		assertTrue(p.isFinita());
	}

}
