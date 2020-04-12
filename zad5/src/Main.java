
import Błędy.BrakPołączenia;
import Lądownik.Czujnik;
import Lądownik.CzujnikSejsmiczny;
import Lądownik.CzujnikTemperatury;
import Lądownik.Sonda;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;





public class Main {

    
    public static void main(String[] args) {
        try{ 
          Sonda sonda = new Sonda( new Czujnik[]{
               new CzujnikSejsmiczny("S1"),
               new CzujnikSejsmiczny("S2"),
               new CzujnikTemperatury("T1")}
           );
       
           sonda.działaj(30);
       }
       catch(BrakPołączenia w){
           System.out.println("Nie udało się utworzyć sondy");
       }
       
    }
    
}
