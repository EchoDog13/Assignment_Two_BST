import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * This class functions as a commmand line interface for the DictionaryLookup
 * class
 * Provides various operations that apply to the DictonaryBST, including
 * searching if the class contains a value
 * adding a word and its definition, removming a word and its defintion,
 * printing a word and its defition, as well as printing the whole dictonary
 * including both the words and their definitions in alphabetical order
 * 
 * The program reads a text file, and inserts the word and its definition into
 * the dictionary, creating a BST ordred alphabetically using.
 * 
 * @version
 * @author Kyle Barker
 */
public class DictionaryLookup {

    /**
     * Main method of dictonary command line interface
     * 
     * @param args
     */
    public static void main(String[] args) {
        String fileName = "CS-Dictionary-full.txt";
        DictionaryBST dictionary = new DictionaryBST();

        readFile(dictionary, fileName);

        userInput(dictionary);

    }

    /**
     * Method to read words and their definitions from text file into dictonary
     * 
     * @param dictionary dictonary used to store the words and their definitions
     *                   into
     * @param fileName   name of file to read text input from
     */

    public static void readFile(DictionaryBST dictionary, String fileName) {

        try {
            // Read in file
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);

            System.out.println("Loading dictionary from file ...");

            // Continue to end of file
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine().trim();

                // Skip blank lines
                if (data.trim().isEmpty()) {
                    continue;
                }

                // Split line into word and definition
                String delimitString[] = data.split(":");
                dictionary.insert(delimitString[0], delimitString[1]);
            }

            // close file reader
          //  fileScanner.close();

            System.out.println();
            System.out.println("Dictionary succesfully imported");
            System.out.println();
            System.out.println("Welcome to the Dictionary Lookup!");
        } catch (FileNotFoundException e) {
            System.out.println(
                    "An error occurred when importing the dictionary ... check the input file exists and is formatted correctly");
            e.printStackTrace();
        }
    }

    /**
     * Method that prints possible operations the user can perform
     */
    public static void printOptions() {
        System.out.println("(1) Search for a word/phrase in the dictionary");
        System.out.println("(2) Print a given word/phrase and it's definition");
        System.out.println("(3) Add a word/phrase and definition to the dictionary");
        System.out.println("(4) Remove a word/phrase and definition from the dictionary");
        System.out.println("(5) Print all of the words/phrases and their definitions, in alphabetical order");
        System.out.println("(6) Exit");
    }

    /**
     * Method to read the user input into the command line
     * Also calls runCommand to allow for the user selected command to be run on the
     * dictionary
     * 
     * @param dictionary dictonary used
     */

    public static void userInput(DictionaryBST dictionary) {
        // stores the command selected by the user
        int instruction = 0;
        // boolean to
        boolean continueOperation = true;

        Scanner inputScan = new Scanner(System.in);

        // continue to allow user input while true
        while (continueOperation == true) {
            System.out.println();
            
            System.out.println("Press any key to continue...");

            inputScan.nextLine();

            // prints commands user can run
            printOptions();

            System.out.println("Please enter a number to indicate what you would like to do");
            try {
                // stores command selected by user commandline input
                instruction = Integer.parseInt(inputScan.nextLine());

                // calls run command to execute the command, expects return to check if program
                // should allow more commands
                continueOperation = runCommand(instruction, dictionary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
            }

        }
       // inputScan.close();
    }

    /**
     * Method which executes the desired command, and gets required information specifc to command's requirements
     * @param excecutionTask number of which command needs to be executed
     * @param dictionary     the BST dictionary
     * @return bool to determine if the program should loop to allow another user
     *         command to be executed
     */
    public static boolean runCommand(int excecutionTask, DictionaryBST dictionary) {

        try {
            if (excecutionTask == 1) {
                System.out.println("Searching the dictionary ...");
                // calls to get the 'value' to search for
                String value = getValue();

                System.out
                        .println("The word/phrase " + value + " exists in the dictionary: " + dictionary.search(value));
                return true;

            } else if (excecutionTask == 2) {
                System.out.println("Printing dictionary item ...");

                String value = getValue();
                //function to find the word in the BST, printing the word and its definitions
                dictionary.printDictonaryItem(value);
                return true;

            } else if (excecutionTask == 3) {
                //scanner used to readline to get defintion
                Scanner inputDefinition = new Scanner(System.in);
                String definition;

                System.out.println("Adding dictionary item ...");

                String value = getValue();

                System.out.println("Now please enter the definition");
                //reads defintion and stores string in defintion
                definition = inputDefinition.nextLine();

                //calls insert method on dictionary
                dictionary.insert(value, definition);
                System.out.println("The dictionary now contains " + value + " and its definition");
                //inputDefinition.close();
                return true;

            } else if (excecutionTask == 4) {
                System.out.println("Removing dictionary item ...");
                String value = getValue();
                //calls method to remove a value and its definition from the dictionary BST
                dictionary.remove(value);
                return true;

            } else if (excecutionTask == 5) {
                System.out.println("Printing the full dictonary ...");
                //calls method to print the whole dictionary, printing each word and its defition
                dictionary.printDictonary();
                return true;

            } else if (excecutionTask == 6) {
                //returns false to exit while loop, and prevent any more user inputs
                return false;

            } else {
                //catches invalid input
                System.out.println("Invalid Selection - try again");

                return true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }

    }
/**
 * Method which asks and read user input to get the word they wish to perform their selected operation on
 * @return the word which the operation will be performed on
 */
    public static String getValue() {
        //string to store user inputted phrase
        String word;
        System.out.println("Please enter the word/phrase you wish to perform the selected operation on:");
        //initalise scanner to read user input
        Scanner inputScan = new Scanner(System.in);
        //reads string inputted by users and stores in word to be returned
        word = inputScan.nextLine();
       
        return word;
    }
}
