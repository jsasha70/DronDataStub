package drondatastub;

import java.util.HashMap;

public class Dron {

    private final TrackData track;
    private final int dronNo;

    private static final HashMap<Integer, Dron> drons = new HashMap(10);

    private Dron(int dronNo) {
        this.dronNo = dronNo;
        track = new TrackData(dronNo);
    }

    public static DronData nextPoint(int dronNo) {
        if (!drons.containsKey(dronNo)) {
            Dron d = new Dron(dronNo);
            drons.put(dronNo, d);
        }
        return drons.get(dronNo).track.nextPoint();
    }

    public int getTracLen() {
        return track.getLstLen();
    }

    public DronData getTrackItem(int i) {
        return track.getLstItem(i);
    }
}
