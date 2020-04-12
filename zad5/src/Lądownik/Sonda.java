
package Lądownik;

import Błędy.BłądCzujnika;


public class Sonda {
    //atrybuty:
    private Czujnik[] Czujniki;
    
    //konstruktor:
    public Sonda(Czujnik[] lista_czujników){
        Czujniki = lista_czujników;
    }
    
    //getter:
    public Czujnik[] getCzujniki(){
        return Czujniki;
    }
    
    //metody:
    public void działaj(int liczba){
        for(int i=0; i<liczba; i++){
            System.out.print(i+": ");
            for(int j=0; j<getCzujniki().length; j++){
                try {
                    System.out.print(getCzujniki()[j].getNazwa() + ": " + getCzujniki()[j].getPomiar(i%getCzujniki().length) + ", ");
                } catch (BłądCzujnika b) {
                    System.out.print(b + ", "); 
                }
            }
            System.out.println(" ");
        }
       
    }
    
    public String toString(){
        String wyn="Sonda zawiera następujące czujniki:";
        for(int i=0; i<this.getCzujniki().length; i++){
            wyn += getCzujniki()[i].toString() + ", ";
            //można ewentualnie zmodyfikować, że jeżeli ostatni element to ma być kropka
        }
    
        return wyn;
    }
    
}
