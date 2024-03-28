import java.io.Serializable;
import java.util.UUID;

public class MetaData implements Serializable{

    private final String jid;
    public DriverDetails d;
    public TruckDetails t;
    public JourneyDetails j;



    MetaData(DriverDetails d, TruckDetails t, JourneyDetails j){
        this.jid = UUID.randomUUID().toString();
        // this.jid = "123";
        this.d = d;
        this.t = t;
        this.j = j;
    }
    MetaData(String jid){
        this.jid = jid;
    }

    public String getJid() {
        return jid;
    }
}
