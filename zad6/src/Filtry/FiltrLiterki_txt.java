
package Filtry;

import Błędy.BrakPliku;
import java.util.Locale;

public class FiltrLiterki_txt extends Filtr_txt {
    
    public FiltrLiterki_txt(String spr) {
        super(spr);
    }
    @Override
    public void otwórz_plik(String nazwa) throws BrakPliku {
        super.otwórz_plik(nazwa); 
    }

    @Override
    public String dajSłowo() {
        return super.dajSłowo().toLowerCase(Locale.forLanguageTag("PL")); 
    }
    
    @Override
    public void zamknij_plik(String nazwa) {
        super.zamknij_plik(nazwa);
    }


    

    
}
