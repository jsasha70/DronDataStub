package drondatastub;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

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
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        new FileInputStream(fname), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            // log error
        }
        return false;
    }
}
