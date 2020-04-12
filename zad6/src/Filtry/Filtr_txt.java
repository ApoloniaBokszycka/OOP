
package Filtry;

import Błędy.BrakPliku;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Filtr_txt implements Filtr {
    //atrybuty:
    private String separator;
    private Scanner skaner;
    
    //kontstruktor:
    public Filtr_txt(String spr){
        this.separator = spr;
    }
    
    
    @Override
    public void otwórz_plik(String nazwa) throws BrakPliku {
        try {
            this.skaner = new Scanner(new File(nazwa),"utf8").useDelimiter(this.separator);
        } catch (FileNotFoundException wyj) {
            throw new BrakPliku();
            //???czy powinno wypisywać?
        }
        
    }

    @Override
    public boolean czyJestNastępneSłowo() {
        return this.skaner.hasNext();
    }

    
    @Override
    public String dajSłowo() {
        if(czyJestNastępneSłowo()){
            String słowo = this.skaner.next();
            return słowo;
        }
        return null; //???
    }

    @Override
    public int ileSłów() {
        int licznik = 0;
        while(this.skaner.hasNext()){
            this.skaner.next();
            licznik+=1;  
        }
        return licznik;
    }
  
    @Override
    public void zamknij_plik(String nazwa){
        //if(!(this.skaner.hasNext())){
        this.skaner.close();
        
    }
}    


