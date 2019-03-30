package drondatastub;

public class DronDataStub {

    public static void main(String[] args) {
        DronData dd;
        for (int i = 0; i < 100; i++) {
            dd = Dron.nextPoint(1);
            System.out.println("" + dd.getLat() + "/" + dd.getLon() + "/" + dd.getH() + " - " + dd.getT());
        }
    }
}
