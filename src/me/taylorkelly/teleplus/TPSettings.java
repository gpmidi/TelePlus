package me.taylorkelly.teleplus;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.bukkit.util.config.Configuration;

public class TPSettings {
    
    private static final String settingsFile = "TelePlus.yml";
    
    public static void initialize(File dataFolder) {
        if(!dataFolder.exists()) {
            dataFolder.mkdirs();
        }

        File configFile  = new File(dataFolder, settingsFile);
        if(!configFile.exists()) {
            configFile.delete();
        }

    }

    private static void createSettingsFile(File configFile) {
        BufferedWriter bwriter = null;
        FileWriter fwriter = null;
        try {
            configFile.createNewFile();
            fwriter = new FileWriter(configFile, true);
            bwriter = new BufferedWriter(fwriter);
            bwriter.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (bwriter != null) {
                    bwriter.close();
                }
                if (fwriter != null)
                    fwriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
