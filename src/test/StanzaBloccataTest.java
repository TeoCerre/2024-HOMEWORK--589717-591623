package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.ambienti.Stanza;
import diadia.ambienti.StanzaBloccata;
import diadia.attrezzi.Attrezzo;

public class StanzaBloccataTest {
	private StanzaBloccata stanzabloccata= new StanzaBloccata("StanzaBloccata", "nord", "piede di porco");
	private Stanza stanza= new Stanza("Stanza");
	private Attrezzo attrezzo= new Attrezzo("piede di porco", 2);
	
	@Test
	public void testGetDescrizioneDirezioneDisponibile() {
		stanzabloccata.addAttrezzo(attrezzo);
		assertEquals(stanzabloccata.toString(), stanzabloccata.getDescrizione());
	}
	
	@Test
	public void testGetDescrizioneDirezioneBloccata() {
		assertEquals("Stanza bloccata nella direzione: nord"+"\nLiberati dell'attrezzo: piede di porco", stanzabloccata.getDescrizione());
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneBloccata() {
		assertEquals(stanzabloccata, stanzabloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	public void testGetStanzaAdiacenteDirezioneDisponibile() {
		stanzabloccata.impostaStanzaAdiacente("nord", stanza);
		stanzabloccata.addAttrezzo(attrezzo);
		assertEquals(stanza, stanzabloccata.getStanzaAdiacente("nord"));
		
	}

}
