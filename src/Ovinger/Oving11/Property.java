package Ovinger.Oving11;
/*Oppgave 2*/

import java.util.Objects;

/**
 * Klassen Property
 * @version 1.01 - 2020-10-26
 * @author Olav Finne Praesteng Larsen (kanditatnmr)
 */
public class Property {
    private final int municipalityNr;
    private final String municipalityName;
    private final int gnr;
    private final int bnr;
    private double area;
    private String nameOfOwner;
    private String propertyName;

    /**
     * Konstruktor som oppretter objekt av typen Property
     * @param municipalityNr int kommunenummer
     * @param municipalityName String kommunenavn
     * @param gnr int gaardsnummer
     * @param bnr int bruksnummer
     * @param area float areal i kvadratmeter
     * @param nameOfOwner String eierens navn
     * @param propertyName String eiendom
     */

    public Property(int municipalityNr, String municipalityName, int gnr, int bnr, double area, String nameOfOwner, String propertyName){
            if(municipalityNr < 101 || municipalityNr > 5054){
                throw new IllegalArgumentException("Municipality number must be between 101-5054");
            }
            this.municipalityNr = municipalityNr;

        this.municipalityName = municipalityName;
        this.gnr = gnr;
        this.bnr = bnr;

        this.area = area;
        this.nameOfOwner = nameOfOwner;
        this.propertyName = propertyName;
    }

    /**
     * Kopi-konstruktor som oppretter objekt av typen Property
     * @param property
     */
    /* Oppretter en kopikonstruktor siden jeg kjorer komposisjon, og dermed maa man dypkopiere*/
    public Property(Property property){
        this.municipalityNr = property.getMunicipalityNr();
        this.municipalityName = property.getMunicipalityName();
        this.gnr = property.getGnr();
        this.bnr = property.getBnr();
        this.area = property.getArea();
        this.nameOfOwner = property.getNameOfOwner();
        this.propertyName = property.getPropertyName();
    }

    /**
     * Mutator-metode for aa endre paa arealet til tomten
     * @param area double det nye arealet til tomten
     */
    /* Hvis man kjoper/selger mer areal, kanskje ikke nodvending, men tar det med, bare fordi det er en muliget
    * og klassen er mutabel uansett*/
    public void setArea(float area) {
        this.area = area;
    }

    /**
     * Mutator-metode for aa endre paa eierens navn
     * @param nameOfOwner String den nye eierens navn
     */
    /* Hvis gaarden bytter eier*/
    public void setNameOfOwner(String nameOfOwner) {
        this.nameOfOwner = nameOfOwner;
    }

    /**
     * Mutator-metode for å endre eiendomsnavnet til eiendommen
     * @param propertyName String det nye eiendomsnavnet
     */
    /* Hvis gaarden bytter navn*/
    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    /*Get-metoder*/
    public int getMunicipalityNr() {
        return municipalityNr;
    }

    public String getMunicipalityName() {
        return municipalityName;
    }

    public int getGnr() {
        return gnr;
    }

    public int getBnr() {
        return bnr;
    }

    public double getArea() {
        return area;
    }

    public String getNameOfOwner() {
        return nameOfOwner;
    }

    public String getPropertyName() {
        return propertyName;
    }

    @Override
    public String toString() {
        return "Property{" +
                "ID=" + uniqueIdToString() +
                ", municipalityName='" + municipalityName + '\'' +
                ", area=" + area +
                ", nameOfOwner='" + nameOfOwner + '\'' +
                ", propertyName='" + propertyName + '\'' +
                '}';
    }

    /*Oppgave 3*/
    /**
     * Metode for aa faa det unike ID-nummeret til en string.
     * @return ID-nummerert (str)
     */
    public String uniqueIdToString(){
        /* Velger aa gjore dette, slik at man lettere kan finne fram til en spesifik eiendom
        * basert på en entydig verdi */
        return municipalityNr + "-" + gnr + "/" + bnr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Property)) return false;
        Property property = (Property) o;
        return municipalityNr == property.municipalityNr &&
                gnr == property.gnr &&
                bnr == property.bnr;
    }

    @Override
    public int hashCode() {
        return Objects.hash(municipalityNr, gnr, bnr);
    }
}
