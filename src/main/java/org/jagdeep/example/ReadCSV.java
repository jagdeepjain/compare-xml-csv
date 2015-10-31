/**
 * @author jagdeepjain
 *
 */
package org.jagdeep.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadCSV {
    
    public ArrayList<String> getHeaders() {
        BufferedReader csvPath = null;
        ArrayList<String> header = new ArrayList<String>();
        String filePath = "src/test/resources/sample.csv";
        try {
            String csvLine;
            csvPath = new BufferedReader(new FileReader(filePath));
            while ((csvLine = csvPath.readLine()) != null) {
                header = csvToArrayList(csvLine);
                break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (csvPath != null)
                    csvPath.close();
            } catch (IOException io) {
                io.printStackTrace();
            }
        }
        return header;
    }
    
    public static ArrayList<String> csvToArrayList(String csv) {
        ArrayList<String> csvLines = new ArrayList<String>();
        if (csv != null) {
            String[] splitData = csv.split("\\s*,\\s*");
            for (int i = 0; i < splitData.length; i++) {
                if (!(splitData[i] == null) || !(splitData[i].length() == 0)) {
                    csvLines.add(splitData[i].trim());
                }
            }
        }
        return csvLines;
    }
    
}
