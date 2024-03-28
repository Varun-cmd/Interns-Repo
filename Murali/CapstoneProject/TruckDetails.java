import java.io.Serializable;

public class TruckDetails implements Serializable{

    private String truckname;
    private int truckid;
    private double currentLatitude;
    private double currnetLongitude;

    TruckDetails(String truckname, int truckid, double currentLatitude, double currnetLongitude){
        this.truckname = truckname;
        this.truckid = truckid;
        this.currentLatitude = currentLatitude;
        this.currnetLongitude = currnetLongitude;
    }

    public int getTruckid() {
        return truckid;
    }
    public void setTruckid(int truckid) {
        this.truckid = truckid;
    }
    public String getTruckname() {
        return truckname;
    }
    public void setTruckname(String truckname) {
        this.truckname = truckname;
    }
    public void setCurrentLatitude(double currentLatitude) {
        this.currentLatitude = currentLatitude;
    }
    public double getCurrentLatitude() {
        return currentLatitude;
    }
    public void setCurrnetLongitude(double currnetLongitude) {
        this.currnetLongitude = currnetLongitude;
    }
    public double getCurrnetLongitude() {
        return currnetLongitude;
    }
    

    @Override
    public String toString() {
        return "TRUCK DETAILS:\n TRUCK NAME: "+truckname +
        "\nTRUCK ID: "+ truckid + 
        "\nCURRENT LATITUDE: "+ currentLatitude+
        "\nCURRENT LONGITUDE: "+currnetLongitude;
    }
  
}
