/**
 * 
 */
package seedu.addressbook.commands;

import seedu.addressbook.data.person.Person;

/**
 * @author shuqi
 *
 */
public class EditCommand extends Command {
	public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD 
    		+ ": Edits a person currently in the address book by using index number used in the last person listing. "
    		+ "Only one detail can be editted at a time \n"
            + "Parameters: INDEEX [p] (prefix) / [detail]  \n"
            + "Example: " + COMMAND_WORD
            + " John Doe p/98765432 ";

    public static final String MESSAGE_SUCCESS = "Person editted: %1$s";

    private final Person toEdit;

	/**
	 * 
	 */
	public EditCommand(int targetVisibleIndex, String prefix, String detail, boolean isPrivate) {
		if ( prefix.equals("p")) {
		
	}

	/* (non-Javadoc)
	 * @see seedu.addressbook.commands.Command#execute()
	 */
	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
