import java.util.Scanner;

public class Menu {

    public Menu () {}

    /**
     * Just prints the menu.
     */
    public void printMenu () {
        System.out.println("*".repeat(30));
        System.out.println("(A)dd");
        System.out.println("(D)elete");
        System.out.println("(E)mail Search");
        System.out.println("(S)earch");
        // Print List wedged in between Email Search and Search feels weird, so I reordered it
        System.out.println("(P)rint List");
        System.out.println("(Q)uit");
        System.out.println("*".repeat(30));
    }

    /**
     * Get user answer, but only accepts A,D,E,S,P,Q only.
     * Will keep asking until user enters one of the valid ones.
     * @param scanner Scanner.
     * @return A valid String consisting of a single character.
     */
    public String getUserAnswer (Scanner scanner) {
        String command;
        while (true) {
            System.out.println("Please enter a command: ");
            command = scanner.nextLine();
            if (command.matches("[aAdDeEpPsSqQ]")) {
                return command.toUpperCase();
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * Get user input and outputs a contact.
     * @param scanner Scanner.
     * @return a Contact.
     */
    public Contact getContact (Scanner scanner) {
        System.out.println("Please enter name: ");
        String name = scanner.nextLine();
        System.out.println("Please enter phone number: ");
        String phoneNumber = scanner.nextLine();
        System.out.println("Please enter e-mail: ");
        String email = scanner.nextLine();
        return new Contact(name, phoneNumber, email);
    }

    /**
     * Manage the main menu.
     * @param command The user's String command.
     * @param contacts The ContactBook.
     * @param scanner Scanner.
     */
    public void handleCommand(String command, ContactBook contacts, Scanner scanner) {
        switch (command) {
            case "A": // Add
                System.out.println("You selected 'Add'. Perform add action.");
                contacts.addContact(getContact(scanner));
                break;

            case "D": // Delete
                System.out.println("You selected 'Delete'.\nPlease enter an index (1-indexed) to delete.");
                int toDelete;
                try {
                    toDelete = Integer.parseInt(scanner.nextLine());
                    if ((toDelete > 0) && (contacts.getSize() > toDelete)) {
                        contacts.deleteContact(toDelete - 1);
                    } else {
                        System.out.println("Out of range. Failed to delete.");
                    }
                } catch (Exception exception) {
                    System.out.println("User did not enter a number. Failed to delete.");
                }
                break;

            case "E": // Email Search
                System.out.println("You selected 'Email Search'.\nEnter e-mail to search.");
                Contact searched = contacts.getContactByEmail(scanner.nextLine());
                if (searched != null) {
                    System.out.println(searched);
                } else {
                    System.out.println("Not found.");
                }
                break;

            case "S": // Search
                System.out.println("You selected 'Search'.\nEnter a query.");
                contacts.search(scanner.nextLine());
                break;

            case "P": // Print List
                System.out.println("You selected 'Print List'.");
                contacts.printAllContacts();
                break;

            case "Q": // Quit
                System.out.println("You selected 'Quit'. Exiting the program.");
                System.exit(0);
                break;

            default:
                System.out.println("Unexpected. How did you end up here?");
                break;
        }
    }

    // The main...
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();
        ContactBook contacts = new ContactBook();
        String userChoice;
        while (true) {
            menu.printMenu();
            userChoice = menu.getUserAnswer(scanner);
            menu.handleCommand(userChoice, contacts, scanner);
        }
    }

}
