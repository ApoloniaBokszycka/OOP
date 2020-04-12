
package gwiazdka;

public class Prezent {
    private final int wielkość;
    private final int waga;
    private final int cena;
    
    //Konstruktor:
    public Prezent(int wielkość, int waga, int cena){
        this.wielkość = wielkość;
        this.waga = waga;
        this.cena = cena;
    }
    
    //Akcesory:
    public int getWielkość(){
        return wielkość;
    }
    public int getWaga(){
        return waga;
    }
    public int getCena(){
        return cena;
    }
    
    //Metody:
    public String wypiszP(){
        return "Prezent{" + 
               "wielkość=" + this.getWielkość() +
               "waga=" + this.getWaga() + 
               "cena=" + this.getCena() +
               "}";
    }
    
    public double obliczWspCena_Wielkość(){
        return cena/wielkość;
    }
    
    public double obliczWspWaga_Wielkość(){
        return waga/wielkość;
    }
    
}
