package fr.guillaumewlt.uiswing.timer;

import java.util.Arrays;
import java.util.List;

import fr.guillaumewlt.utils.ProgressBarUtils;

public class ProgressBarTimer {

    private ProgressBarTimer() {}

    private static List<String> values = Arrays.asList(
        "Interpreting manifest",
        "Downloading version JSON file",
        "Interpreting version JSON file",
        "Interpreting client jar infos",
        "Downloading client jar",
        "Interpreting client libraries",
        "Downloading version libraries",
        "Extracting natives libraries",
        "Interpreting client assets index",
        "Downloading assets index",
        "Interpreting client assets",
        "Downloading client assets",
        "Downloading runtime JSON file",
        "Interpreting runtime JSON file",
        "Downloading JRE_MANIFEST",
        "Interpreting JRE_MANIFEST",
        "Downloading runtime JRE file",
        "Classpath building",
        "Request infos",
        "Starting client"
    );

    public static void updater() {
        int total = values.size();
        for (int i = 0; i < total; i++) {
            int value = (i * 100) / (total - 1);

            ProgressBarUtils.update(value, values.get(i));

            try {
                Thread.sleep(100); // Sleep for 100ms
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
