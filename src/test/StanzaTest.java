package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

class StanzaTest {
	Stanza s1=new Stanza("s1");
	Stanza s2=new Stanza("s2");
	Attrezzo s=new Attrezzo("spada",10);
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente("sud",s2);
		assertEquals(s2,s1.getStanzaAdiacente("sud"));
	}
	@Test
	public void testImpostaStanzaAdiacenteEsistente() {
	    s1.impostaStanzaAdiacente("sud", s2);
	    s1.impostaStanzaAdiacente("sud", new Stanza("Nuova Stanza"));
	    assertEquals("Nuova Stanza", s1.getStanzaAdiacente("sud").getNome());
	}
	@Test
	public void testImpostaStanzaAdiacenteNonNulla() {
	    s1.impostaStanzaAdiacente("ovest", new Stanza("Ovest"));
	    assertNotNull(s1.getStanzaAdiacente("ovest"));
	}
	@Test
	public void testRimozioneAttrezzoEsistente() {
	    s1.addAttrezzo(s);
	    assertTrue(s1.removeAttrezzo("spada"));
	    assertNull(s1.getAttrezzo("spada"));
	}
	@Test
	public void testRimozioneAttrezzoInesistente() {
	    assertFalse(s1.removeAttrezzo("Scudo"));
	}
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente("sud"));
	}
	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(s));
	}
}
