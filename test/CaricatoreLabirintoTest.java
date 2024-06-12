package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.StringReader;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diadia.CaricatoreLabirinto;
import diadia.FormatoFileNonValidoException;
import diadia.attrezzi.Attrezzo;

public class CaricatoreLabirintoTest {

	private final String labirinto1 = 
			"Stanze:biblioteca\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:biblioteca\n"+
			"Vincente:biblioteca\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:\n"+
			"Uscite:\n";

	private final String labirinto2 = 
			"Stanze:Stanza2,Stanza1\n"+
			"Magica:\n"+
			"Buia:\n"+
			"Bloccata:\n"+
			"Inizio:Stanza2\n"+
			"Vincente:Stanza1\n"+
			"Mago:\n"+
			"Cane:\n"+
			"Strega:\n"+
			"Attrezzi:chiodo 3 Stanza2\n"+
			"Uscite:\n";
	
	private CaricatoreLabirinto cl;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	@Test
	public void testlabirinto2Attrezzo() throws FormatoFileNonValidoException, FileNotFoundException {
		cl = new CaricatoreLabirinto(new StringReader(labirinto2));
		cl.carica();
		Attrezzo expected = new Attrezzo("chiodo", 3);
		assertEquals(expected.getNome(), this.cl.getStanzaIniziale().getAttrezzo("chiodo").getNome());
	}
	
	@Test
	public void testlabirinto1() throws FormatoFileNonValidoException, FileNotFoundException {
		cl = new CaricatoreLabirinto(new StringReader(labirinto1));
		cl.carica();
		assertEquals("biblioteca", this.cl.getStanzaIniziale().getNome());
		assertEquals("biblioteca", this.cl.getStanzaVincente().getNome());
	}
	
	@Test
	public void testlabirinto2() throws FormatoFileNonValidoException, FileNotFoundException {
		cl = new CaricatoreLabirinto(new StringReader(labirinto2));
		cl.carica();
		assertEquals("Stanza2", this.cl.getStanzaIniziale().getNome());
		assertEquals("Stanza1", this.cl.getStanzaVincente().getNome());
	}
	
}
