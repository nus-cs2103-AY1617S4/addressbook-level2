package seedu.addressbook.commands;

public class SortCommand extends Command {

	public static final String COMMAND_WORD = "sort";
	public static final String MESSAGE_USAGE = "Sorts the address book by name.\n"
            + "Example: " + COMMAND_WORD;
    public static final String MESSAGE_SUCCESS = "Address book has been sorted!";

	public SortCommand() {
		super();
	}

	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		addressBook.sortByName();
		return new CommandResult(MESSAGE_SUCCESS);
	}
}
