package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.ambienti.Stanza;
import diadia.comandi.Comando;
import diadia.comandi.ComandoVai;
import diadia.ambienti.Direzione;

class ComandoVaiTest {
	private Stanza s1;
	private Stanza s2;
	private Comando vai;
	List<String> righeDaLeggere;
	List<String> righeDaLeggere2;
	Labirinto labirinto;
	Labirinto labirinto2;
	private Partita p;
	private IO io;
	@BeforeEach
	public void setUp() throws Exception {
		s1= new Stanza("Atrio");
		s2= new Stanza("Biblioteca");
		vai= new ComandoVai();
		labirinto= Labirinto.newBuilder("test1.txt").getLabirinto();
				/*.addStanzaPartenza("Atrio")
				.addAttrezzo("martello", 3)
				.addStanzaVincente("Biblioteca")
				.collegaStanze("nord","Atrio", "Biblioteca")
				.getLabirinto();;*/
		p= new Partita(labirinto);
		io = new IOConsole(new Scanner(System.in));
		righeDaLeggere = new ArrayList<>();
		righeDaLeggere2 = new ArrayList<>();
		vai.setIO(io);
	}
	@Test
	public void testVaiNull() {
		p.getLabirinto().setStanzaCorrente(s1);
		vai.esegui(p);
		assertEquals(s1,p.getLabirinto().getStanzaCorrente());
	}
	@Test
	public void testVaiDirezioneCorretta() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		vai.setParametro("sud");
		vai.esegui(p);
		assertEquals(s2, p.getLabirinto().getStanzaCorrente());
	}
	
	@Test
	public void testVaiDirezioneNulla() {
		p.getLabirinto().setStanzaCorrente(s1);
		s1.impostaStanzaAdiacente(Direzione.sud, s2);
		vai.setParametro("nord");
		vai.esegui(p);
		assertNotEquals(s2, p.getLabirinto().getStanzaCorrente());
	}

}
