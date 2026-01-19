package com.orangehrm.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class CSVUtils {

    public static Object[][] getCSVData(String filePath) {

        List<Object[]> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {

            String line;
            br.readLine(); // skip header

            while ((line = br.readLine()) != null) {

                // Split by comma OR tab
                String[] values = line.split(",|\t");

                if (values.length < 3) {
                    System.out.println("Invalid row skipped: " + line);
                    continue;
                }

                data.add(new Object[]{
                        values[0].trim(),
                        values[1].trim(),
                        values[2].trim()
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data.toArray(new Object[0][0]);
    }
}
