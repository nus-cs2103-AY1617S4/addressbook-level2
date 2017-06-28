package seedu.addressbook.commands;

import java.util.List;

import seedu.addressbook.data.person.ReadOnlyPerson;
import seedu.addressbook.data.person.UniquePersonList;
/**
 * Sort and List all persons alphabetically in the addressBook
 * @author shuqi
 */
public class SortCommand extends Command {
	
	public static final String COMMAND_WORD = "sort";
	public static final String MESSAGE_USAGE = COMMAND_WORD
	            + ": Sort all persons in the address book alphabetically.\n"
	            + "Example: " + COMMAND_WORD;
	
	@Override
	public CommandResult execute() {
		// TODO Auto-generated method stub
		addressBook.sortByName();
		List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
	}

}
