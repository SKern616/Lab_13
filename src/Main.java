import jdk.internal.util.xml.impl.Input;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static ArrayList <String> lists = new ArrayList<String>();

    private static Scanner scan = new Scanner(System.in);

    static boolean fileSaved = false;

    public static void main(String[] args) throws IOException {
        boolean userQuit = false;
        boolean fileOpened = false;
        boolean fileEdited = false;
        boolean userClear = false;
        String userChoice;

        System.out.println("Welcome to ListMaker9000!");
        arrayPrint();

        do {

            System.out.println("Choose an option from the menu:");
            userChoice = InputHelper.getRegExString(scan, "A - Add an entry to the list\nD - Delete an entry from the list\nP - Print the list\nQ - Quit the program\nO - Open a list\nS - Save the list\nC - Clear the list", "[AaDdPpQqOoSsCc]");

            if (userChoice.equalsIgnoreCase("A")) {
                arrayAdd(scan);
                fileEdited = true;
            }

            if (userChoice.equalsIgnoreCase("D")) {
                arrayDelete(scan);
                fileEdited = true;
            }

            if (userChoice.equalsIgnoreCase("P")) {
                arrayPrint();
            }

            if (userChoice.equalsIgnoreCase("Q")) {
                userQuit = programQuit(scan);
            }

            if (userChoice.equalsIgnoreCase("O")){
                clearList();
                IOHelper.openFile(lists);
                fileOpened = true;
            }

            if (userChoice.equalsIgnoreCase("S")){
                System.out.println("Name your file or enter an existing file name:");
                String fileName = scan.nextLine();

                IOHelper.writeFile(lists, fileName);

                System.out.println("Your file has been saved as: " + fileName);
                fileSaved = true;
            }

            if (userChoice.equalsIgnoreCase("C")) {
                userClear = InputHelper.getYNConfirm(scan, "Are you sure you'd like to clear the list?");
                if (userClear) {
                    clearList();
                } else {
                    System.out.println("Action canceled...");
                }
            }

        } while (!userQuit);
    }

    private static void arrayAdd(Scanner scan){
        String newString = InputHelper.getNonZeroLenString(scan, "What would you like to add?:");
        lists.add(newString);
        fileSaved = false;
    }

    private static void arrayDelete(Scanner scan){
        int index = InputHelper.getRangeInt(scan, "What would you like to remove? (Starting at 0): ", 0, lists.size() - 1);
        lists.remove(index);
        scan.nextLine();
        fileSaved = false;
    }

    private static void arrayPrint(){

        if (lists.isEmpty()) {
            System.out.println("List is empty!");
        } else {
            for (int i = 0; i < lists.size(); i++) {
                System.out.println(i + " - " + lists.get(i));
            }
        }

    }

    private static boolean programQuit(Scanner scan) {
        String prompt;
        if (!fileSaved) {
            prompt = "You have unsaved changes. Are you sure would you like to quit?";
        } else {
            prompt = "Are you sure you would like to quit?";
        }
        boolean userYN = InputHelper.getYNConfirm(scan, prompt);

        return  userYN;
    }

    private static void clearList(){
        lists.clear();
    }
}