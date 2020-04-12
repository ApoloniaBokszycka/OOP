
package mikołaje;

import gwiazdka.Prezent;


public class Schorowany extends Mikołaj{

    public Schorowany(int j, int k) {
        super(j, k);
    }

    @Override
    public boolean dodajPrezentDoWorka(Prezent p) {
        if((this.dajLiczbęPrezentówwWorku()<this.getIleMaks())&&(this.dajWielkośćPrezentówwWorku()<this.getPojemność())){
            
            for(int i=0; i<this.getZawartośćWorka().length; i++){
                if (getZawartośćWorka()[i] == null){
                    if (i==0){
                        setZawartośćWorka(i,p); //wkładam na wolne miejsce prezent p
                        return true;
                    } else {
                        if (getZawartośćWorka()[i].getWaga()<getZawartośćWorka()[i-1].getWaga()){ //sprawdzam czy lżejszy niż poprzedni
                            setZawartośćWorka(i,p); //wkładam na wolne miejsce prezent p
                            return true;
                        }
                    }
                        
                    }
 
            }
        }
        return false;
    }

    @Override
    public String nazwa() {
        return "Schorowany";
    }
    
}
