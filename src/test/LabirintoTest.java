package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;

class LabirintoTest {
	Labirinto l= Labirinto.newBuilder().addStanzaPartenza("Atrio")
			.addAttrezzo("martello", 3)
			.addStanzaVincente("Biblioteca")
			.collegaStanze("nord","Atrio", "Biblioteca")
			.getLabirinto();
	Stanza biblioteca=new Stanza("biblioteca");
	Stanza atrio=new Stanza("atrio");
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
