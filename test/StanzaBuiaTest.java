package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.StanzaBuia;
import diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	private StanzaBuia stanza = new StanzaBuia("StanzaBuia", "torcia");
	private Attrezzo torcia= new Attrezzo("torcia", 1);

	@Test
	public void testGetDescrizioneAttrezzoPresente() {
		stanza.addAttrezzo(torcia);
		assertEquals(stanza.toString(), stanza.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneAttrezzoNonPresente() {
		assertEquals("qui c'è un buio pesto", stanza.getDescrizione());
	}
}
