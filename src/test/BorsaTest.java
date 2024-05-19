package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedSet;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

import diadia.attrezzi.Attrezzo;
import diadia.giocatore.Borsa;

class BorsaTest {
	
	Borsa b=new Borsa();
	Attrezzo chiave=new Attrezzo("chiave",1);
	Attrezzo martello=new Attrezzo("martello",5);
	Attrezzo scala=new Attrezzo("scala",15);
	
	@Test
	public void testAddAttrezzoMinoreDieci() {
		assertTrue(b.addAttrezzo(chiave));
	}
	@Test
	public void testAddAttrezzoMaggioreDieci() {
		assertFalse(b.addAttrezzo(scala));
	}
	@Test
	public void testGetAttrezzo() {
		b.addAttrezzo(chiave);
		assertEquals(chiave,b.getAttrezzo("chiave"));
	}
	@Test
	public void testPesoMax() {
		assertEquals(10,b.getPesoMax());
	}
	@Test
	public void testHasAttrezzo() {
		b.addAttrezzo(martello);
		assertTrue(b.hasAttrezzo("martello"));
	}
	@Test
	public void testHasAttrezzoInesistente() {
	    assertFalse(b.hasAttrezzo("spada"));
	}
	@Test
	public void testHasAttrezzoPesoModificato() {
	    b.addAttrezzo(new Attrezzo("martello", 8));
	    assertTrue(b.hasAttrezzo("martello"));
	}
	@Test
	public void testGetContenutoOrdinatoPerPesoCrescente() {
	    b.addAttrezzo(martello);
	    b.addAttrezzo(scala);
	    b.addAttrezzo(chiave);
	    List<Attrezzo> contenutoOrdinato = b.getContenutoOrdinatoPerPeso();
	    for (int i = 1; i < contenutoOrdinato.size(); i++) {
	        Attrezzo attrezzoPrecedente = contenutoOrdinato.get(i - 1);
	        Attrezzo attrezzoCorrente = contenutoOrdinato.get(i);
	        assertTrue(attrezzoPrecedente.getPeso() <= attrezzoCorrente.getPeso());
	    }
	}
	@Test
	public void testGetContenutoOrdinatoPerPesoBorsaVuota() {
	    List<Attrezzo> contenutoOrdinato = b.getContenutoOrdinatoPerPeso();
	    assertTrue(contenutoOrdinato.isEmpty());
	}
	@Test
	public void testGetContenutoOrdinatoPerPesoDuplicati() {
	    b.addAttrezzo(new Attrezzo("Chiave", 5));
	    b.addAttrezzo(new Attrezzo("Chiave", 10));
	    List<Attrezzo> contenutoOrdinato = b.getContenutoOrdinatoPerPeso();
	    for (int i = 1; i < contenutoOrdinato.size(); i++) {
	        Attrezzo attrezzoPrecedente = contenutoOrdinato.get(i - 1);
	        Attrezzo attrezzoCorrente = contenutoOrdinato.get(i);
	        assertTrue(attrezzoPrecedente.getPeso() <= attrezzoCorrente.getPeso());
	    }
	}
	@Test
	public void testGetContenutoOrdinatoPerNome() {
	    b.addAttrezzo(martello);
	    b.addAttrezzo(scala);
	    b.addAttrezzo(chiave);
	    SortedSet<Attrezzo> contenutoOrdinato = b.getContenutoOrdinatoPerNome();
	    List<Attrezzo> attrezziOrdinati = new ArrayList<>(contenutoOrdinato);
	    for (int i = 0; i < attrezziOrdinati.size() - 1; i++) {
	        Attrezzo attrezzoCorrente = attrezziOrdinati.get(i);
	        Attrezzo attrezzoSuccessivo = attrezziOrdinati.get(i + 1);
	        assertTrue(attrezzoCorrente.getNome().compareTo(attrezzoSuccessivo.getNome()) <= 0);
	    }
	}
	@Test
	public void testGetContenutoRaggruppatoPerPeso() {
	    b.addAttrezzo(chiave);
	    b.addAttrezzo(martello);
	    b.addAttrezzo(scala);

	    Map<Integer, Set<Attrezzo>> contenutoRaggruppato = b.getContenutoRaggruppatoPerPeso();

	    assertEquals(2, contenutoRaggruppato.size());
	    assertTrue(contenutoRaggruppato.containsKey(1));
	    assertTrue(contenutoRaggruppato.containsKey(5));
	    assertFalse(contenutoRaggruppato.containsKey(15));
	}
	
	@Test
    public void testAttrezziDiversiConStessoPeso() {
        Attrezzo attrezzo1 = new Attrezzo("Martello", 5);
        Attrezzo attrezzo2 = new Attrezzo("Chiave", 5);       
        b.addAttrezzo(attrezzo1);
        b.addAttrezzo(attrezzo2);
        SortedSet<Attrezzo> sortedSetOrdinato = b.getSortedSetOrdinatoPerPeso();
        assertTrue(sortedSetOrdinato.contains(attrezzo1));
        assertTrue(sortedSetOrdinato.contains(attrezzo2));

        assertNotEquals(attrezzo1, attrezzo2);
    }
}

