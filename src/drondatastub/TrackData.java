package drondatastub;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TrackData {

    public DronData lst[];
    public int fileNo;

    public TrackData(int fileNo) {
        String fname = "assets\\" + fileNo + ".plt";
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

            while ((line = reader.readLine()) != null) {
                if (skip > 0) {
                    continue;
                }
                skip--;

                ss=line.split(",");
                
                dat.add(new DronData(, skip, skip, skip))

                System.out.println(line);
            }
            return true;
        } catch (IOException e) {
            System.err.println("error accesing file " + fname + ": " + e.toString());
            return false;
        }
    }
}
