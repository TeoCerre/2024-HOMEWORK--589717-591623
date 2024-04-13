package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;

class LabirintoTest {
	Labirinto l=new Labirinto();
	Stanza biblioteca=new Stanza("biblioteca");
	Stanza atrio=new Stanza("atrio");
	@Test
	public void testGetStanzaVincente() {
		l.creaStanze();
		assertEquals("Biblioteca", l.getStanzaVincente().getNome());
	}
	@Test
	public void testGetStanzaVincenteNonNulla() {
		l.creaStanze();
	    assertNotNull(l.getStanzaVincente());
	}
	@Test
	public void testGetStanzaCorrente() {
		l.creaStanze();
		assertEquals("Atrio", l.getStanzaCorrente().getNome());
	}
	@Test
	public void testGetStanzaCorrenteNonNullaDopoCreazione() {
	    l.creaStanze();
	    assertNotNull(l.getStanzaCorrente());
	}
	@Test
	public void testSetStanzaCorrente() {
		l.setStanzaCorrente(atrio);
		assertEquals(atrio, l.getStanzaCorrente());
	}
	@Test
	public void testGetStanzaCorrenteCambiataNonNulla() {
	    l.creaStanze();
	    Stanza nuovaStanza = new Stanza("Stanza");
	    l.setStanzaCorrente(nuovaStanza);
	    assertNotNull(l.getStanzaCorrente());
	}
	@Test
	public void testSetStanzaCorrenteCambiata() {
	    l.creaStanze();
	    Stanza nuovaStanza = new Stanza("Nuova Stanza");
	    l.setStanzaCorrente(nuovaStanza);
	    assertEquals(nuovaStanza, l.getStanzaCorrente());
	}

}
