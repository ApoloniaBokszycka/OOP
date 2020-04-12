
import gwiazdka.Dane;
import gwiazdka.Prezent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import mikołaje.Mikołaj;
import mikołaje.Ostrożny;
import mikołaje.Potulny;
import mikołaje.Schorowany;
import mikołaje.Skromny;
import mikołaje.Wybredny;


public class Main {

    Dane wczytajDane(String nazwa) {
        try {
            Scanner dane = new Scanner(new File(nazwa), "UTF-8");

            // Czytam prezenty, kończą się pustym wierszem

            ArrayList<Prezent> prezenty = new ArrayList<Prezent>();

            int nrWiersza = 0;
            int ileP = 0;
            String napis;
            while (dane.hasNextLine() && ((napis = dane.nextLine()).length() > 0)) {
                nrWiersza++;
                Scanner wiersz = new Scanner(napis);

                assert wiersz.hasNextInt() : "Brak wielkości prezentu w wierszu: " + nrWiersza + ": " + wiersz;
                int wielkość = Integer.parseInt(wiersz.next());

                assert wiersz.hasNextInt() : "Brak wagi prezentu w wierszu: " + nrWiersza + ": " + wiersz;
                int waga = Integer.parseInt(wiersz.next());

                assert wiersz.hasNextInt() : "Brak ceny prezentu w wierszu: " + nrWiersza + ": " + wiersz;
                int cena = Integer.parseInt(wiersz.next());

                prezenty.add(new Prezent(wielkość, waga, cena));
            } // while

            ileP = nrWiersza;
            nrWiersza++; //Pusry wiersz

            System.out.println("Liczba wczytanych prezentów: " + ileP);

            // Czytam Mikołajów

            ArrayList<Mikołaj> mikołaje = new ArrayList<Mikołaj>();

            while (dane.hasNextLine()) {
                nrWiersza++;
                Scanner wiersz = new Scanner(dane.nextLine());

                assert wiersz.hasNext(".") : "Brak kodu Mikołaja w wierszu: " + nrWiersza + ": " + wiersz;
                String kod = wiersz.next();

                assert wiersz.hasNextInt() : "Brak maksymalnej liczby prezentów mieszczących się w worku w wierszu: " + nrWiersza + ": " + wiersz;
                int ileMaks = Integer.parseInt(wiersz.next());

                assert wiersz.hasNextInt() : "Brak pojemności worka w wierszu: " + nrWiersza + ": " + wiersz;
                int pojemność = Integer.parseInt(wiersz.next());

                switch (kod) {
                    case "P":
                        mikołaje.add(new Potulny(ileMaks, pojemność));
                        break;       
                    case "O":
                        mikołaje.add(new Ostrożny(ileMaks, pojemność));
                        break;
                    case "S":
                        mikołaje.add(new Schorowany(ileMaks, pojemność));
                        break;
                    case "B":
                        mikołaje.add(new Skromny(ileMaks, pojemność));
                        break;
                    case "W":
                        mikołaje.add(new Wybredny(ileMaks, pojemność));
                        break;
                    // ...  pozostali Mikołajowie ...
                    default:
                        assert false : "Niepoprawny kod Mikołaja w wierszu: " + nrWiersza + ": " + wiersz;
                } // switch
            } // while

            int ileM = nrWiersza - ileP - 1;
            System.out.println("Liczba wczytanych Mikołajów: " + ileM);

            return new Dane(prezenty.toArray(new Prezent[0]), mikołaje.toArray(new Mikołaj[0]));

        } catch (FileNotFoundException e) {
            assert false : "Nie można otworzyć pliku: " + nazwa;
            return null; // Tylko dla spokoju ducha kompilatora, nigdy tu nie dojdziemy (przy -ea)
        }

        
        
        
            
        }
        
        
    public Dane rozdziel(Dane dane){
            int i = 0;
            int j = 0;
            int s = 0; //pozycja startowa, zaczynamu od pierwszego mikołaja
            Boolean taken = false;
            while ((i<dane.mikołaje().length) && (j<dane.prezenty().length)){
                    taken = false;
                    Prezent temp_prez = dane.prezenty()[j];
                    Mikołaj temp_mik = dane.mikołaje()[i];
                    
                
                    if (dane.mikołaje()[i].dodajPrezentDoWorka(dane.prezenty()[j])){ //sprawdzamy czy mikolaj wezmie prezent
                        
                        j++;
                        i++;//jezeli mikolaj wezmie prezent (TRUE) to bierzemy kolejny prezent i zaczynamy od kolejnego mikolaja sprawdzaćs
                        taken = true;
                    } else {
                        i++;//jezeli mikolaj nie wezmie prezentu (FALSE) to przechodzimy do kolejnego mikolaja i mu probujemy dać
                        
                        temp_mik = dane.mikołaje()[i];
                    }
                    if (i == dane.mikołaje().length && j < dane.prezenty().length){ //jezeli przejdziemy cala liste mikolajow
                        i = s+1; //zaczynamy rozdawac od kolejnego mikolaja
                        s = s+1; //zapamietujemy pozycje startowa
                        if(!taken){
                           j++; 
                        }
                        
                    }
                        
            }
            /*
            int s = 0; //zaczynamy rozdawanie od pierwszego mikolaja, pozycja start
            for(int i = 0; i<=dane.mikołaje().length; i++){
                for (int j = 0; j<dane.prezenty().length; j++){
                    Prezent temp_prez = dane.prezenty()[j];
                    Mikołaj temp_mik = dane.mikołaje()[i];

                    if (i == dane.mikołaje().length){ //jezeli przejdziemy cala liste mikolajow
                        i = s+1; //zaczynamy rozdawac od kolejnego mikolaja
                        s = s+1; //zapamietujemy pozycje startowa
                        j++;     //bierzemy kolejny prezent
                    }
                    if (dane.mikołaje()[i].dodajPrezentDoWorka(dane.prezenty()[j])){ //sprawdzamy czy mikolaj wezmie prezent
                        
                        j++;
                        i++;//jezeli mikolaj wezmie prezent (TRUE) to bierzemy kolejny prezent i zaczynamy od kolejnego mikolaja sprawdzać
                    } else {
                        i++;//jezeli mikolaj nie wezmie prezentu (FALSE) to przechodzimy do kolejnego mikolaja i mu probujemy dać
                    }
                    
                }
            }
            */
            return dane;
        }
        
        
        
    public static void main(String[] args) {

        //assert false: "Odkomentuj tę instrukcję";  // <---- Pierwsze uruchomienie programu nie powinno się powieść!!!

        Main m = new Main();

        System.out.println("*** Początek programu - wczytywanie danych ***\n");

        Dane dane = m.wczytajDane("C:\\Users\\LYNX\\Documents\\NetBeansProjects\\zad4\\src\\dane0.txt");

        System.out.println("\n*** Po wczytaniu danych, dane = ***\n\n" + dane + "\n");

        m.rozdziel(dane);

        System.out.println("\n*** Mikołaje po podziale prezentów ***\n");
        for(Mikołaj mik: dane.mikołaje())
            System.out.println(mik);
//            mik.toString();

        System.out.println("\n*** Koniec programu ***");
        }
        
        
        
    }
