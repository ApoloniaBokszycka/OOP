
package Filtry;

import Błędy.BrakPliku;


public interface Filtr {
    //metody:
    public void otwórz_plik(String nazwa) throws BrakPliku;
    public String dajSłowo();
    public void zamknij_plik(String nazwa);
    public int ileSłów();
    public boolean czyJestNastępneSłowo();
   
}
