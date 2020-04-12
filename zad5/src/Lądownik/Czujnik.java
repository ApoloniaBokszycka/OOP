
package Lądownik;

import Błędy.BrakPołączenia;
import Błędy.BłądCzujnika;
import Błędy.BłądZakresu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public abstract class Czujnik {
    // atrybuty:
    
    private final String nazwa;
    protected int[] Pomiary;
    
   //konstruktor:
    public Czujnik(String nazwa) throws BrakPołączenia{
        Pomiary = wczytaj(nazwa);
        this.nazwa = nazwa;
    }
    
    //akcesory:
    public abstract int getPomiar(int n) throws BłądCzujnika;
            
    public String getNazwa(){
        return this.nazwa;
    }
    
    //metody:
    public String toString(){
        return this.getNazwa();
    }

    
    //metoda wczytywania: 
    private int[] wczytaj(String nazwa) throws BrakPołączenia{        
        Scanner plik;
        try {            
            // Wczytanie danych z pliku
            //plik = new Scanner(new File(nazwa));            
            plik = new Scanner(new File(nazwa + ".txt"), "UTF-8");            
            List<Integer> danePom = new ArrayList<>();
            while(plik.hasNextInt()){
                danePom.add(plik.nextInt());
            }
            plik.close();
            
            // Zamiana na tablicę
            int[]wyn = new int[danePom.size()];
            for(int i=0; i<danePom.size(); i++)
                wyn[i] = danePom.get(i);
            
            // Przekazanie wyniku
            return wyn;
        }
        catch(FileNotFoundException e){
            System.out.println("Brak pliku <" + nazwa + ">");
            throw new BrakPołączenia();
        }
    }
    
    
    
    }

