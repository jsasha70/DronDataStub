package drondatastub;

import java.io.Serializable;

public class DronData implements Serializable {

    private double lat, lon, h;
    private long t;

    public DronData(double lat, double lon, double h, long t) {
        this.lat = lat;
        this.lon = lon;
        this.h = h;
        this.t = t;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public double getH() {
        return h;
    }

    public long getT() {
        return t;
    }

    public void setT(long t) {
        this.t = t;
    }
}
