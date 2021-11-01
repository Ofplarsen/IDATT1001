package Ovinger.Oving11;

import java.util.ArrayList;
import java.util.Iterator;

public class PropertyRegistry {
    /* Velger å bruke AL, fordi det er lett aa bruke og har gode metoder som sort(), hvor man kan lettere sortere listen, enn
    * f.eks vanlig array. Jeg kunne ogsaa valgt HashMap, hvor man har en nokkelverdi til hver klasse, slik den er lett å finne, og
    * dette ville vaert det unike ID-nummeret. HashMap er likevel litt vanskeligere aa loope igjennom. Og det med at AL er en mutabel
    * liste, har ikke saa mye aa si, fordi programmet gir bare klienten en kopi av listen. Det er altså litt smak og behag, begge funker
    * */
    private ArrayList<Property> listOfProperties;

    /* Siden jeg bruker komposisjon tenker jeg at det like greit å bare opprette et objekt av registeret, uten noen parameter,
    * siden alle eiendommene uansett skal maatte opprettes/registreres i registeret. Jeg vet at man egentlig ikke trenger aa lage
    * en konstruktor hvis man ikke har parameter (er en standard), men gjor det for ryddighet og det viser tydelighet*/

    /**
     * Konstruktor som oppretter objekt av typen PropertyRegistry
     */
    public PropertyRegistry(){
        listOfProperties = new ArrayList<>();
    }

    /**
     * Metode som registrerer en ny eiendom i registeret. Tar inn nodvendig info som parameter
     * @param municipalityNr
     * @param municipalityName
     * @param gnr
     * @param bnr
     * @param area
     * @param nameOfOwner
     * @param propertyName
     */
    public void registerProperty(int municipalityNr, String municipalityName, int gnr, int bnr, double area, String nameOfOwner, String propertyName){
        
        listOfProperties.add(new Property(municipalityNr, municipalityName, gnr, bnr, area, nameOfOwner, propertyName));
    }

    /**
     * Metode for aa fjerne en eiendom. Tar inn den unike ID'en til eiendommen
     * @param municipalityNr Kommunenummer int
     * @param gnr Gaardsnummer int
     * @param bnr Bruksnummer int
     */
    public void removeProperty(int municipalityNr, int gnr, int bnr){
        int length = 0;
        /* Looper igjennom hver property i listen */
        for (Property p : listOfProperties) {
            if (municipalityNr == p.getMunicipalityNr() && gnr == p.getGnr() && bnr == p.getBnr()) {
                listOfProperties.remove(p);
                length++;
            }//TODO boolean metode for å vite om d ble removed
        }
        if (length == listOfProperties.size()) {
            throw new IllegalArgumentException("The given information did not match any of the registered properties.");
        }
    }

    /**
     * Metode for aa finne en eiendom gitt kommunenummer, gaardsnummer og bruksnummer
     * @param municipalityNr int
     * @param gnr int
     * @param bnr int
     * @return Eiendommen som matcher Property
     */

    public Property findProperty(int municipalityNr, int gnr, int bnr){

        for (Property p : listOfProperties) {
            if (municipalityNr == p.getMunicipalityNr() && gnr == p.getGnr() && bnr == p.getBnr()) {
                /* Returnerer en dyp kopi av eiendommen slik at klieneten ikke har direkte tilgang til originalen*/
                return new Property(p);
            }//TODO equals
        }
        return null;
    }

    /**
     * Private metode for å regne ut gjennomsnittlig areal
     * @return gjennomsnittlig areal
     */
    private double averageArea(){
        double sum = 0;
        for(Property p : listOfProperties){
            sum+= p .getArea();
        }
        return sum/listOfProperties.size();
    }
    /*Trenger ikke lage en dyp kopi av primitive datatyper, ettersom disse er immutable av seg selv. Dermed har det ikke noe aa si om klienten faar
    * tilgang til disse*/

    /**
     * Metode for aa faa gjennomsnittlig areal
     * @return gjennomsnittlig areal double
     */
    public double getAverageArea(){
        return averageArea();
    }

    /**
     * Metode for aa finne alle eiendommer på gitt gnr
     * @param gnr Gaardsnummer int
     * @return Dyp kopi av en ArrayList med eiendommene
     */
    public ArrayList<Property> findProperties(int gnr){
        ArrayList<Property> propertiesGnr= new ArrayList<>();
        for (Property p : listOfProperties) {

            if (p.getGnr() == gnr) {
                propertiesGnr.add(p);
            }
            if(propertiesGnr.size() == 0){
                throw new IllegalArgumentException("No Properties on given gnr");
            }
        }
        /* Returnerer dyp kopi av ArrayListen slik at klienten ikke faar direkte tilgang*/
        return deepCopy(propertiesGnr);
    }


    /**
     * Metode for aa dypkopiere en ArrayList av typen Property
     * @param listToCopy ArrayListen som skal dypkopieres av typen Property
     * @return Dyp kopi av typen Property
     */
    /*Dypkopierer for aa kunne returnere ArrayListen til clienten, uten at han faar tilgang til den originale listen*/
    private ArrayList<Property> deepCopy(ArrayList<Property> listToCopy){
        ArrayList<Property> copy = new ArrayList<>();
        Iterator<Property> it = listToCopy.iterator();
        while(it.hasNext()){
            Property p = it.next();
            Property newP = new Property(p); //viktigste kopi
            copy.add(newP);
        }
        return copy;
    }

    /**
     * Metode som returnerer antall eiendommer registrert
     * @return antall eiendommer int
     */
    public int getRegistrySize(){
        return listOfProperties.size();
    }

    /**
     * Metode for aa faa ut en ArrayList med eiendommer. Den må loopes og printes i clientprogrammet
     * @return dyp kopi av registerlisten
     */
    public ArrayList<Property> getListOfProperties() {
        return deepCopy(listOfProperties);
    }

    public String toString(){
        String registryToString = "";
        for(Property p : listOfProperties){
            registryToString += "\n" + p.toString();
        }
        return registryToString;
    }


}
