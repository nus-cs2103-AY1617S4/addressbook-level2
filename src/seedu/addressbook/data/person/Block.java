package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address block in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Block {

    public static final String EXAMPLE = "123";
    public static final String MESSAGE_BLOCK_CONSTRAINTS = "Block can be in any format";
    public static final String BLOCK_VALIDATION_REGEX = ".+";

    public final String blockValue;
    private boolean isPrivate;
    
    /**
     * Validates given address block.
     *
     * @throws IllegalValueException if given address block string is invalid.
     */
    public Block(String block, boolean isPrivate) throws IllegalValueException {
        String trimmedBlock = block.trim();
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedBlock)) {
            throw new IllegalValueException(MESSAGE_BLOCK_CONSTRAINTS);
        }
        this.blockValue = trimmedBlock;
    }

    /**
     * Returns true if a given string is a valid person address.
     */
    public static boolean isValidAddress(String test) {
        return test.matches(BLOCK_VALIDATION_REGEX);
    }

    @Override
    public String toString() {
        return blockValue;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && this.blockValue.equals(((Block) other).blockValue)); // state check
    }

    @Override
    public int hashCode() {
        return blockValue.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
