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
    /**
     * 
     * @param dictionary
     * @param fileName
     */

    public static void readFile(DictionaryBST dictionary, String fileName) {

        try {
            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            System.out.println("Loading dictionary from file ...");
            while (fileScanner.hasNextLine()) {
                String data = fileScanner.nextLine().trim();
                // System.out.println(data);
                if (data.trim().isEmpty()) {
                    continue; // Skip to the next iteration of the loop
                }
                String delimitString[] = data.split(":");

                dictionary.insert(delimitString[0], delimitString[1]);
            }
            fileScanner.close();
            System.out.println();
            System.err.println("Dictionary succesfully imported");
            System.out.println();
            System.out.println("Welcome to the Dictionary Lookup!");
        } catch (FileNotFoundException e) {
            System.out.println(
                    "An error occurred when importing the dictionary ... check the input file exists and is formatted correctly");
            e.printStackTrace();
        }
    }

    public static void printOptions() {
        // System.out.println();
        System.out.println("(1) Search for a word/phrase in the dictionary");
        System.out.println("(2) Print a given word/phrase and it's definition");
        System.out.println("(3) Add a word/phrase and definition to the dictionary");
        System.out.println("(4) Remove a word/phrase and definition from the dictionary");
        System.out.println("(5) Print all of the words/phrases and their definitions, in alphabetical order");
        System.out.println("(6) Exit");
    }

    public static void userInput(DictionaryBST dictionary) {
        int instruction = 0;
        boolean continueOperation = true;
        Scanner inputScan = new Scanner(System.in);

        while (continueOperation == true) {
            System.out.println();
            System.out.println("Press any key to continue...");
            inputScan.nextLine();

            printOptions();

            System.out.println("Please enter a number to indicate what you would like to do");
            try {
                instruction = Integer.parseInt(inputScan.nextLine());

            continueOperation = runCommand(instruction, dictionary);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number from 1 to 6.");
            }
            
        }
        inputScan.close();
    }

    public static boolean runCommand(int excecutionTask, DictionaryBST dictionary) {

        try {
            if (excecutionTask == 1) {
                // CHECK CASE SENSTIVE
                System.out.println("Searching the dictionary ...");
                String value = getValue();

                System.out
                        .println("The word/phrase " + value + " exists in the dictionary: " + dictionary.search(value));
                return true;

            } else if (excecutionTask == 2) {
                System.out.println("Printing dictionary item ...");
                String value = getValue();

                dictionary.printDictonaryItem(value);
                return true;

            } else if (excecutionTask == 3) {

                Scanner inputDefinition = new Scanner(System.in);

                String definition;
                System.out.println("Adding dictionary item ...");
                String value = getValue();

                System.out.println("Now please enter the definition");
                definition = inputDefinition.nextLine();
                dictionary.insert(value, definition);
                System.out.println("The dictionary now contains " + value + " and its definition");

                return true;

            } else if (excecutionTask == 4) {
                System.out.println("Removing dictionary item ...");
                String value = getValue();

                dictionary.remove(value);
                return true;

            } else if (excecutionTask == 5) {
                System.out.println("Printing the full dictonary ...");
                dictionary.printDictonary();
                return true;
            } else if (excecutionTask == 6) {
                return false;

            } else {
                System.out.println("Invalid Selection - try again");

                return true;
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return true;
        }

    }

    public static String getValue() {
        String word;
        System.out.println("Please enter the word/phrase you wish to perform the selected operation on:");
        Scanner inputScan = new Scanner(System.in);
        word = inputScan.nextLine();
        return word;
    }
}
