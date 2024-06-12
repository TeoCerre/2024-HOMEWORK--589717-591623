package diadia.giocatore;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import diadia.Configuratore;
import diadia.attrezzi.Attrezzo;

/**
 * Una classe borsa che contiene gli attrezzi
 * Il peso massimo è di 10 Kg
 * Permette di prendere e posare oggetti dalla borsa
 *
 * @author  docente di POO,Matteo Cerretani,Daniele Granato
 * @see Attrezzo
 * @version 4.0
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = Configuratore.getPesoMax();
	//public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	private int pesoAtt;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		//this.attrezzi = new Attrezzo[10]; // speriamo bastino...
		this.attrezzi=new TreeMap<>();
		this.numeroAttrezzi = 0;
		this.pesoAtt=0;
	}
	/**
     * Mette un attrezzo nella borsa.
     * @param attrezzo l'attrezzo da mettere nella stanza.
     * @return true se riesce ad aggiungere l'attrezzo, false atrimenti.
     */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax())
			return false;
		//if (this.numeroAttrezzi==10)
			//return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		this.pesoAtt+=attrezzo.getPeso();
		return true;
	}
	/**
     * Restituisce il peso massimo della borsa.
	 * @return un intero pari al peso massimo
	 */
	public int getPesoMax() {
		return pesoMax;
	}
	/**
     * Restituisce la collezione di attrezzi presenti nella borsa.
     * @return la collezione di attrezzi nella stanza.
     */
	public Map<String,Attrezzo> getAttrezzi() {
        return this.attrezzi;
    }
    
	/**
     * Restituisce l'attrezzo nomeAttrezzo se presente nella borsa.
	 * @param nomeAttrezzo
	 * @return l'attrezzo presente nella stanza.
     * 		   null se l'attrezzo non e' presente.
	 */
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		Attrezzo a = null;
		if (this.attrezzi.containsKey(nomeAttrezzo))
			a = this.attrezzi.get(nomeAttrezzo);
		return a;
	}
	/**
	* Prende il peso totale della borsa
	* Somma tutti i pesi degli attrezzi nella borsa.
	* @return un intero pari al peso complessivo.
	*/
	public int getPeso() {
		return this.pesoAtt;
	}
	/**
	* Controlla se la borsa è vuota.
	* @return true se la borsa è vuota,0 altrimenti.
	*/
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	/**
	* Controlla se un attrezzo esiste nella borsa (uguaglianza sul nome).
	* @return true se l'attrezzo esiste nella stanza, false altrimenti.
	*/
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.getAttrezzo(nomeAttrezzo)!=null;
	}
	/**
	 * Rimuove un attrezzo dalla borsa (ricerca in base al nome).
	 * @param attrezzo
	 * @return true se l'attrezzo e' stato rimosso, false altrimenti
	 */
	public boolean removeAttrezzo(String attrezzo) {
	    if(this.attrezzi.get(attrezzo)!=null) {
	    	this.pesoAtt-=this.attrezzi.get(attrezzo).getPeso();
	    	this.attrezzi.remove(attrezzo);
	    	this.numeroAttrezzi--;
	    	return true;
	    }        
	    return false;
	}
	/**
	 * Ritorna una stringa con tutte le informazioni della borsa
	 * @return stringa con le informazioni necessarie
	 */

	public String toString() {
	    StringBuilder s = new StringBuilder();

	    if (!this.isEmpty()) {
	        s.append("Contenuto borsa (" + this.pesoAtt + "kg/" + this.getPesoMax() + "kg): ");
	        s.append(mapToString(this.attrezzi));
	    } else {
	        s.append("Borsa vuota");
	    }
	    return s.toString();
	}
	/**
	 * metodo per formattare correttamente la stringa
	 * @param map
	 * @return stringa formattata correttamente
	 */
	private String mapToString(Map<?, ?> map) {
	    StringBuilder result = new StringBuilder();
	    String prefix = "";
	    for (Map.Entry<?, ?> entry : map.entrySet()) {
	        result.append(prefix);
	        prefix = ", ";
	        result.append(entry.getValue().toString());
	    }
	    return result.toString();
	}
	/**restituisce la lista degli attrezzi nella borsa ordinati per peso e
		quindi, a parità di peso, per nome
	*/
	public List<Attrezzo> getContenutoOrdinatoPerPeso() {
        List<Attrezzo> listaAttrezzi = new ArrayList<>(this.attrezzi.values());
        Collections.sort(listaAttrezzi, Comparator.comparingInt(Attrezzo::getPeso)
                                                  .thenComparing(Attrezzo::getNome));
        return listaAttrezzi;
    }
	 /**
     * Restituisce l'insieme degli attrezzi nella borsa ordinati per nome.
     */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome() {
        SortedSet<Attrezzo> contenutoOrdinato = new TreeSet<>(Comparator.comparing(Attrezzo::getNome));
        contenutoOrdinato.addAll(this.attrezzi.values());
        return contenutoOrdinato;
    }
	/**restituisce una mappa che associa un intero (rappresentante un
	peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	lo stesso peso pari all'intero che figura come chiave
	*/
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso() {
        Map<Integer, Set<Attrezzo>> contenutoRaggruppato = new HashMap<>();
        for (Attrezzo attrezzo : this.attrezzi.values()) {
            int peso = attrezzo.getPeso();
            contenutoRaggruppato.putIfAbsent(peso, new HashSet<>());
            contenutoRaggruppato.get(peso).add(attrezzo);
        }
        return contenutoRaggruppato;
    }
	/**restituisce l'insieme gli attrezzi nella borsa
	rdinati per peso e quindi, a parità di peso, per
	nome*/
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso() {
        SortedSet<Attrezzo> sortedSet = new TreeSet<>(new Comparator<Attrezzo>() {
            @Override
            public int compare(Attrezzo a1, Attrezzo a2) {
                int diff = a1.getPeso() - a2.getPeso();
                if (diff != 0) {
                    return diff;
                } else {
                    return a1.getNome().compareTo(a2.getNome());
                }
            }
        });
        sortedSet.addAll(attrezzi.values());
        return sortedSet;
    }
	
	
}

