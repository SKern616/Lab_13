import java.util.Scanner;

public class InputHelper {
    //getNonZeroLenString method returns a string of non-zero length back to user
    public static String getNonZeroLenString(Scanner scan, String prompt) {
        System.out.println(prompt);
        boolean validInput = false;

        String userInput;
        do {
            userInput = scan.nextLine();

            if (userInput.length() > 0) {
                validInput = true;
            } else {
                System.out.println("ERROR - Invalid input! Please enter a non-zero length.");
            }
        } while (!validInput);

        return userInput;
    }

    public static int getInt(Scanner scan, String prompt){
        System.out.println(prompt);
        boolean validInput = false;
        int userInput = 0;

        do {
            if (scan.hasNextInt()){
                userInput = scan.nextInt();
                validInput = true;
            } else {
                System.out.println("ERROR - Invalid input! Please enter a valid integer:");
                scan.nextLine();
            }
        } while (!validInput);

        return userInput;
    }

    public static int getRangeInt(Scanner scan, String prompt, int min, int max){
        System.out.println(prompt);
        boolean validInput = false;
        int userInput = 0;

        do {
            if (scan.hasNextInt()){
                userInput = scan.nextInt();
                if (userInput >= min && userInput <= max) {
                    validInput = true;
                } else {
                    System.out.println("ERROR - Please enter a number between " + min + " and " + max + ":");
                    scan.nextLine();
                }
            } else {
                System.out.println("ERROR - Invalid input! Please enter a valid integer:");
                scan.nextLine();
            }
        } while (!validInput);

        return userInput;
    }

    public static double getRangedDouble(Scanner scan, String prompt, double min, double max){
        boolean valid = false;
        double userInput = 0;

        System.out.println(prompt);
        do {

            if (scan.hasNextDouble()){
                userInput = scan.nextDouble();

                if (userInput >= min && userInput <= max){
                    valid = true;
                } else {
                    System.out.println("ERROR - Please enter a number between " + min + " and " + max + "!");
                    scan.nextLine();
                }
            } else {
                System.out.println("ERROR - Please enter a valid input!");
                scan.nextLine();
            }
        } while (!valid);

        return userInput;
    }

    public static int getPositiveNonZeroInt(Scanner scan, String prompt){
        int userInput = 0;
        boolean valid = false;

        System.out.println(prompt);
        do {
            if (scan.hasNextInt()){
                userInput = scan.nextInt();

                if (userInput > 0){
                    valid = true;
                } else {
                    System.out.println("ERROR - Please enter a positive non-zero number!");
                    scan.nextLine();
                }
            } else {
                System.out.println("ERROR - Invalid input! Please enter a valid non-zero integer!");
                scan.nextLine();
            }
        } while(!valid);

        return userInput;
    }

    public static String getRegExString(Scanner scan, String prompt, String regExPattern){
        String userString;
        boolean valid = false;
        System.out.println(prompt);

        do {
            userString = scan.nextLine();
            if (userString.matches(regExPattern)) {
                valid = true;
            } else {
                System.out.println("ERROR - Invalid input! Please follow the pattern.");
            }
        } while (!valid);
        return userString;
    }

    public static double getDouble(Scanner scan, String prompt){
        System.out.println(prompt);
        boolean valid = false;
        double userInput = 0.0;
        do {
            if (scan.hasNextDouble()){
                userInput = scan.nextDouble();
                valid = true;
            } else {
                System.out.println("ERROR - Invalid input! Please enter a valid number!");
                scan.nextLine();
            }
        } while (!valid);

        return userInput;
    }

    public static boolean getYNConfirm(Scanner scan, String prompt) {
        System.out.println(prompt);
        boolean valid = false;
        boolean userChoice = false;
        String userInput;

        do {
            if (!scan.hasNextInt() && !scan.hasNextDouble()) {
                userInput = scan.nextLine();

                if (userInput.equalsIgnoreCase("Y")) {
                    userChoice = true;
                    valid = true;
                } else if (userInput.equalsIgnoreCase("N")) {
                    valid = true;
                } else {
                    System.out.println("ERROR - Invalid choice! Please enter Y or N!");
                }
            } else {
                System.out.println("ERROR - Invalid input! Please enter Y or N!");
                scan.nextLine();
            }
        } while (!valid);

        return userChoice;
    }
}