package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;
import diadia.giocatore.Borsa;

class BorsaTest {
	
	Borsa b=new Borsa();
	Attrezzo chiave=new Attrezzo("chiave",0);
	Attrezzo martello=new Attrezzo("martello",5);
	Attrezzo scala=new Attrezzo("scala",15);
	
	@Test
	public void testAddAttrezzoMinoreDieci() {
		assertTrue(b.addAttrezzo(chiave));
	}
	@Test
	public void testAddAttrezzoMaggioreDieci() {
		assertFalse(b.addAttrezzo(scala));
	}
	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(chiave);
		assertEquals(chiave,b.getAttrezzo("chiave"));
	}
	@Test
	public void testPesoMax() {
		assertEquals(10,b.getPesoMax());
	}
	@Test
	public void testHasAttrezzo() {
		b.addAttrezzo(martello);
		assertTrue(b.hasAttrezzo("martello"));
	}
	@Test
	public void testHasAttrezzoInesistente() {
	    assertFalse(b.hasAttrezzo("spada"));
	}
	@Test
	public void testHasAttrezzoPesoModificato() {
	    b.addAttrezzo(new Attrezzo("martello", 8));
	    assertTrue(b.hasAttrezzo("martello"));
	}
}
