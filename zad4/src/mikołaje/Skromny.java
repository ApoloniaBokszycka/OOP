
package mikołaje;

import gwiazdka.Prezent;

public class Skromny extends Mikołaj{

    public Skromny(int j, int k) {
        super(j, k);
    }

    @Override
    public boolean dodajPrezentDoWorka(Prezent p) {
        if((this.dajLiczbęPrezentówwWorku()<this.getIleMaks())&&
           (this.dajWielkośćPrezentówwWorku()<this.getPojemność())&&
            p.obliczWspCena_Wielkość()>10){ //sprawdzam czy wspolczynnik ceny do wielkosci jest wiekszy niz 10
            
        
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
        return "Skromny";
    }
    
}
