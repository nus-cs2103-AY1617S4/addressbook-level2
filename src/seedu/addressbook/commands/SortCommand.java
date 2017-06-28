package seedu.addressbook.commands;


import java.util.List;


import seedu.addressbook.data.person.ReadOnlyPerson;

/**
 * Sorts and list all persons in the address book according in lexicographical order.
 */
public class SortCommand extends Command{
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the lexicographical order in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        /*List<String> personsName = new ArrayList<String>();
        for(ReadOnlyPerson p: allPersons){
        	personsName.add(p.getName().toString());	
        }
        Arrays.sort(allPersons), Person.PersonNameComparator);*/
      //  allPersons.sort(ReadOnlyPerson.PersonNameComparator);
        allPersons.sort(ReadOnlyPerson.PersonNameComparator);
        return new CommandResult(getMessageForPersonListShownSummary(allPersons), allPersons);
    }
}
