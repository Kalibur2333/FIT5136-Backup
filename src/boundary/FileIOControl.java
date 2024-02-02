package boundary;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class FileIOControl {

    public FileIOControl(){

    }

    public ArrayList<String> readFile(String fileName){


        ArrayList<String> fileLines = new ArrayList<String>();

        try {
            FileReader inputFile = new FileReader(fileName);
            try {

                Scanner scanner = new Scanner(inputFile);

                while (scanner.hasNext()) {
                    String line = scanner.nextLine();//read a line
                    fileLines.add(line);
                }

            }
            finally {
                inputFile.close();
            }
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
            return null;
        }
        catch(IOException e){

            System.out.println("Unexpected I/O exception occurs");
        }
        return fileLines; // ArrayList<String>
    }
    public void writeFile(String fileName, String Line)
    {
        try
        {
            FileWriter writer = new FileWriter(fileName,true);
            writer.write(Line + "\n");
            writer.close();
        } catch (IOException e){
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}

