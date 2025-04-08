import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> list = new ArrayList<>();
        boolean done = false;

        while (!done) {
            printMenu();
            printList(list);

            String choice = safeInput.getRegExString(in, "Enter choice [A/D/I/P/Q]", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    String newItem = safeInput.getNonZeroLenString(in, "Enter item to add to the list");
                    list.add(newItem);
                    break;

                case "D":
                    if (list.isEmpty()) {
                        System.out.println("List is empty. There isn't anything to delete.");
                        break;
                    }
                    int delIndex = safeInput.getRangedInt(in, "Enter the item number you want to delete", 1, list.size()) - 1;
                    list.remove(delIndex);
                    break;

                case "I":
                    if (list.isEmpty()) {
                        System.out.println("List is empty. Use Add first.");
                        break;
                    }
                    int insIndex = safeInput.getRangedInt(in, "Enter the position to insert at", 1, list.size() + 1) - 1;
                    String insItem = safeInput.getNonZeroLenString(in, "Enter the item you want to insert");
                    list.add(insIndex, insItem);
                    break;

                case "P":
                    printList(list);
                    break;

                case "Q":
                    boolean confirm = safeInput.getYNConfirm(in, "Quit the program?");
                    if (confirm) done = true;
                    break;
            }
        }

        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A – Add an item to the list");
        System.out.println("D – Delete an item from the list");
        System.out.println("I – Insert an item into the list");
        System.out.println("P – Print the list");
        System.out.println("Q – Quit the program");
    }

    private static void printList(ArrayList<String> list) {
        System.out.println("\nCurrent List:");
        if (list.isEmpty()) {
            System.out.println("[List is empty]");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.printf("%d. %s\n", i + 1, list.get(i));
            }
        }
    }
}
