package seedu.addressbook.commands;

import java.util.HashSet;
import java.util.Set;

import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Address;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.UniquePersonList;
import seedu.addressbook.data.tag.Tag;
import seedu.addressbook.data.tag.UniqueTagList;

/**
 * Edits a person's data in the address book based on their index.
 */
public class EditCommand extends Command{
    public static final String COMMAND_WORD = "edit";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the person identified by the index number used in the last person listing.\n"
            + "Parameters: INDEX n/NAME [p]p/PHONE [p]e/EMAIL [p]a/ADDRESS  [t/TAG]...\n"
            + "Example: edit 1 n/John Doe p/98765432 e/johnd@gmail.com a/311, Clementi Ave 2, #02-25 ";

    public static final String MESSAGE_EDIT_PERSON_SUCCESS = "Edited Person: %1$s";
    
    public static final String MESSAGE_DUPLICATE_PERSON = "This person already exists in the address book";
    
    public static final String MESSAGE_INDEX_INVALID_PERSON = "Person's index is invalid";
    
    private final Person toEdit;
    private final int targetIndex;
    public EditCommand(int targetIndex, 
                        String name, 
                        String phone, boolean isPhonePrivate,
                        String email, boolean isEmailPrivate,
                        String address, boolean isAddressPrivate ) throws IllegalValueException {
        
        this.targetIndex = targetIndex - 1;
        final Set<Tag> tagSet = new HashSet<>();
        this.toEdit = new Person(
                new Name(name),
                new Phone(phone, isPhonePrivate),
                new Email(email, isEmailPrivate),
                new Address(address, isAddressPrivate),
                new UniqueTagList(tagSet)
        );
    }
    @Override
    public CommandResult execute() {
        try {
            addressBook.updatePerson(targetIndex, toEdit);
            return new CommandResult(String.format(MESSAGE_EDIT_PERSON_SUCCESS, toEdit));
            
        } catch (ArrayIndexOutOfBoundsException dpe) {
            return new CommandResult(MESSAGE_INDEX_INVALID_PERSON);
            
        } catch (UniquePersonList.DuplicatePersonException dpe) {
            return new CommandResult(MESSAGE_DUPLICATE_PERSON);
            
        }
        
    }

}
