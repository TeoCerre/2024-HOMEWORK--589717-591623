package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;
import diadia.FormatoFileNonValidoException;

class LabirintoTest{
	Labirinto l;
	Stanza biblioteca=new Stanza("biblioteca");
	Stanza atrio=new Stanza("atrio");
	@BeforeEach
	public void setUp() throws FileNotFoundException, FormatoFileNonValidoException {
		 l = Labirinto.newBuilder("test1.txt").getLabirinto();
		 		/*Labirinto.newBuilder()
				.addStanzaIniziale("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("Atrio", "Biblioteca", "nord")
				.getLabirinto();*/
		
		biblioteca = new Stanza("Biblioteca");
		atrio = new Stanza("atrio");
		
	}

	@Test
	public void testGetStanzaVincente() {
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}
	@Test
	public void testGetStanzaVincenteNonNulla() {
	    assertNotNull(l.getStanzaVincente());
	}
	@Test
	public void testGetStanzaCorrente() {
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}
	@Test
	public void testGetStanzaCorrenteNonNullaDopoCreazione() {
	    assertNotNull(l.getStanzaCorrente());
	}
	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(atrio);
		assertEquals(atrio, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrenteCambiataNonNulla() {
	    Stanza nuovaStanza = new Stanza("Stanza");
	    l.setStanzaCorrente(nuovaStanza);
	    assertNotNull(l.getStanzaCorrente());
	}
	@Test
	public void testSetStanzaCorrenteCambiata() {
	    Stanza nuovaStanza = new Stanza("Nuova Stanza");
	    l.setStanzaCorrente(nuovaStanza);
	    assertEquals(nuovaStanza, l.getStanzaCorrente());
	}

}
