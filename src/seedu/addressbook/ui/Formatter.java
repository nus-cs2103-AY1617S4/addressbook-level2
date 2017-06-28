package seedu.addressbook.ui;

import java.util.List;

public class Formatter {
	
	/** Format of indexed list item */
    private static final String MESSAGE_INDEXED_LIST_ITEM = "\t%1$d. %2$s";


    /** Offset required to convert between 1-indexing and 0-indexing.  */
    public static final int DISPLAYED_INDEX_OFFSET = 1;
    
    /** Format of a comment input line. Comment lines are silently consumed when reading user input. */
    static final String COMMENT_LINE_FORMAT_REGEX = "#.*";

	/**
	 * Returns true if the user input line should be ignored.
	 * Input should be ignored if it is parsed as a comment, is only whitespace, or is empty.
	 *
	 * @param textUi TODO
	 * @param rawInputLine full raw user input line.
	 * @return true if the entire user input line should be ignored.
	 */
	boolean shouldIgnore(TextUi textUi, String rawInputLine) {
	    return rawInputLine.trim().isEmpty() || textUi.formatter.isCommentLine(rawInputLine);
	}
	
	/** Formats a list of strings as a viewable indexed list. */
    static String getIndexedListForViewing(List<String> listItems) {
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
     * @param visibleIndex visible index for this listing
     */
    private static String getIndexedListItem(int visibleIndex, String listItem) {
        return String.format(MESSAGE_INDEXED_LIST_ITEM, visibleIndex, listItem);
    }

	/**
	 * Returns true if the user input line is a comment line.
	 *
	 * @param rawInputLine full raw user input line.
	 * @return true if input line is a comment.
	 */
	boolean isCommentLine(String rawInputLine) {
	    return rawInputLine.trim().matches(COMMENT_LINE_FORMAT_REGEX);
	}
	
	
}
