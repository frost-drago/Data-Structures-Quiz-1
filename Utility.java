// A utility class.
public class Utility {

    /**
     * Checks if everything are letters (or space).
     * @param inputString Input String.
     * @return boolean; true if everything are letters, false otherwise.
     */
    public static boolean areLetters(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }
        return inputString.matches("[a-zA-Z\\s]+");
    }

    /**
     * Checks if input string is in the _@_._ format.
     * @param inputString Input String.
     * @return boolean; true if email is valid, false otherwise.
     */
    public static boolean isEmail (String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return false;
        }
        // Regex for e-mail validation
        String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

        return inputString.matches(regex);
    }

    /**
     * Checks if input is a phone number. "+XX XXX-XXX-XXXX" formats are acceptable. Needs 7-15 digits.
     * @param inputString Input String.
     * @return boolean; true if phone number is valid, false otherwise.
     */
    public static boolean isPhoneNumber (String inputString) {

        if (inputString == null || inputString.isEmpty()) {
            return false;
        }
        String cleanedNumber = cleanPhoneNumber(inputString);

        // Regex for phone number validation
        String regex = "^(\\+\\d{1,3})?\\d{7,15}$";

        return cleanedNumber.matches(regex);

    }

    /**
     * Strips away spaces and dashes in Strings, making it easier to compare strings.
     * @param inputString Phone number in a String format.
     * @return String with no spaces or '-' dashes.
     */
    public static String cleanPhoneNumber (String inputString) {
        return inputString.replaceAll("[\\s-]", "");
    }
}
