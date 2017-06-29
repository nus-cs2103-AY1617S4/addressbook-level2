package seedu.addressbook.data.person;

public class Block {
    private String blockName;
    
    public Block(String blockName) {
        this.blockName = blockName;
    }
    
    public String getBlockName() {
        return blockName;
    }
    
    public void changeBlockName(String newBlockName) {
        this.blockName = newBlockName;
    }
    
    @Override
    public String toString() {
        return blockName;
    }
}
