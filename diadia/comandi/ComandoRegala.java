package diadia.comandi;

import diadia.Partita;
import diadia.attrezzi.Attrezzo;

/**

 * Questa classe modella il comando regala
 * ovvero il comando che permette di regalare
 * oggetti ai personaggi nelle stanze
 * @author Matteo Cerretani,Daniele Granato
 * @version 4.0
*/

public class ComandoRegala extends AbstractComando{
	private final static String nome= "regala";
	@Override
	public void esegui(Partita partita) {
		if(partita.getGiocatore().getBorsa().hasAttrezzo(this.getParametro())) {
			Attrezzo a=partita.getGiocatore().getBorsa().getAttrezzo(this.getParametro());
			partita.getGiocatore().getBorsa().removeAttrezzo(this.getParametro());
			partita.getLabirinto().getStanzaCorrente().getPersonaggio().riceviRegalo(a, partita);
		}else {
			this.getIo().mostraMessaggio("Attrezzo non presente nella borsa");
		}
	}
	
	@Override
	public String getNome() {
		return nome;
	}
}
