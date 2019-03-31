package drondatastub;


public class Main {

    public static void main(String[] args) {
        TrackData tt[] = new TrackData[5];
        int minLen = 999999999;
        String s;
        for (int i = 0; i < tt.length; i++) {
            tt[i] = new TrackData(i + 1);
            if (minLen > tt[i].lst.length) {
                minLen = tt[i].lst.length;
            }
        }

//        minLen = 3;

        System.out.println("\"items\": [");
        for (int i = 0; i < minLen; i++) {
            System.out.println("[");
            for (int j = 0; j < tt.length; j++) {
                s = "{ \"dronID\": " + (j + 1) + ", \"drodUID\"=\"a\", \"lat\": "
                        + tt[j].lst[i].getLat() + ", \"lon\": "
                        + tt[j].lst[i].getLon() + ", \"h\": "
                        + tt[j].lst[i].getH() + ", \"t\": "
                        + tt[j].lst[i].getT() + " }";
                if (j == (tt.length - 1)) {
                    System.out.println(s);
                } else {
                    System.out.println(s + ",");
                }
            }
            System.out.println("],");
        }
        System.out.println("]");
    }
}
