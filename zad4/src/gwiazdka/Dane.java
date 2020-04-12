package gwiazdka;

import gwiazdka.Prezent;
import mikołaje.*;

public class Dane {
    private Prezent[] listaP;
    private Mikołaj[] listaM;
    private Prezent[] biuroMikołajów;
    
    //Konstruktor:
    public Dane(Prezent[] listaP, Mikołaj[] listaM){ //przekazuję jako parametry zadane listy prezentów i mikołajów
        
        this.listaP = listaP;
        this.listaM = listaM;
        this.biuroMikołajów = new Prezent[5]; //na razie tworzę pustą tablicę prezentów, robie sobie miejsce na 5 prezentów
    }
    //akcesory:
    public Prezent[] prezenty(){ //get lista mikołajów
        return listaP;
    }
    
    public Mikołaj[] mikołaje(){ //get lista prezentów
        return listaM;
    }
    
    public String toString(){
        String prefix = "Dane{\n \tprezenty = [";
        String prezenty = "";
        for(int i=0; i < this.listaP.length; i++){
            prezenty += this.listaP[i].wypiszP();
            if(this.listaP.length - i != 1){
                prezenty += ", ";
            }
        }
        prezenty += "]\n";
        
        String mikolaje = "\tmikołaje = [";
        for(int i=0; i < this.listaM.length; i++){
            mikolaje += this.listaM[i];
            if(this.listaM.length - i != 1){
                mikolaje += ", ";
            }
            
        }
        mikolaje += "]\n}";
        
        return prefix + prezenty + mikolaje;
    }
    
    //public Prezent[] setBiuroMikołajów(){
        
    //}
    //co z Biurem Mikołajów?
    
    //public Prezent[] przekażDoBiura(Prezent p){
        //jeżeli lista jest cala zajeta, to towrzymy nowa dwa razy wieksza, kopiujemy stara i wstadzamy nowy prezent na kolejna miejsce
        //mozemy wykorzystac zmienna pomocnicza do zliczania ilosci prezentow i bedziemy sprawdzac czy pom = length tablicy
        
        
    //}
    //metoda WYPISZ dla Biura Mikolajow
}
