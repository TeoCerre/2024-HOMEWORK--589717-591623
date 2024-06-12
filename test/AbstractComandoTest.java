package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import diadia.IOConsole;
import diadia.Partita;
import diadia.ambienti.Labirinto;
import diadia.comandi.ConcreteComando;


public class AbstractComandoTest {

	ConcreteComando cc;
	Partita p;
	
	@Before
	public void setUp() throws Exception {
		cc = new ConcreteComando();
		p = new Partita(Labirinto.newBuilder("labirinto.txt").getLabirinto());
	}

	@After
	public void tearDown() throws Exception {
	}

	
	@Test
	public void testConcreteComandoEsegui() {
		cc.esegui(p);
		 assertTrue(p.isFinita());
	}

	@Test
	public void testConcreteComandoGetIO() {
		cc.setIO(new IOConsole(new Scanner(System.in)));
		 assertNotNull(cc.getIo());
	}
	
	@Test
	public void testConcreteComandoParametro() {
		cc.setParametro("pippo");
		 assertNotNull(cc.getParametro());
	}
}