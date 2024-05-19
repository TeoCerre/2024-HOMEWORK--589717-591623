package test;

import static org.junit.jupiter.api.Assertions.*;

import diadia.ambienti.StanzaMagica;
import diadia.attrezzi.Attrezzo;

import org.junit.jupiter.api.Test;

public class StanzaMagicaTest {

	private StanzaMagica s1=new StanzaMagica("s1");
	private Attrezzo p=new Attrezzo("pala", 33);;
	private Attrezzo m=new Attrezzo("martello", 42);;
	private Attrezzo v=new Attrezzo("vanga", 42);;

	@Test
	public void testAddAttrezzo() {
		assertTrue(s1.addAttrezzo(m));

	}

	@Test
	public void testModificaAttrezzo() {
		assertTrue(s1.addAttrezzo(p));
		assertTrue(s1.addAttrezzo(v));
		assertTrue(s1.addAttrezzo(m));
		}
}

//aggiungi test

