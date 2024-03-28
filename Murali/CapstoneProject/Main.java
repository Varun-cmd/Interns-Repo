import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.BiPredicate;
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IOException {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("ARE YOU A\n1.ADMIN\n2.USER");
        int usertype = sc.nextInt();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        ArrayList<MetaData> details = new ArrayList<>();
       
        FileOutputStream fos = new FileOutputStream("TruckJourneyDetails.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        BiPredicate<MetaData,String> isMatchingJid = (driver,id) -> driver.getJid().equals(id);
        
        if(usertype==1){
                while(true){
                    System.out.println("SELECT ACTION TO PERFORM:\n1.CREATE A JOURNEY\n2.VIEW DETAILS\n3.UPDATE DETAILS\n4.EXIT");
                    // System.out.println("SELECT ACTION TO PERFORM:\n1.CREATE A JOURNEY\n2.VIEW JOURNEY DETAILS\n3.VIEW DRIVER DETAILS\n4.EXIT");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        case 1:
                            System.out.println("----------DRIVER DETAILS----------");
                            System.out.println("Enter Driver Name");
                            String drivername = sc.nextLine();
                            System.out.println("Enter Driver ID");
                            int driverid = sc.nextInt();
                            DriverDetails d = new DriverDetails(drivername, driverid);
                            sc.nextLine();

                            System.out.println("----------TRUCK DETAILS----------");
                            System.out.println("Enter Truck Name");
                            String truckname = sc.nextLine();
                            System.out.println("Enter Truck id");
                            int truckid = sc.nextInt();
                            double currentLatitude = 12.955281210321735;
                            double currnetLongitude = 80.24349159505753;
                            TruckDetails t = new TruckDetails(truckname, truckid,currentLatitude,currnetLongitude);
                            sc.nextLine();

                            System.out.println("----------JOURNEY DETAILS----------");
                            System.out.println("Enter Source Location");
                            String sourcelocation = sc.nextLine();
                            System.out.println("Enter Destination Location");
                            String destinationlocation = sc.nextLine();

                            LocalDate depDate = LocalDate.now();
                            LocalDate arrDate = LocalDate.now();
                            try{
                            System.out.println("Enter Departure Date [Enter in dd/mmm/yyy format]");
                            String departuredate = sc.nextLine() ;
                            depDate = LocalDate.parse(departuredate,formatter);
                            System.out.println("Enter Arrival Date [Enter in dd/mmm/yyy format]");
                            String arrivaldate = sc.nextLine() ;
                            arrDate = LocalDate.parse(arrivaldate,formatter);
                            }catch(Exception e){
                                System.out.println("Enter date in the correct format");
                            }

                            double sourceLatitude = 12.963323538714508;
                            double sourceLongitude = 80.24467187903049;
                            double destinationLatitude = 11.296360846793643;
                            double destinationLongitude = 76.69535307906483;

                            JourneyDetails j = new JourneyDetails(sourcelocation, destinationlocation, sourceLatitude, sourceLongitude, destinationLatitude, destinationLongitude, depDate, arrDate);
                            MetaData metadata = new MetaData(d, t, j);
                            details.add(metadata);
                            System.out.println("Your Journey ID is "+metadata.getJid());
                            oos.writeObject(metadata);
                            break;   
                            
                    case 2:
                            System.out.println("1.VIEW DRIVER DETAILS\n2.VIEW TRUCK DETAILS\n3.VIEW JOURNEY DETAILS\n4.VIEW UPCOMING JOURNEYS");
                            int viewchoice = sc.nextInt();
                            sc.nextLine();
                            switch(viewchoice){
                                case 1:
                                    System.out.println("Enter the JID");
                                    String driver_jid = sc.nextLine();

                                   
                                    boolean driver_found = details.stream().anyMatch(driver -> isMatchingJid.test(driver, driver_jid));
                                    if(driver_found){
                                        details.stream()
                                        .filter(driver -> isMatchingJid.test(driver, driver_jid))
                                        .findFirst()
                                        .ifPresent(driver -> System.out.println(driver.d.toString()));   
                                    }
                                    else{
                                        System.out.println("No Driver Found :(");
                                    }
                                   
                                    // for(int i=0;i<details.size();i++){
                                    //     if(details.get(i).getJid().equals(driver_jid)){
                                    //         driver_found = true;
                                    //         System.out.println(details.get(i).d.toString());
                                    //     }
                                    // }
                                
                                    // if(driver_found == false){
                                    //     System.out.println("Driver Not Found :(");
                                    // }                                   
                                break;
                                
                                case 2:
                                    System.out.println("Enter the JID");
                                    String truck_jid = sc.nextLine();

                                    boolean truck_found = details.stream().anyMatch(driver -> isMatchingJid.test(driver, truck_jid));

                                    if(truck_found){
                                        details.stream()
                                        .filter(driver -> isMatchingJid.test(driver, truck_jid))
                                        .findFirst()
                                        .ifPresent(driver -> System.out.println(driver.t.toString()));
                                    }else{
                                        System.out.println("Journey Not Found :(");
                                    }
                                    // boolean truck_found = false;
                                    // for(int i=0;i<details.size();i++){
                                    //     if(details.get(i).getJid().equals(truck_jid)){
                                    //         truck_found = true;
                                    //         System.out.println(details.get(i).t.toString());
                                    //     }
                                    // }
                                
                                    // if(truck_found == false){
                                    //     System.out.println("Driver Not Found :(");
                                    // }
                                    break;
                                
                                case 3:
                                        System.out.println("Enter the JID");
                                        String journey_jid = sc.nextLine();
                                        boolean journey_found = details.stream().anyMatch(driver -> isMatchingJid.test(driver, journey_jid));

                                        if(journey_found){
                                            details.stream()
                                            .filter(driver -> isMatchingJid.test(driver, journey_jid))
                                            .findFirst()
                                            .ifPresent(driver -> System.out.println(driver.j.toString()));
                                        }else{
                                            System.out.println("No Journey Found :(");
                                        }
                                        break;
                                
                                case 4:
                                     if(details.size()!=0){
                                    for(int i=0;i<details.size();i++){     
                                        driver_found = true;
                                        System.out.println(details.get(i).j.toString()+"\n"+details.get(i).t.toString()+"\n"+details.get(i).d.toString());                               
                                    }
                                    }else{
                                        System.out.println("No upcoming journey!");
                                    }
                            }
                            break;
                
                    case 3:
                            System.out.println("Enter the JID");
                            String update_id = sc.nextLine();
                            MetaData[] traveldetails = {new MetaData(update_id)};
                            boolean travel_found = details.stream().anyMatch(journey -> isMatchingJid.test(journey, update_id));
                            
                             if(travel_found){
                                details.stream()
                                .filter(journey -> isMatchingJid.test(journey, update_id))
                                .findFirst()
                                .ifPresent(journey -> {
                                    traveldetails[0] = journey;
                                    System.out.println(journey.j.toString()+"\n"+journey.d.toString()+"\n"+journey.t.toString());
                                });
                             }else{
                                System.out.println("No Travel Found :(");
                                break;
                             }

                              
                            // for(int i=0;i<details.size();i++){
                            //     if(details.get(i).getJid().equals(update_id)){
                            //         travel_found = true;
                            //         traveldetails[0] = details.get(i);
                            //         System.out.println(details.get(i).j.toString()+"\n"+details.get(i).d.toString()+"\n"+details.get(i).t.toString());
                            //         break;
                            //     }
                            // }

                            //  if(travel_found==false){
                            //         System.out.println("No Travel Found :(");
                            //         break;
                            //     }

                            System.out.println("1.UPDATE JOURNEY DETAILS\n2.UPDATE DRIVER DETAILS\n3.UPDATE TRUCK DETAILS");
                            int update_choice = sc.nextInt();
                    
                            switch(update_choice){
                                case 1:
                                    System.out.println(traveldetails[0].j.toString());
                                    System.out.println("1.UPDATE SOURCE LOCATOION\n2.UPDATE DESTINATION LOCATION\n3.UPDATE DEPARTURE TIME\n4.UPDATE ARRIVAL TIME");
                                    int journeyUpdateChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch(journeyUpdateChoice){
                                        case 1:
                                            System.out.println("Enter new Source Location");
                                            String newSourceLocation = sc.nextLine();
                                            traveldetails[0].j.setSourcelocation(newSourceLocation);
                                            System.out.println("Successfullt Updated");
                                            break;
                                        case 2:
                                            System.out.println("Enter new Destination Location");
                                            String newDestinationLocation = sc.nextLine();
                                            traveldetails[0].j.setDestinationlocation(newDestinationLocation);
                                            System.out.println("Successfullt Updated");
                                            break;
                                        case 3:
                                            System.out.println("Enter new Departure Date in [dd/MM/yyy] format ");
                                            String newDepartureDate = sc.nextLine();
                                            LocalDate newDepDate = LocalDate.parse(newDepartureDate,formatter);
                                            traveldetails[0].j.setJourneystartdate(newDepDate);
                                            System.out.println("Successfullt Updated");
                                            break;
                                        case 4:
                                            System.out.println("Enter new Departure Date in [dd/MM/yyy] format ");
                                            String newArrivalDate = sc.nextLine();
                                            LocalDate newArrDate = LocalDate.parse(newArrivalDate,formatter);
                                            traveldetails[0].j.setJourneystartdate(newArrDate);
                                            System.out.println("Successfullt Updated");
                                            break;
                                    }
                                    break;
                                case 2:
                                    System.out.println(traveldetails[0].d.toString());
                                    System.out.println("1.UPDATE DRIVER NAME\n2.UPDATE DRIVER ID");
                                    int driverUpdateChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch(driverUpdateChoice){
                                        case 1:
                                            System.out.println("Enter new Driver Name");
                                            String newDriverName = sc.nextLine();
                                            traveldetails[0].d.setDrivername(newDriverName);
                                            System.out.println("Successfullt Updated");
                                            break;
                                        case 2:
                                            System.out.println("Enter new Driver ID");
                                            int newDriverID = sc.nextInt();
                                            traveldetails[0].d.setDriverId(newDriverID);
                                            sc.nextLine();
                                            System.out.println("Successfullt Updated");
                                            break;
                                    }
                                    break;
                                case 3:
                                    System.out.println(traveldetails[0].t.toString());
                                    System.out.println("1.UPDATE TRUCK NAME\n2.UPDATE TRUCK ID");
                                    int truckUpdateChoice = sc.nextInt();
                                    sc.nextLine();
                                    switch(truckUpdateChoice){
                                        case 1:
                                            System.out.println("Enter new Truck Name");
                                            String newTruckName = sc.nextLine();
                                            traveldetails[0].t.setTruckname(newTruckName);
                                            System.out.println("Successfullt Updated");
                                            break;
                                        case 2:
                                            System.out.println("Enter new Truck ID");
                                            int newTruckID = sc.nextInt();
                                            traveldetails[0].t.setTruckid(newTruckID);
                                            System.out.println("Successfullt Updated");
                                            sc.nextLine();
                                            break;
                                    }
                                    break;
                            }
                        break;
            
                        case 4:
                            break;
                    }

                    if(choice == 4){
                        oos.close();
                        System.out.println("Thank You");
                        break;
                    }
                }
        }
        
        else if(usertype==2){
            while(true){
                    System.out.println("SELECT ACTION TO PERFORM:\n1.VIEW JOURNEY DETAILS\n2.VIEW DRIVER DETAILS\n3.VIEW ALL UPCOMING JOURNEY\n4.EXIT");
                    int choice = sc.nextInt();
                    sc.nextLine();
                    switch (choice) {
                        
                    case 1:
                            System.out.println("Enter your JID");
                            String journey_jid = sc.nextLine();
                            boolean journey_found = false;
                            for(int i=0;i<details.size();i++){
                                if(details.get(i).getJid().equals(journey_jid)){
                                    journey_found = true;
                                    System.out.println(details.get(i).j.toString());
                                }
                            }

                            if(journey_found == false){
                                System.out.println("Journey Not Found :(");
                            }
                            break;
                    
                    case 2:
                            System.out.println("Enter your JID");
                            String driver_jid = sc.nextLine();
                            boolean driver_found = false;
                            for(int i=0;i<details.size();i++){
                                if(details.get(i).getJid().equals(driver_jid)){
                                    driver_found = true;
                                    System.out.println(details.get(i).d.toString());
                                }
                            }
                           
                            if(driver_found == false){
                                System.out.println("Driver Not Found :(");
                            }
                            break;
                                  
                        case 3:
                            break;
                    }

                    if(choice == 3){
                        System.out.println("Thank You");
                        break;
                    }
                }
        }       
    }
}
