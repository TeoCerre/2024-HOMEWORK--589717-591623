package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Direzione;
import diadia.ambienti.Stanza;
import diadia.attrezzi.Attrezzo;

class StanzaTest {
	
	Stanza s1=new Stanza("s1");
	Stanza s2=new Stanza("s2");
	Attrezzo s=new Attrezzo("spada",10);
	
	@Test
	public void testImpostaStanzaAdiacente() {
		s1.impostaStanzaAdiacente(Direzione.sud,s2);
		assertEquals(s2,s1.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test
	public void testImpostaStanzaAdiacenteEsistente() {
	    s1.impostaStanzaAdiacente(Direzione.sud, s2);
	    s1.impostaStanzaAdiacente(Direzione.sud, new Stanza("Nuova Stanza"));
	    assertEquals("Nuova Stanza", s1.getStanzaAdiacente(Direzione.sud).getNome());
	}
	
	@Test
	public void testImpostaStanzaAdiacenteNonNulla() {
	    s1.impostaStanzaAdiacente(Direzione.ovest, new Stanza("Ovest"));
	    assertNotNull(s1.getStanzaAdiacente(Direzione.ovest));
	}
	
	@Test
	public void testGetStanzaAdiacente() {
		assertNull(s1.getStanzaAdiacente(Direzione.sud));
	}
	
	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(s));
	}
}