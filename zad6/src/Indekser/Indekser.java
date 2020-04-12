
package Indekser;

import Błędy.BrakPliku;
import Filtry.Filtr;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Indekser {
    //atrybut:
    private List<String> źródła;
    private int liczbaSłów;
    private Filtr filtr;    //zapamiętany obecny filtr, ale może się zmieniać kiedy wczytam inne dane
//    private String ścieżka; //zapamiętana obecna ścieżka, ale może się zmieniać kiedy wczytam inne dane
    private Set<String> Słowa;
    //private Map<String, Integer> plikiLSłów;
    
    //konstruktor:
    public Indekser(){
        this.źródła = new ArrayList<String>();
        this.liczbaSłów = 0;
        this.Słowa = new HashSet<String>();
    }

    public List<String> jakieŹródła() {
        return źródła;
    }
    
    public int ileSłów() throws BrakPliku {
        for(String s : źródła){ 
            filtr.otwórz_plik(s);
            while(filtr.czyJestNastępneSłowo()){
                Słowa.add(filtr.dajSłowo());
            } 
            filtr.zamknij_plik(s);
        }
        return Słowa.size();
    }

    public int wIluPlikach(String słowo) throws BrakPliku {
        //dla każdego pliku z listy źródeł patrze czy jest tam zadane w parametrze słowo
        int licznik = 0;
        for(String s : źródła){
            filtr.otwórz_plik(s);
            while(filtr.czyJestNastępneSłowo()){
                if(filtr.dajSłowo().equals(słowo)){
                    licznik+=1;
                    break;
                }
            }
            filtr.zamknij_plik(s);
        }
        return licznik;
        
        // możnaby wykorzystać słownik?
        
    }

    public ArrayList<String> dajPlikiZeSłowem(String słowo) throws BrakPliku {

        //wersja, która sprawdza każde słowo
        ArrayList<String> listaPlików = new ArrayList<>();
        for(String s : źródła){
            filtr.otwórz_plik(s);
            while(filtr.czyJestNastępneSłowo()){
                if(filtr.dajSłowo().equals(słowo)){
                    listaPlików.add(s);
                    break;
                }
            }
            filtr.zamknij_plik(s);
        }
        return listaPlików;
    }    
                
    public HashSet<String> dajPlikiZeSłowami(List<String> zbiórSłów) throws BrakPliku {
        HashMap<String, HashSet<String>> słownik = new HashMap<>();
        for(String s : zbiórSłów){
            HashSet<String> temp = new HashSet<String>(this.dajPlikiZeSłowem(s));
            słownik.put(s, temp);
        }
        
        HashSet<String> częśćWsp = słownik.get(zbiórSłów.get(0));
        for(String s: słownik.keySet()){
            częśćWsp.retainAll(słownik.get(s));
        }
        
        return częśćWsp;
    }

    public void wczytajDane(String ścieżka, Filtr filtr) throws BrakPliku {
        this.filtr = filtr; //czy to dobrze, że jest atrybut filtr?
        źródła.add(ścieżka);
        
    }
    
    
}
