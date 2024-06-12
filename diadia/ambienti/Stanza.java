package diadia.ambienti;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

import diadia.Configuratore;
import diadia.attrezzi.Attrezzo;
import diadia.personaggi.AbstractPersonaggio;

/**
 * Classe Stanza - una stanza in un gioco di ruolo.
 * Una stanza e' un luogo fisico nel gioco.
 * E' collegata ad altre stanze attraverso delle uscite.
 * Ogni uscita e' associata ad una direzione.
 * 
 * @author docente di POO,Matteo Cerretani,Daniele Granato
 * @see Attrezzo
 * @version 4.0
*/

public class Stanza {
	public final static int NUMERO_MASSIMO_ATTREZZI = Configuratore.getAttrezziMax();
	public final static int NUMERO_MASSIMO_DIREZIONI = Configuratore.getDirezioniMax();
	//static final private int NUMERO_MASSIMO_DIREZIONI = 4;
	//static final private int NUMERO_MASSIMO_ATTREZZI = 10;
	
	private String nome;
	private Map<String, Attrezzo> attrezzi;
    private int numeroAttrezzi;
    private Map<Direzione, Stanza> direzioni2stanze;
    private int numeroStanzeAdiacenti;
    private AbstractPersonaggio personaggio;

    
    /**
     * Crea una stanza. Non ci sono stanze adiacenti, non ci sono attrezzi.
     * @param nome il nome della stanza
     */
    public Stanza(String nome) {
        this.nome = nome;
        this.numeroStanzeAdiacenti = 0;
        this.numeroAttrezzi = 0;
        this.direzioni2stanze=new HashMap<>();
        this.attrezzi=new HashMap<>();
    }
    
    /**
     * Imposta una stanza adiacente.
     *
     * @param direzione direzione in cui sara' posta la stanza adiacente.
     * @param stanza stanza adiacente nella direzione indicata dal primo parametro.
     */
    public void impostaStanzaAdiacente(Direzione direzione, Stanza stanza) {
        boolean aggiornato = false;
    	/**for(int i=0; i<this.direzioni.length; i++)
        	if (direzione.equals(this.direzioni[i])) {
        		this.stanzeAdiacenti[i] = stanza;
        		aggiornato = true;
        	}
        */
        if(direzioni2stanze.containsKey(direzione)) {
        	this.direzioni2stanze.put(direzione, stanza);
        	aggiornato=true;
        }
    	if (!aggiornato)
    		if (this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
    			this.direzioni2stanze.put(direzione,stanza);
    			this.numeroStanzeAdiacenti++;
    			
    		}
    }

    /**
     * Restituisce la stanza adiacente nella direzione specificata
     * @param direzione
     */
    public Stanza getStanzaAdiacente(Direzione direzione) {
    	Stanza stanza=null;
    	if (this.direzioni2stanze.containsKey(direzione))
			stanza = this.direzioni2stanze.get(direzione);
        // Se non viene trovata una stanza adiacente nella direzione specificata
        return stanza; // Oppure restituisci una stanza vuota o un valore speciale
    }

    /**
     * Restituisce il nome della stanza.
     * @return il nome della stanza
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Restituisce la descrizione della stanza.
     * @return la descrizione della stanza
     */
    public String getDescrizione() {
        return this.toString();
    }

    /**
     * Restituisce la collezione di attrezzi presenti nella stanza.
     * @return la collezione di attrezzi nella stanza.
     */
    public Collection<Attrezzo> getAttrezzi() {
		return this.attrezzi.values();
	}

    /**
     * Mette un attrezzo nella stanza.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            this.attrezzi.put(attrezzo.getNome(), attrezzo);
            this.numeroAttrezzi++;
            return true;
        } else {
            return false;
        }
    }

   /**
	* Restituisce una rappresentazione stringa di questa stanza,
	* stampadone la descrizione, le uscite e gli eventuali attrezzi contenuti
	* @return la rappresentazione stringa
	*/
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        risultato.append(this.getDirezioni().toString());
        risultato.append("\nAttrezzi nella stanza: ");
        risultato.append(this.getAttrezzi().toString());
        return risultato.toString();
    }

    /**
	* Controlla se un attrezzo esiste nella stanza (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}

	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella stanza.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo attrezzoCercato;
		attrezzoCercato = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			attrezzoCercato = this.attrezzi.get(nomeAttrezzo);
		return attrezzoCercato;	
	}

	/**
	 * Rimuove un attrezzo dalla stanza (ricerca in base al nome).
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(Attrezzo attrezzo) {
		if (attrezzo != null) {
	        return this.attrezzi.remove(attrezzo.getNome(), attrezzo);
	    }
	    return false;
	}
	
	/**
	 * Prende le possibili direzioni
	 * @return stringa con tutte le direzioni possibili, vuota se non ce ne sono
	 */
	public Set<Direzione> getDirezioni() {
		return direzioni2stanze.keySet();
	}
	
	public List<Stanza> getStanzeAdiacenti() {
		return (List<Stanza>) direzioni2stanze.values();
	}
	
	public int getNumeroStanzeAdiacenti() {
		return numeroStanzeAdiacenti;
	}
	
	public void setNumeroStanzeAdiacenti(int numeroStanzeAdiacenti) {
		this.numeroStanzeAdiacenti = numeroStanzeAdiacenti;
	}
	@Override
	public int hashCode() {
		return Objects.hash(nome);
	}

	@Override
	public boolean equals(Object obj) {
		
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Stanza that = (Stanza) obj;
		return this.getNome().equals(that.getNome());
	}
	public int getNumeroAttrezziPossibili() {
		return NUMERO_MASSIMO_ATTREZZI-this.numeroAttrezzi;
	}
	
	public void setPersonaggio(AbstractPersonaggio personaggio) {
	    this.personaggio = personaggio;
	}
	
	public AbstractPersonaggio getPersonaggio() {
	    return this.personaggio;
	}
	public int getNumeroAttrezzi() {
		return this.numeroAttrezzi;
	}
}
