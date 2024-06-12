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
import diadia.comandi.ComandoPrendi;

class ComandoPrendiTest {
    Labirinto labirinto;
    private Partita partita;
    private Attrezzo attrezzo;
    private Attrezzo attrezzo2;
    private Comando comando;
    private IO io;
    @BeforeEach
	public void setUp() throws Exception{
    	labirinto = Labirinto.newBuilder("test1.txt").getLabirinto();
    	/*addStanzaPartenza("Atrio")
        .addAttrezzo("martello", 3)
        .addStanzaVincente("Biblioteca")
        .collegaStanze("nord","Atrio", "Biblioteca")
        .getLabirinto();*/
    	partita = new Partita(labirinto);
		attrezzo = new Attrezzo("seghetto", 3);
		attrezzo2 = new Attrezzo("martello", 11);
		comando = new ComandoPrendi();
		io = new IOConsole(new Scanner(System.in));
		comando.setIO(io);
	}
    @Test
    public void testAttrezzoPreso() {
        partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo);
        comando.setParametro("seghetto");
        comando.esegui(partita);
        assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo.getNome()));
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo.getNome()));
    }

    @Test
    public void testAttrezzoPesante() {
        partita.getLabirinto().getStanzaCorrente().addAttrezzo(attrezzo2);
        comando.setParametro("martello");
        comando.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo(attrezzo2.getNome()));
        assertTrue(partita.getLabirinto().getStanzaCorrente().hasAttrezzo(attrezzo2.getNome()));
    }
    
    @Test
    public void testAttrezzoInesistente() {
        comando.setParametro("bastone");
        comando.esegui(partita);
        assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("bastone"));
        assertFalse(partita.getLabirinto().getStanzaCorrente().hasAttrezzo("bastone"));
    }
}