package seedu.addressbook.data.person;
/**
 * Represents the Unit of a Person in the address book.
 * Guarantees: details are present and not null, field values are validated.
 */
public class Block {
    private String block;
    
    public Block(){
        block = "";
    }
    
    public Block(String block){
        this.block = block;
    }
    
    public String getBlock(){
        return block;
    }
}
