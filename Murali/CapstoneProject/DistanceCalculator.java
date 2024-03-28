
public class DistanceCalculator {

    public static double haversineDistance(double lat1, double lon1, double lat2, double lon2) {
        double R = 6371; // Earth radius in kilometers

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
                   Math.sin(dLon / 2) * Math.sin(dLon / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        double distance = R * c; // Distance in kilometers

        return distance;
    }

    public static void main(String[] args) {
        double sourceLatitude = 12.963323538714508;
        double sourceLongitude = 80.24467187903049;
        double destinationLatitude = 11.296360846793643;
        double destinationLongitude = 76.69535307906483;

        double distance = haversineDistance(sourceLatitude, sourceLongitude, destinationLatitude, destinationLongitude);
        System.out.println("The distance between the two locations is " + distance + " kilometers.");
    }
}
