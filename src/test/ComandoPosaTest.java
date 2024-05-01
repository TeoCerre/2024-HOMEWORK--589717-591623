package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;
import diadia.comandi.Comando;
import diadia.comandi.ComandoPosa;

public class ComandoPosaTest {

	private Partita partita= new Partita();
	private Attrezzo attrezzo= new Attrezzo("chiave", 2);;
	private Comando comando= new ComandoPosa();

	
	@Test
	public void testAttrezzoPosatoInesistente() {
		comando.setParametro("scala");
		comando.esegui(partita);
		assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("scala"));
	}
	
	@Test
	public void testAttrezzoPosato() {
		partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
		comando.setParametro("chiave");
		comando.esegui(partita);
		assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("chiave"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("chiave"));
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

