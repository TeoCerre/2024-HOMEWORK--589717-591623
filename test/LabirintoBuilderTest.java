package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import diadia.ambienti.Direzione;
import diadia.ambienti.Labirinto;
import diadia.ambienti.Labirinto.LabirintoBuilder;
import diadia.ambienti.Stanza;

public class LabirintoBuilderTest {
    Labirinto.LabirintoBuilder builder;

    @BeforeEach
    public void setUp() throws Exception {
        builder = new LabirintoBuilder("labirinto.txt");
    } 

    @AfterEach
    public void tearDown() throws Exception {
    }

    @Test
    public void testAddStanzaPartenza() {
        builder.addStanzaPartenza("StanzaIniziale");
        Stanza expected = new Stanza("StanzaIniziale");
        assertEquals(expected, builder.getListaStanze().get("StanzaIniziale"));
    }

    @Test
    public void testAddStanzaVincente() {
        builder.addStanzaVincente("StanzaVincente");
        assertEquals("StanzaVincente", builder.getLabirinto().getStanzaVincente().getNome());
    }

    @Test
    public void testAddStanzaNormale() {
        builder.addStanzaNormale("StanzaNormale");
        assertTrue(builder.getStanze().containsKey("StanzaNormale"));
    }

    @Test
    public void testAddAttrezzo() {
        builder.addStanzaNormale("StanzaConAttrezzo").addAttrezzo("Martello", 5);
        assertTrue(builder.getStanze().get("StanzaConAttrezzo").hasAttrezzo("Martello"));
    }

    @Test
    public void testAddStanzaMagica() {
        builder.addStanzaMagica("StanzaMagica", 3);
        assertTrue(builder.getStanze().get("StanzaMagica") instanceof Stanza);
    }

    @Test
    public void testAddStanzaBloccata() {
        builder.addStanzaBloccata("StanzaBloccata", "Chiave", Direzione.nord);
        assertTrue(builder.getStanze().get("StanzaBloccata") instanceof Stanza);
    }

    @Test
    public void testAddStanzaBuia() {
        builder.addStanzaBuia("StanzaBuia", "Torcia");
        assertTrue(builder.getStanze().get("StanzaBuia") instanceof Stanza);
    }

    @Test
    public void testGetListaStanze() {
        builder.addStanzaNormale("Stanza1").addStanzaNormale("Stanza2").addStanzaNormale("Stanza3");
        Map<String, Stanza> stanze = builder.getListaStanze();
        assertEquals(3, stanze.size());
    }
}