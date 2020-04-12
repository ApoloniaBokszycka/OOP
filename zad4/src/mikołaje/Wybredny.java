
package mikołaje;

import gwiazdka.Prezent;

public class Wybredny extends Mikołaj {

    public Wybredny(int j, int k) {
        super(j, k);
    }

    @Override
    public boolean dodajPrezentDoWorka(Prezent p) {
        double wspWagawlk = p.obliczWspWaga_Wielkość();
        if((this.dajLiczbęPrezentówwWorku()<this.getIleMaks())&&
           (this.dajWielkośćPrezentówwWorku()<this.getPojemność())&&
            p.obliczWspWaga_Wielkość()<1.0){ //sprawdzam czy wspolczynnik ceny do wielkosci jest wiekszy niz 10
            
        
            for(int i=0; i<this.getZawartośćWorka().length; i++){
                if (getZawartośćWorka()[i] == null){
                    setZawartośćWorka(i,p); //wkładam na wolne miejsce prezent p
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String nazwa() {
        return "Wybredny";
    }
    
}
