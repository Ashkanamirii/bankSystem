package bank;

import java.io.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class DataBase {


    public DataBase(){

        String csVFile = "src/bank/Bank_fil_example.csv";
        String line ="";
        String csvSplitBy = ",";


        try(BufferedReader br = new BufferedReader(new FileReader(csVFile))){

            while ((line = br.readLine()) != null){
                String[] current = line.split(csvSplitBy);

                System.out.println("Account: " + current[0] + " Accnr: " + current[1] + " Amount: " + current[2] + " Description: " + current[3] + " Balance: " + current[4] + " Timestamp: " + current[5] );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args){

        new DataBase();

    }

}
