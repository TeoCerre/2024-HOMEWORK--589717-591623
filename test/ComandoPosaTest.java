package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.IO;
import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.attrezzi.Attrezzo;
import diadia.comandi.Comando;
import diadia.comandi.ComandoPosa;

public class ComandoPosaTest{
	Labirinto labirinto ;
	private Partita partita;
	private Attrezzo attrezzo;
	private Comando comando;
	private IO io;
	
	@BeforeEach
	public void setUp() throws Exception {
		labirinto = Labirinto.newBuilder("test1.txt").getLabirinto();
		/*new LabirintoBuilder()
		.addStanzaPartenza("Atrio")
		.addAttrezzo("seghetto", 3)
		.addStanzaVincente("Biblioteca")
		.collegaStanze("nord","Atrio", "Biblioteca")
		.getLabirinto();*/
		partita= new Partita(labirinto);
		attrezzo= new Attrezzo("martello", 2);;
		comando= new ComandoPosa();
		io = new IOConsole(new Scanner(System.in));
		comando.setIO(io);
	}
	@Test
	public void testAttrezzoPosatoInesistente() {
		comando.setParametro("scala");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("scala"));
	}
	
	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("martello");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("martello"));
	}
	
	@Test
	public void testStanzaPiena() {
		for(int i= 0; i<10;i++) {
			partita.getLabirinto().getStanzaCorrente().addAttrezzo(new Attrezzo("attrezzo"+i, 0));
		}
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
	}

}

