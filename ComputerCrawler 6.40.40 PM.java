/*
* To change this template, choose Tools | Templates
* and open the template in the editor.
*/

 
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
 
/**
*
* @author vimal
*/
public class ComputerCrawler {
 
    /**
    * @param args the command line arguments
    */

    static int numOfAttributes = 0;
    static String curUrl;
    public static void main(String[] args)  {
        int numberOfComputers = 0;
        try {
            numberOfComputers = urlCount("/Users/Matt/Documents/Penn_2013-2014/CIS-120/Java_Workspace/computerWebsites.txt");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //change numOfAttributes for each new attribute
        numOfAttributes = 20;
        String[][] database = new String[numOfAttributes + 1][numberOfComputers + 1];
        String[] stopCodes = new String[numOfAttributes];
        //add one database entry and one stopCodes entry for each new attribute
        database[0][0] = "Brand";
        stopCodes[0] = "</dd></dl><dl><dt>Series";
        database[1][0] = "Series";
        stopCodes[1] = "</dd></dl><dl><dt>Model";
        database[2][0] = "Model</d";
        stopCodes[2] = "</dd></dl><dl><dt>Part#";
        database[3][0] = "Operating System";
        stopCodes[3] = "</dd></dl><dl><dt>CPU Type";
        database[4][0] = "CPU Type";
        stopCodes[4] = "</dd></dl><dl><dt>Screen";
        database[5][0] = "Screen";
        stopCodes[5] = "</dd></dl><dl><dt>Memory Size";
        database[6][0] = "Memory Size";
        stopCodes[6] = "</dd></dl><dl><dt>Hard Disk";
        database[7][0] = "Hard Disk";
        stopCodes[7] = "</dd></dl><dl><dt>Optical Drive</dt><dd>";
        database[8][0] = "Optical Drive</dt><dd>";
        stopCodes[8] = "</dd></dl><dl><dt>Graphics Card";
        database[9][0] = "Graphics Card";
        stopCodes[9] = "</dd></dl><dl><dt>Video Memory";
        database[10][0] = "Weight";
        stopCodes[10] = ".<";
        database[11][0] = "Battery Life";
        stopCodes[11] = " hours";
        database[12][0] = "CPU Support";
        stopCodes[12] = "Cache<";
        database[13][0] = "Video Memory";
        stopCodes[13] = "</dd></dl><dl><dt>Communication";
        database[14][0] = "Resolution";
        stopCodes[14] = "</dd></dl><dl><dt>LCD Features";
        database[15][0] = "HDD RPM";
        stopCodes[15] = "rpm";
        database[16][0] = "Touchscreen";
        stopCodes[16] = "<";
        database[17][0] = "HDMI";
        stopCodes[17] = "<";
        database[18][0] = "VGA";
        stopCodes[18] = "<";
        database[19][0] = "Bluetooth";
        stopCodes[19] = "<";
        database[numOfAttributes][0] = "URL";
        try {
            @SuppressWarnings("resource")
            BufferedReader urlRead = new BufferedReader(new FileReader("/Users/Matt/Documents/Penn_2013-2014/CIS-120/Java_Workspace/computerWebsites.txt"));
            int computerNumber = 1;
            while(urlRead.ready()) {
                curUrl = urlRead.readLine();                
                URL my_url = new URL(curUrl);
                BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream()));
                String strTemp = "";
                while(null != (strTemp = br.readLine())){
                    if (strTemp.contains(">Model</h3><dl><dt>Brand<")) {
                        System.out.println("strTemp = "+strTemp);
                        for (int i = 0; i < numOfAttributes; i++) {
                            System.out.println(database[i][0] + " " +stopCodes[i]);
                            database[i][computerNumber] = findAttribute(strTemp,database[i][0],stopCodes[i]);
                        }
                        database[numOfAttributes][computerNumber] = curUrl;
                        computerNumber++;
                        break;
                    }
                }
            }
        resetHeaders(database);
        printDatabase(database, numberOfComputers);
        saveDatabase(database, numberOfComputers);

        } catch (Exception ex) {
            ex.printStackTrace();
        }     
    }
    
    public static String[][] resetHeaders(String[][] database) {
        database[2][0] = "Model";
        database[7][0] = "Hard Drive";
        database[8][0] = "Optical Drive?";
        database[11][0] = "Battery Life (Hours) or Battery Type";
        database[12][0] = "Cache Memory";
        database[15][0] = "Hard Drive RPM";
        return database;
        
    }
    
    public static void printDatabase(String[][] database, int entries) {
        for (int i = 0; i < (1 + entries); i++) {
            for (int j = 0; j <= numOfAttributes ; j++) {
                System.out.print(" | "+database[j][i]);
            }
            System.out.println(" |");
        }
    }
    
    public static void saveDatabase(String[][] database, int entries){
        try {
            PrintWriter out;
            String outputFilename = "textOutput"+System.currentTimeMillis()+".txt";
            out = new PrintWriter(new FileWriter(outputFilename));
            for (int i = 0; i < (1 + entries); i++) {
                for (int j = 0; j <= numOfAttributes ; j++) {
                    out.print(" | "+database[j][i]);
                }
                out.println(" |");
            }
            out.close();
        } catch (IOException e) {
        System.out.println("IOException e");
        }   
    }    

    private static String findAttribute(String strTemp, String attributeStart, String attributeEnd) {
        char[] curPrint = new char[200];
        if ((attributeStart == "Touchscreen" || attributeStart == "HDMI") 
                || (attributeStart == "VGA" || attributeStart == "Bluetooth")) {
            if (strTemp.contains(attributeStart)) {
                return "Has "+attributeStart;               
            }
            else {
                return "Does Not Have "+attributeStart;
            }
        }
        int curPrintStart = strTemp.indexOf(attributeStart);
        System.out.println("curPrintStart = "+curPrintStart);
        int curPrintEnd = strTemp.indexOf(attributeEnd);
        
        if (attributeStart == "Hard Disk" && curPrintEnd == -1) {
            curPrintEnd = strTemp.indexOf("</dd></dl><dl><dt>Graphics Card");
        }
        if (attributeStart == "Optical Drive</dt><dd>" && curPrintStart == -1) {
            return "No Optical Drive";
        }   
        if (attributeStart == "Series" && curPrintStart == -1) {
            return "No Series Number";
        }
        if (attributeStart == "Battery Life" && curPrintStart == -1) {
            curPrintStart = strTemp.indexOf("Battery");
            curPrintStart -= 5;
        }
        if (attributeStart == "Video Memory" && curPrintStart == -1) {
            return "Shared system memory";
        }
        if (attributeStart == "HDD RPM" && curPrintStart == -1) {
            return "5400";
        }
        
        String returnString = "";
        
        if (curPrintStart != -1 && curPrintEnd != -1) {
            if (attributeStart == "Model</d") {
                curPrintStart = curPrintStart - 3;
            }
            if (attributeStart == "Series" && curPrintEnd == -1) {
                curPrintEnd = strTemp.indexOf("</dd></dl><dl><dt id=");
            }
            strTemp.getChars(curPrintStart + 9 + attributeStart.length(),curPrintEnd, curPrint, 1);
            
            for (Character c : curPrint) {
                returnString += c;
            }
            if (returnString.contains("Mac OS") && returnString.contains("tdDetailValue")) {
                System.out.println("It's Mac OS time! and the ret string = "+returnString);
                System.out.println(returnString.charAt(1));
                System.out.println(returnString.charAt(returnString.length()-2));
                int macOPSysStart = returnString.indexOf("Mac OS");
                int macOPSysEnd = returnString.indexOf("<input type=");
                System.out.println("start = "+macOPSysStart+" end = "+macOPSysEnd);
                System.out.println(returnString.charAt(macOPSysStart) + " "+returnString.charAt(macOPSysStart + 1));
                String returnStringMac = "";
                for (int i = macOPSysStart; i < macOPSysEnd; i++) {
                    returnStringMac += returnString.charAt(i);
                }
                returnString = returnStringMac;
            }
            if (returnString.contains("tdDetailValue_398_49551")) {
                System.out.println("It's Mac Screen Size Time");
                int macScreenStart = 15 + returnString.indexOf("display");
                int macScreenEnd = macScreenStart + 5;
                String returnStringMac = "";
                for (int i = macScreenStart; i < macScreenEnd; i++) {
                    returnStringMac += returnString.charAt(i);
                }
                returnString = returnStringMac;
            }
        }
        else if (curPrintStart != -1 && curPrintEnd == -1) {
            if (attributeStart == "Model</d") {
                curPrintStart = curPrintStart - 3;
            }
            curPrintStart += 9 + attributeStart.length();
            int curChar = 0;
            while (curChar != 60) {
                returnString += strTemp.charAt(curPrintStart);
                System.out.print("returnString = "+returnString+" and curPrintStart = "+curPrintStart);
                curPrintStart++;
                curChar = strTemp.charAt(curPrintStart);
                System.out.println(" and curChar = "+curChar);
                
            }
        }
        else {
            return "null";      
        }
        return returnString;
    }
    
    public static int urlCount(String filename) throws IOException {
        InputStream is = new BufferedInputStream(new FileInputStream(filename));
        try {
            byte[] c = new byte[1024];
            int count = 0;
            int readChars = 0;
            boolean empty = true;
            while ((readChars = is.read(c)) != -1) {
                empty = false;
                for (int i = 0; i < readChars; ++i) {
                    if (c[i] == '\n') {
                        ++count;
                    }
                }
            }
            count++;
            return (count == 0 && !empty) ? 1 : count;
        } finally {
            is.close();
        }
    }
}
