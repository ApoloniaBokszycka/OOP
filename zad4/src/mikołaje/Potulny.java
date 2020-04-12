
package mikołaje;

import gwiazdka.Prezent;


public class Potulny extends Mikołaj{
    
    //konstruktor:
    public Potulny(int ileMaks, int pojemność){
        super(ileMaks, pojemność);
    }
   
    //metody:
    @Override
    public boolean dodajPrezentDoWorka(Prezent p) {
        if((this.dajLiczbęPrezentówwWorku()<this.getIleMaks())&&(this.dajWielkośćPrezentówwWorku()<this.getPojemność())){
        
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
        return "Potulny";
    }

}
