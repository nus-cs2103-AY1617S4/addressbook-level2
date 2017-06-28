package seedu.addressbook.commands;

import java.util.*;
import seedu.addressbook.data.person.*;
import java.util.Collections;

import seedu.addressbook.data.person.ReadOnlyPerson;

public class SortCommand extends Command {
	
	public static final String COMMAND_WORD = "sort"; 
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Sorts all persons in the address book.\n"
            + "Example: " + COMMAND_WORD;
    
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        ArrayList<Person> tempPeople = new ArrayList<Person> ();
        for(ReadOnlyPerson person : allPersons){
        	tempPeople.add(new Person(person));
        }
        
        Collections.sort(tempPeople);
        return new CommandResult(getMessageForPersonListShownSummary(tempPeople), tempPeople);
    }
}
