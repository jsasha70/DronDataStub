package drondatastub;

public class DronData {

    public double lat, lon, h;
    long t;

    public DronData(double lat, double lon, double h, long t) {
        this.lat = lat;
        this.lon = lon;
        this.h = h;
        this.t = t;
    }
}
