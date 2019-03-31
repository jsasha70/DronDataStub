package drondatastub;

public class Main {

    public static void main(String[] args) {
        DronData dd;
        long t1 = 0, dt;
        for (int i = 0; i < 1000; i++) {
            dd = DronStub.nextPoint(1);
            dt = dd.getT() - t1;
            t1 = dd.getT();
            System.out.println("" + dd.getLat() + "/" + dd.getLon() + "/" + dd.getH() + " - " + dt);
        }
    }
}
