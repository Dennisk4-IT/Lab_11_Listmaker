import java.util.Scanner;

public class safeInput {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String name = getNonZeroLenString(in, "Enter your name");
        System.out.println("You have entered: " + name);
    }

    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.isEmpty());
        return retString;
    }

    public static int getInt(Scanner pipe, String prompt) {
        int value;
        while (true) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                value = pipe.nextInt();
                pipe.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine();
            }
        }
    }
    public static double getDouble(Scanner pipe, String prompt) {
        double value;
        while (true) {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                value = pipe.nextDouble();
                pipe.nextLine();
                return value;
            } else {
                System.out.println("Invalid input. Please enter a valid decimal number.");
                pipe.nextLine();
            }
        }
    }
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
        int value;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            while (!pipe.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine();
            }
            value = pipe.nextInt();
            pipe.nextLine(); // clear buffer
        } while (value < low || value > high);
        return value;
    }
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        String response;
        while (true) {
            System.out.print("\n" + prompt + " [Y/N]: ");
            response = pipe.nextLine().trim().toUpperCase();
            if (response.equals("Y")) {
                return true;
            } else if (response.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        }
    }
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
        String input;
        while (true) {
            System.out.print("\n" + prompt + ": ");
            input = pipe.nextLine();
            if (input.matches(regEx)) {
                return input;
            } else {
                System.out.println("Invalid input. Please use the correct format.");
            }
        }
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
        double retVal = 0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                if (retVal >= low && retVal <= high) {
                    isValid = true;
                } else {
                    System.out.println("Invalid input. Enter a number between " + low + " and " + high);
                }
            } else {
                System.out.println("Invalid input. Please enter a double.");
                pipe.next();
            }
        } while (!isValid);
        pipe.nextLine();
        return retVal;
    }
}





