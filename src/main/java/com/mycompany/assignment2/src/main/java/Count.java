
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public interface Count {
  
    String FILE_IN = "F:\\UUM\\SEM 5\\RealTimeProgramming\\Assignment 2\\PracticumList.xlsx";
    String FILE_OUT ="F:\\UUM\\SEM 5\\RealTimeProgramming\\Assignment 2\\Practicum.txt";
    
    
    public static void run() {

        Writer w = null;
      
        boolean lbreak = true;
    

        try {

            DataFormatter date = new DataFormatter();

            FileInputStream excelFile = new FileInputStream(new File(FILE_IN));
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            File f = new File(FILE_OUT);
            w = new BufferedWriter(new FileWriter(f));

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();
                Iterator<Cell> cellIterator = currentRow.iterator();
                while (cellIterator.hasNext()) {

                    Cell currentCell = cellIterator.next();
                    String d = date.formatCellValue(currentCell);
                    w.write(d + " ");
                }
                w.write("\r\n");
                if (lbreak == true) {

                    lbreak = false;
                }

            }

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }

        try {
            if (w != null) {
                w.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void countcharacter() throws IOException
    {
        File file = new File ("F:\\UUM\\SEM 5\\RealTimeProgramming\\Assignment 2\\Practicum.txt");
        FileInputStream fileStream = new FileInputStream(file);
        InputStreamReader input = new InputStreamReader(fileStream);
        BufferedReader reader = new BufferedReader(input);
         
        String line;
         
        // Initializing counters
        int countWord = 0;
        int sentenceCount = 0;
        int characterCount = 0;
        int paragraphCount = 1;
        int whitespaceCount = 0;
        
         
        // Reading line by line from the 
        // file until a null is returned
        while((line = reader.readLine()) != null)
        {
            
            if(line.equals(""))
            {
                paragraphCount++;
            }
            if(!(line.equals("")))
            {
                 
                characterCount += line.length();
               
                 
                // \\s+ is the space delimiter in java
                String[] wordList = line.split("\\s+");
                 
                countWord += wordList.length;
                whitespaceCount += countWord -1;
                 
                // [!?.:]+ is the sentence delimiter in java
                String[] sentenceList = line.split("[!?.:]+");
                 
                sentenceCount += sentenceList.length;        
            }
                
        }
         
        System.out.println("Total word count = " + countWord);
        System.out.println("Total number of sentences = " + sentenceCount);
        System.out.println("Total number of characters = " + characterCount);
        System.out.println("Total number of whitespaces = " + whitespaceCount);   
      
        String fileName = "F:\\UUM\\SEM 5\\RealTimeProgramming\\Assignment 2\\Count.md";

        try {
           
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
           
            bufferedWriter.write("Total word count = " + countWord);
            bufferedWriter.write("\n");
            bufferedWriter.write("Total number of sentences = " + sentenceCount);
            bufferedWriter.write("\n");
            bufferedWriter.write("Total number of characters = " + characterCount);
            bufferedWriter.write("\n");
            bufferedWriter.write("Total number of whitespaces = " + whitespaceCount);

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(
                    "Error writing to file '" + fileName + "'");
        }
    }
}
    
