package seedu.addressbook.commands;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.ReadOnlyPerson;

public class SortCommand extends Command {
    public static final String COMMAND_WORD = "sort";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays all persons in the address book as a list with index numbers.\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public CommandResult execute() {
        List<ReadOnlyPerson> allPersons = addressBook.getAllPersons().immutableListView();
        ArrayList<Person> tempAllPerson = new ArrayList<Person>();
        for(ReadOnlyPerson person : allPersons){
            tempAllPerson.add(new Person(person));
        }
        
        Collections.sort(tempAllPerson, new Comparator<Person>() {

            @Override
            public int compare(Person firstPerson, Person secondPerson) {
                // TODO Auto-generated method stub
                return (firstPerson.getName().toString()).compareTo(secondPerson.getName().toString());
            }

        });
        return new CommandResult(getMessageForPersonListShownSummary(tempAllPerson), tempAllPerson);
    }

}
