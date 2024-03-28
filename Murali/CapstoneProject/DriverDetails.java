import java.io.Serializable;

public class DriverDetails implements Serializable{

    private String drivername;
    private int driverId;

    DriverDetails(String drivername, int driverId){
        this.driverId = driverId;
        this.drivername = drivername;
    }
    
    public void setDriverId(int driverId) {
        this.driverId = driverId;
    }
    public int getDriverId() {
        return driverId;
    }

    public void setDrivername(String drivername) {
        this.drivername = drivername;
    }
    public String getDrivername() {
        return drivername;
    }

    @Override
    public String toString() {       
        return "DRIVER DETAILS: DRIVE NAME:" + drivername + " DRIVER ID:" + driverId;
    }
    
}
