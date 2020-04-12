
package mikołaje;

import gwiazdka.Prezent;


public abstract class Mikołaj {
    protected int ileMaks;
    protected int pojemność;
    protected Prezent[] zawartośćWorka;
    
    //Konstruktor:
    public Mikołaj(int j, int k){
        ileMaks = j;
        pojemność = k;
        zawartośćWorka = new Prezent[j]; //tworzę worek czyli listę Prezentów
    }
    
    //Akcesory:
    
    public int getIleMaks(){
        return ileMaks;
    }
    
    public int getPojemność(){
        return pojemność;
    }
    
    public Prezent[] getZawartośćWorka(){
        return zawartośćWorka;
    }
    
    public void setZawartośćWorka(int i, Prezent p){
        zawartośćWorka[i] = p;
    }
    
    
    //Metody abstrakcyjne:
    public abstract boolean dodajPrezentDoWorka(Prezent p);   //czy na pewno void? ,moze boolean???
    //jezeli nie wlozymy prezentu to zwroci nam false -> wtedy włozymy ten prezent do biura Mikolajow
    
    public abstract String nazwa();
    
    
    //Metody klasowe:
    @Override
    public String toString(){
        return "Mikołaj{" + this.nazwa()+
                ", worek = Worek{pojemność=" + this.getPojemność()+
                ", l.prezentów="+ this.dajLiczbęPrezentówwWorku() + "/" + this.getPojemność()+
                ", zawartość="+this.wypiszZawartość()+ "}}]" ;
        
    }
    
    public int dajLiczbęPrezentówwWorku(){
        int pom = 0;
        for(int i = 0; i<getZawartośćWorka().length; i++){
            if(getZawartośćWorka()[i] != null){
                pom+=1;
            }
        }
        return pom;
    }
    
    public int dajWielkośćPrezentówwWorku(){
        int pom = 0;
        for(int i = 0; i<getZawartośćWorka().length; i++){
            if (getZawartośćWorka()[i] != null){
                pom+=getZawartośćWorka()[i].getWielkość();
            }
        }
        return pom;
        
    }
    
    public String wypiszZawartość(){
        String napis = "";
        
        for(int i = 0; i<getZawartośćWorka().length; i++){
            if (getZawartośćWorka()[i] != null){
                napis += getZawartośćWorka()[i].wypiszP()+",";  
            } 
        }
        return napis;
    }
    
}
