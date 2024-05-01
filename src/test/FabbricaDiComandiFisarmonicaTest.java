package test;
import static org.junit.jupiter.api.Assertions.*;


import org.junit.Test;
import diadia.comandi.ComandoFine;
import diadia.comandi.FabbricaDiComandiFisarmonica;
import diadia.comandi.Comando;
import diadia.comandi.ComandoNonValido;
import diadia.comandi.ComandoVai;

public class FabbricaDiComandiFisarmonicaTest {

    private FabbricaDiComandiFisarmonica fabbrica= new FabbricaDiComandiFisarmonica();
    private Comando c;

    @Test
    public void testComandoNotValid() {
        c = new ComandoNonValido();
        assertEquals( c.getNome(), fabbrica.costruisciComando("Null").getNome());
    }

    @Test
    public void testComandoNotNull() {

        c = new ComandoVai();
        c.setParametro("ovest");
        Comando c = fabbrica.costruisciComando("vai ovest");

        assertEquals( c.getNome(), c.getNome());
        assertEquals( c.getParametro(), c.getParametro());
    }

    @Test
    public void testComandoParametroNull() {
        c = new ComandoFine();
        assertEquals( c.getNome(), fabbrica.costruisciComando("fine").getNome());
    }
}
