
package Lądownik;

import Błędy.BrakPołączenia;
import Błędy.BłądCzujnika;
import Błędy.BłądZakresu;


public class CzujnikTemperatury extends Czujnik {
    //konstruktor
    public CzujnikTemperatury(String nazwa) throws BrakPołączenia {
        super(nazwa);
        
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNazwa() {
        return super.getNazwa(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getPomiar(int n) throws BłądCzujnika {
        if (Pomiary[n]<-160 || Pomiary[n]>40){
                throw new BłądZakresu() {};
        } else {
        return Pomiary[n]; //To change body of generated methods, choose Tools | Templates.
        }
    }


}
