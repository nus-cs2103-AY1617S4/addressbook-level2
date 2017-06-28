package seedu.addressbook.ui;

import static seedu.addressbook.common.Messages.MESSAGE_GOODBYE;
import static seedu.addressbook.common.Messages.MESSAGE_INIT_FAILED;
import static seedu.addressbook.common.Messages.MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE;
import static seedu.addressbook.common.Messages.MESSAGE_USING_STORAGE_FILE;
import static seedu.addressbook.common.Messages.MESSAGE_WELCOME;

import java.util.ArrayList;
import java.util.List;

import seedu.addressbook.commands.CommandResult;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class Formatter {
	/**
	 * A decorative prefix added to the beginning of lines printed by
	 * AddressBook
	 */
	private static final String LINE_PREFIX = "|| ";

	/** A platform independent line separator. */
	private static final String LS = System.lineSeparator();

	private static final String DIVIDER = "===================================================";

	/** Format of indexed list item */
	private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";

	/** Offset required to convert between 1-indexing and 0-indexing. */
	public static final int DISPLAYED_INDEX_OFFSET = 1;

	public Formatter() {

	}

	/** Returns formatted welcome string with given version and storage path */
	public static String getWelcomeMessage(String version, String storageFilePath) {
		String storageFileInfo = String.format(MESSAGE_USING_STORAGE_FILE, storageFilePath);
		return formatStrings(DIVIDER, DIVIDER, MESSAGE_WELCOME, version, MESSAGE_PROGRAM_LAUNCH_ARGS_USAGE,
				storageFileInfo, DIVIDER);
	}

	/** Returns formatted goodbye string */
	public static String getGoodbyeMessage() {
		return formatStrings(MESSAGE_GOODBYE, DIVIDER, DIVIDER);
	}

	public static String getInitFailedMessage() {
		return formatStrings(MESSAGE_INIT_FAILED, DIVIDER, DIVIDER);
	}

	/** Echoes user commands */
	public static String echoUserCommand(String fullInputLine) {
		return formatStrings("[Command entered:" + fullInputLine + "]");
	}

	/** Formats message(s) for display */
	private static String formatStrings(String... message) {
		StringBuilder builder = new StringBuilder("");
		for (String m : message) {
			builder.append(LINE_PREFIX + m.replace("\n", LS + LINE_PREFIX) + "\n");
		}
		return builder.toString();
	}

	public static String getFormattedResult(CommandResult result) {
		return formatStrings(result.getFeedbackToUser(), DIVIDER);
	}

	/**
	 * Shows a list of persons to the user, formatted as an indexed list.
	 * Private contact details are hidden.
	 */
	public static String getPersonListView(List<? extends ReadOnlyPerson> persons) {
		final List<String> formattedPersons = new ArrayList<>();
		for (ReadOnlyPerson person : persons) {
			formattedPersons.add(person.getAsTextHidePrivate());
		}
		return formatStrings(getIndexedListForViewing(formattedPersons));
	}

	/** Formats a list of strings as a viewable indexed list. */
	private static String getIndexedListForViewing(List<String> listItems) {
		final StringBuilder formatted = new StringBuilder();
		int displayIndex = 0 + DISPLAYED_INDEX_OFFSET;
		for (String listItem : listItems) {
			formatted.append(getIndexedListItem(displayIndex, listItem)).append("\n");
			displayIndex++;
		}
		return formatted.toString();
	}

	/**
	 * Formats a string as a viewable indexed list item.
	 *
	 * @param visibleIndex
	 *            visible index for this listing
	 */
	private static String getIndexedListItem(int visibleIndex, String listItem) {
		return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
	}

	public static String promptUserInput() {
		return LINE_PREFIX + "Enter command: ";
	}
}
