package drondatastub;

public class DronDataStub {

    public static void main(String[] args) {
        TrackData d = new TrackData(1);
        int nn = d.getLstLen();
        System.out.println("track size: " + nn);
        if (nn > 10) {
            DronData dd;
            for (int i = 0; i < 10; i++) {
                dd = d.getLstItem(i);
                System.out.println("" + dd.getLat() + "/" + dd.getLon() + "/" + dd.getH() + " - " + dd.getT());
            }
        }
    }
}
