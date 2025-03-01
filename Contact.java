public class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructors
    public Contact() {}
    public Contact(String name, String phoneNumber, String email) {
        setName(name);
        setPhoneNumber(phoneNumber);
        setEmail(email);
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        if (Utility.areLetters(name)) {
            this.name = name;
        }
    }

    public void setEmail(String email) {
        if (Utility.isEmail(email)) {
            this.email = email;
        }
    }

    public void setPhoneNumber(String phoneNumber) {
        if (Utility.isPhoneNumber(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
    }

    // To String
    @Override
    public String toString() {
        return String.format("Name: %s\nPhone: %s\nE-Mail: %s\n", name, phoneNumber, email);
    }
}
