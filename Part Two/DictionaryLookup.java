import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DictionaryLookup {

    public static void main(String[] args) {
        String fileName = "CS-Dictionary-full.txt";
        DictionaryBST dictionary = new DictionaryBST();
        int excecutionTask = 0;

        readFile(dictionary, fileName);
        userInput(dictionary);
     

    }

    public static void readFile(DictionaryBST dictionary, String fileName) {

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            System.out.println("Loading dictionary from file ...");
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine().trim();
                //  System.out.println(data);
                if (data.trim().isEmpty()) {
                    continue; // Skip to the next iteration of the loop
                }
                String delimitString[] = data.split(":");
                
                dictionary.insert(delimitString[0], delimitString[1]);
            }
            fileScanner.close();
            System.out.println("Welcome to the Dictionary Lookup!");
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void printOptions() {
        System.out.println("(1) Search for a word/phrase in the dictionary");
        System.out.println("(2) Print a given word/phrase and it's definition");
        System.out.println("(3) Add a word/phrase and definition to the dictionary");
        System.out.println("(4) Remove a word/phrase and definition from the dictionary");
        System.out.println("(5) Print all of the words/phrases and their definitions, in alphabetical order");
        System.out.println("(6) Exit");
    }

    public static void userInput(DictionaryBST dictionary) {
        boolean exit = false;
        int instruction = 0;
        String value;
        Scanner inputScan = new Scanner(System.in);

        while (exit == false) {
            printOptions();
            System.out.println("Please enter a number to indicate what you would like to do");
            instruction = Integer.parseInt(inputScan.nextLine());

            if (!(instruction >= 1 && instruction <= 6)) {
                System.out.println("Invalid Input, please try again");
            } else {

                System.out.println("Please enter the word/phrase:");
                value = inputScan.nextLine();
                runCommand(instruction, value, dictionary);
                exit = true;

            }

        }

    }

    public static void runCommand(int excecutionTask, String value, DictionaryBST dictionary) {

        try {
            if (excecutionTask == 1) {
                System.out.println("Searching the dictionary ...");
               
                System.out.println("The word/phrase 'Binary' exists in the dictionary:"  + dictionary.search("binary"));
               // dictionary.printDictonary();
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
}
