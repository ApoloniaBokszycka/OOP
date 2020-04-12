
package mikołaje;

import gwiazdka.Prezent;


public class Ostrożny extends Mikołaj {
    
    //Konstruktor:
    public Ostrożny (int ileMaks, int pojemność){
        super(ileMaks, pojemność);
    }

    @Override
    public boolean dodajPrezentDoWorka(Prezent p) {
        if((this.dajLiczbęPrezentówwWorku()<this.getIleMaks())&&(this.dajWielkośćPrezentówwWorku()<=0.5*this.getPojemność())){
        
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
        return "Ostrożny";
    }
    
}
