package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.giocatore.Giocatore;

class GiocatoreTest {
	Giocatore g=new Giocatore();
	@Test
	public void testGetCFU() {
		assertEquals(20,g.getCFU());
	}
	@Test
	public void testSetCFU() {
		g.setCFU(0);
		assertEquals(0,g.getCFU());
	}
	@Test
	public void testSetCFUComePrima() {
	    g.setCFU(20);
	    assertEquals(20, g.getCFU());
	}
	@Test
	public void testGetBorsaNotNull() {
		assertNotNull(g.getBorsa());
	}
	@Test
	public void testGetBorsaVuota() {
	    assertTrue(g.getBorsa().isEmpty());
	}
	@Test
	public void testGetBorsaEsistenteDopoCreazione() {
	    assertNotNull(g.getBorsa());
	}
}
