package Lesson5;

import java.io.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args)  {
        String[] headers = {"Val1", "Val2", "Val3"};
        int[][] data = {
                {78, 90, 99},
                {67, 88, 90}
        };

        AppData appData = new AppData(headers);
        appData.setData(data);
        appData.getData();
        appData.getHeader();

        try (PrintWriter out = new PrintWriter("File.csv")) {
            for (String header : appData.getHeader()) {
                out.print(header);
                out.print(";");

            }
            for (int[] items : appData.getData()) {
                out.println("");
                for (int item : items) {
                    out.print(item);
                    out.print(";");
                }
            }
        } catch (FileNotFoundException exception) {
            exception.printStackTrace();
        }

        ArrayList <ArrayList> dataArraylist = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("File.csv"))) {
            String tempString;
            while ((tempString = bufferedReader.readLine()) != null){
                String[] values = tempString.split(";");
                ArrayList<String> row = new ArrayList<>();
                row.add(values[0]);
                row.add(values[1]);
                row.add(values[2]);
                dataArraylist.add(row);
            }
        } catch (FileNotFoundException exception){
            exception.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }

        System.out.println(dataArraylist);
        String[] headArray = new String[dataArraylist.get(0).size()];
        AppData appData1 = new AppData(headArray);


    }
}
