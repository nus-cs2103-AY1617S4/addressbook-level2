package seedu.addressbook.commands;

import java.util.Collections;
import java.util.List;
import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Lists all persons in the address book to the user in alphabetical order.
 */
public class SortCommand extends Command {
    
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a sorted list in alphabetical order with index numbers.\n"
            + "Example: " + COMMAND_WORD;
    
    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableSortedListView();
        return new CommandResult(getMessageForPersonListSortedSummary(allPersons), allPersons);
    }
}
