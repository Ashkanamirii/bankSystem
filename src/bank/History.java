package bank;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashkan Amiri , Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class History {

    public static String getDateNowFormat() {
        //Get current date time
        LocalDateTime DateNow = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return DateNow.format(formatter);
    }

    public static void replaceSelected(String target, String replacement) {
        try {
            // input the file content to the StringBuffer "input"
            BufferedReader file = new BufferedReader(new FileReader("src/bank/CustomerList.csv"));
            StringBuffer inputBuffer = new StringBuffer();
            String line;

            while ((line = file.readLine()) != null) {
                inputBuffer.append(line);
                inputBuffer.append('\n');
            }
            file.close();
            String inputStr = inputBuffer.toString();

            System.out.println(inputStr); // display the original file for debugging

            // logic to replace lines in the string (could use regex here to be generic)
                inputStr = inputStr.replace(target, replacement);

            // display the new file for debugging
            System.out.println("----------------------------------\n" + inputStr);

            // write the new string with the replaced line OVER the same file
            FileOutputStream fileOut = new FileOutputStream("src/bank/CustomerList.csv");
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }
}
