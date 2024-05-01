package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.Partita;
import diadia.ambienti.Stanza;

class PartitaTest {
	Partita p = new Partita();
	Stanza s = new Stanza("Stanza");
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
