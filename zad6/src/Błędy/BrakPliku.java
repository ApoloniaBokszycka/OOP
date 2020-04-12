
package Błędy;

import java.io.FileNotFoundException;


public class BrakPliku extends FileNotFoundException{
    //konstruktor:
    public BrakPliku(){
    }
        
    //metoda:
    public String getMessage(){
        return "BrakPliku";
    }    
    // ?????????????? co z metodą ??????????????    
}
    

