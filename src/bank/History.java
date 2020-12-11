package bank;

import java.io.*;
import java.nio.file.Path;
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
            BufferedReader file = new BufferedReader(new FileReader("resources/CustomerList.csv"));
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
            FileOutputStream fileOut = new FileOutputStream("resources/CustomerList.csv");
            fileOut.write(inputStr.getBytes());
            fileOut.close();

        } catch (Exception e) {
            System.out.println("Problem reading file.");
        }
    }


    public static void historyLog(Customer customer, double amount , int action, int action1) {
        System.out.println("customer\n " + customer.customToString(action,action1,amount));
        String filePathOut = "resources/CustomersHistory.csv";
        String textToAppend = customer.customToString(action, action1,amount);
        try (FileWriter fileWriter = new FileWriter(filePathOut, true);//Set true for append mode.
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(textToAppend);  //New line
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }
}
