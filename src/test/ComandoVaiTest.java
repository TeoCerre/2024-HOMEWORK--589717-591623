package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.Partita;
import diadia.ambienti.Stanza;
import diadia.comandi.Comando;
import diadia.comandi.ComandoVai;

class ComandoVaiTest {
	private Stanza s1= new Stanza("N11");
	private Stanza s2= new Stanza("N12");
	private Comando vai= new ComandoVai();
	private Partita p= new Partita();
	
	
	
	@Test
	public void testVaiNull() {
		p.getLabirinto().setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1,p.getLabirinto().getStanzaCorrente());
	}
	@Test
	public void testVaiDirezioneCorretta() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("nord-est", s2);
		vai.setParametro("nord-est");
		vai.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneNulla() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente("sud-est", s2);
		vai.setParametro("in fondo a destra");
		vai.esegui(p);
		assertNotEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

}
