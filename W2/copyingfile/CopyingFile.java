// *****************************************************************
// CopyingFile.java             Author: Meta Arda Nabila
//
// Program that prompts the user for a filename, then opens a Scanner 
// to the file and copies it, a line at a time, to the standard output
// *****************************************************************
package copyingfile;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class CopyingFile {
    public static void main(String[] args) throws FileNotFoundException {
        String keepGoing = "y";
        Scanner scan = new Scanner(System.in);
        
        while (keepGoing.equals("y") || keepGoing.equals("Y")) {
            //get file name from user
            System.out.print("Enter file name: ");
            String filename = "D:\\Polban\\Semester 4\\Analisis dan Perancangan Perangkat Lunak 1\\Praktek\\Java\\w2\\CopyingFile\\src\\copyingfile\\"
                               +scan.nextLine();
            try{
                // read file
                File file = new File(filename);
                Scanner fileReader = new Scanner(file);

                // print file
                while(fileReader.hasNextLine()){
                    String text = fileReader.nextLine();
                    System.out.println(text);
                }
                keepGoing="n";
            }
            catch(FileNotFoundException e){
                System.out.println("The current file does not exist");
                System.out.println("Input another filename!");
                keepGoing = "y";
                filename = "";
            }
        }
    }
    
}
