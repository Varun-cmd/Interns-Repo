import java.time.LocalDate;
import java.io.Serializable;

public class JourneyDetails implements Serializable {
    
    private String sourcelocation;
    private String destinationlocation;
    private double sourceLatitude;
    private double sourceLongitude;
    private double destinationLatitude;
    private double destinationLongitude;
    private LocalDate journeystartdate;
    private LocalDate journeyenddate;

    JourneyDetails(String sourcelocation, String destinationlocation, double sourceLatitude, double sourceLongitude, double destinationLatitude, double destinationLongitude, LocalDate journeystartdate, LocalDate journeyenddate){
        this.sourcelocation = sourcelocation;
        this. destinationlocation = destinationlocation;
        this.journeyenddate = journeyenddate;
        this.journeystartdate = journeystartdate;
        this.sourceLatitude = sourceLatitude;
        this.sourceLongitude = sourceLongitude;
        this.destinationLatitude = destinationLatitude;
        this.destinationLongitude = destinationLongitude;
    }

    public String getDestinationlocation() {
        return destinationlocation;
    }
    public void setDestinationlocation(String destinationlocation) {
        this.destinationlocation = destinationlocation;
    }

    public String getSourcelocation() {
        return sourcelocation;
    }
    public void setSourcelocation(String sourcelocation) {
        this.sourcelocation = sourcelocation;
    }

    public LocalDate getJourneyenddate() {
        return journeyenddate;
    }

    public void setJourneyenddate(LocalDate journeyenddate) {
        this.journeyenddate = journeyenddate;
    }

    public LocalDate getJourneystartdate() {
        return journeystartdate;
    }
    public void setJourneystartdate(LocalDate journeystartdate) {
        this.journeystartdate = journeystartdate;
    }
    public double getSourceLatitude() {
        return sourceLatitude;
    }
    public void setSourceLatitude(double sourceLatitude) {
        this.sourceLatitude = sourceLatitude;
    }

    public double getSourceLongitude() {
        return sourceLongitude;
    }
    public void setSourceLongitude(double sourceLongitude) {
        this.sourceLongitude = sourceLongitude;
    }
    public double getDestinationLatitude() {
        return destinationLatitude;
    }
    public void setDestinationLatitude(double destinationLatitude) {
        this.destinationLatitude = destinationLatitude;
    }
    public double getDestinationLongitude() {
        return destinationLongitude;
    }
    public void setDestinationLongitude(double destinationLongitude) {
        this.destinationLongitude = destinationLongitude;
    }
 
    @Override
    public String toString() {
        return 
        "JOURNEY DETAILS: \nDEPARTURE TIME:"+ journeystartdate + 
        "\nARRIVAL TIME:" + journeyenddate + 
        "\nSOURCE:" + sourcelocation +" Latitude: "+ sourceLatitude+" Longitude: "+ sourceLongitude+  
        "\nDESTINATION: " +destinationlocation + "Latitude: "+ destinationLatitude+" Longitude: " +destinationLongitude;
    }

}
