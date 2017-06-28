package seedu.addressbook.ui;

/**
 * Formatter helper class for the text UI
 */
public class Formatter {

    /** A decorative prefix added to the beginning of lines printed by AddressBook */
    private static final String LINE_PREFIX = "|| ";

    /** A platform independent line separator. */
    private static final String LS = System.lineSeparator();

    private static final String DIVIDER = "===================================================";

    public static String singleLineMessage(String line) {
        return LINE_PREFIX + line.replace("\n", LS + LINE_PREFIX);
    }

    public static String getDivider() {
        return DIVIDER;
    }

}