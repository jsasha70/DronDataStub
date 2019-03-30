package drondatastub;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class TrackData {

    private DronData lst[];
    private int fileNo;
    private static HashMap<Integer, TrackData> tracks = new HashMap(10);

    public static DronData nextPoint(int dronNo) {
        if (!tracks.containsKey(dronNo)) {
            TrackData td = new TrackData(dronNo);
            if (td.getLstLen() == 0) {
                tracks.put(dronNo, null);
            } else {
                tracks.put(dronNo, td);
            }
        }
        return tracks.get(dronNo).nextPoint();
    }

    private DronData nextPoint() {
        long tim = new Date().getTime();
        DronData dd;
        for (int i = 0; i < lst.length; i++) {
            dd = lst[i];
            if (dd.getT() >= tim) {
                try {
                    Thread.sleep(dd.getT() - tim);
                } catch (InterruptedException e) {
                }
                return dd;
            }
        }

        // дошли до конца массива, запускаем дрон в обратную сторону
        DronData lst2[] = new DronData[lst.length];
        long tim2 = tim + lst[lst.length - 1].getT();
        for (int i = 0; i < lst.length; i++) {
            lst[i].setT(tim2 - lst[i].getT());
            lst2[lst.length - i - 1] = lst[i];
        }
        lst = lst2;
        return lst[0];
    }

    public TrackData(int dronNo) {
        String fname = "assets\\" + dronNo + ".plt";
        if (!loadFile(fname)) {
            lst = new DronData[0];
        }
    }

    private boolean loadFile(String fname) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fname), StandardCharsets.UTF_8))) {
            String line;
            int skip = 6;
            ArrayList<DronData> dat = new ArrayList(100);
            String ss[];
            long tim, tim1 = 0;

            while ((line = reader.readLine()) != null) {
                if (skip > 0) {
                    skip--;
                    continue;
                }

                ss = line.split(",");
                tim = (long) ((Float.parseFloat(ss[4]) - 25567) * 86400000);
                if (tim1 == 0) {
                    tim1 = new Date().getTime() - tim + 1;
                }
                tim += tim1;

                dat.add(new DronData(Float.parseFloat(ss[0]),
                        Float.parseFloat(ss[1]),
                        Float.parseFloat(ss[3]) / 3.28,
                        tim));
            }

            int nn = dat.size();
            lst = new DronData[nn];

            for (int i = 0; i < nn; i++) {
                lst[i] = dat.get(i);
            }
            return true;
        } catch (IOException e) {
            System.err.println("error accesing file " + fname + ": " + e.toString());
            return false;
        }
    }

    public int getLstLen() {
        return lst.length;
    }

    public DronData getLstItem(int i) {
        return lst[i];
    }

    public int getFileNo() {
        return fileNo;
    }
}
