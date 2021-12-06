package utilities;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

public class ManageDDT extends CommonOpps {
    @DataProvider(name="data-provider-book")
    public Object[][] getDataObject()
    {
        return getDataFromCSV(getConfigData("DDTFile"));   // ./ means from the relative path I'm now
    }

    /* The function 'getDataFromCSV' calls 'readCSV' function
     */
    public static Object[][] getDataFromCSV (String filePath)
    {
        Object[][] data = new Object[Integer.parseInt(getConfigData("CsvRows"))][Integer.parseInt(getConfigData("CsvColumns"))];
        List<String> csvData = readCSV(filePath);
        for (int i=0; i < csvData.size(); i++)
        {
            data[i][0] = csvData.get(i).split(",")[0]; // separate from all CSV only the 1st word in current line
            data[i][1] = csvData.get(i).split(",")[1]; // separate from all CSV only the 2nd word in current line
            data[i][2] = csvData.get(i).split(",")[2]; // separate from all CSV only the 3th word in current line
            data[i][3] = csvData.get(i).split(",")[3]; // separate from all CSV only the 4th word in current line
            data[i][4] = csvData.get(i).split(",")[4]; // separate from all CSV only the 5th word in current line
            data[i][5] = csvData.get(i).split(",")[5]; // separate from all CSV only the 6th word in current line
        }

        return data;

    }
    /* The function 'readCSV' receives path of CSV file (including file name),
       reads from this file and returns a list of Strings.
       * static: in order to read from other class without the need to create a new object;
    */
    public static List<String> readCSV(String csvFile)
    {
        List<String> lines = null; // the list of strings will represent the lines in file
        File file = new File(csvFile);  // create object from class File that receives the file path
        try // because we read an external file
        {   // initialize 'lines' that reads all lines and enters them in a list of Strings:
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        }
        catch (IOException e){
            System.out.println("Some Error. See Details: " + e);
        }
        return lines;

    }
}
