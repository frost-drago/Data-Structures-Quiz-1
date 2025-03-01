import java.util.LinkedList;

public class ContactBook {
    private LinkedList<Contact> contacts;

    // Constructors
    public ContactBook() {
        contacts = new LinkedList<>();
    }

    // Methods
    /**
     * Get size of the contact list.
     * @return int size.
     */
    public int getSize() {
        return contacts.size();
    }

    /**
     * Add a contact.
     * @param aContact A Contact.
     */
    public void addContact(Contact aContact) {
        contacts.add(aContact);
    }

    /**
     * Delete a contact by index.
     * @param index Zero-indexed.
     */
    public void deleteContact(int index) {
        contacts.remove(index);
    }

    /**
     * Get contact by index. Not used, but another programmer may want it.
     * @param index Zero-indexed.
     * @return A Contact.
     */
    public Contact getContactByIndex(int index) {
        return contacts.get(index);
    }

    /**
     * Get contact by e-mail. Case-sensitive.
     * @param email Input e-mail in String.
     * @return A Contact, else null if not found.
     */
    public Contact getContactByEmail(String email) {
        for (Contact aContact : contacts) {
            if (aContact.getEmail().equals(email)) {
                return aContact;
            }
        }
        return null;
    }

    /**
     * Get contact by name. Case-sensitive.
     * @param name Input name in String.
     * @return A Contact, else null if not found.
     */
    public Contact getContactByName(String name) {
        for (Contact aContact : contacts) {
            // IntelliJ made aContact.getName().toLowerCase().equals(name.toLowerCase()) into that
            if (aContact.getName().equalsIgnoreCase(name)) {
                return aContact;
            }
        }
        return null;
    }

    /**
     * Searches substring from names, phone numbers, and e-mails.
     * @param query A string query.
     * @return A LinkedList of Contacts that has a substring that matches the query.
     */
    public LinkedList<Contact> search(String query) {
        LinkedList<Contact> matches = new LinkedList<Contact> ();
        for (Contact aContact : contacts) {
            // Compare name substring
            if (aContact.getName().toLowerCase().contains(query.toLowerCase())
            // Compare phone number substring
                || aContact.getPhoneNumber().toLowerCase().contains(Utility.cleanPhoneNumber(query))
            // Compare email substring
                || aContact.getEmail().toLowerCase().contains(query.toLowerCase()))
            // If one of these is true, then add contacts in list
            {
                matches.add(aContact);
            }
        }

        // Print
        printContactList(matches);

        // Also return just in case another programmer needs it.
        return matches;
    }

    /**
     * Prints all contacts in a table.
     */
    public void printAllContacts() {
        printContactList(contacts);
    }

    /**
     * Prints a table of names, phone number, and e-mail.
     * @param contactList A LinkedList that stores Contacts.
     */
    private void printContactList(LinkedList<Contact> contactList) {
        System.out.println("═".repeat(3) + "╤" + "═".repeat(30) + "╤" + "═".repeat(20) + "╤" + "═".repeat(30));
        System.out.printf("No.│%-30s│%-20s│%-30s\n", "NAME", "PHONE NUMBER", "E-MAIL");
        System.out.println("═".repeat(3) + "╪" + "═".repeat(30) + "╪" + "═".repeat(20) + "╪" + "═".repeat(30));
        int number = 1;
        for (Contact aContact : contactList) {
            System.out.printf("%3d│%-30s│%-20s│%-30s\n", number, aContact.getName(), aContact.getPhoneNumber(), aContact.getEmail());
            number++;
        }
    }
}
