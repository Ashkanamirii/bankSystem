package bank;



import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class History {
    List<Customer> customerList;



    public void saveToFile(List<Customer> customerList) throws ParseException {
        System.out.println(" list\n " + customerList);
        String filePathOut = "CustomerList.txt";
        String textToAppend = customerList.get(0).toString();
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
