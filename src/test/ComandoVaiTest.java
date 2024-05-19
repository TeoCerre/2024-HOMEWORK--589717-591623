package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;
import diadia.comandi.Comando;
import diadia.comandi.ComandoVai;

class ComandoVaiTest {
	private Stanza s1= new Stanza("N11");
	private Stanza s2= new Stanza("N12");
	private Comando vai= new ComandoVai();
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto= Labirinto.newBuilder()
			.addStanzaPartenza("Atrio")
			.addAttrezzo("martello", 3)
			.addStanzaVincente("Biblioteca")
			.collegaStanze("nord","Atrio", "Biblioteca")
			.getLabirinto();;
	Labirinto labirinto2;
	private Partita p= new Partita(labirinto);
	
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
