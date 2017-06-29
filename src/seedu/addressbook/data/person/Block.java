package seedu.addressbook.data.person;

public class Block {
	
	private String blockNum;
	
	public Block(String blockNum) {
		this.blockNum = blockNum;
	}
	
	public String getblockNum() {
		return blockNum;
	}
	
    public String toString() {
        return getblockNum();
    }
    
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && blockNum.equals(((Block) other).getblockNum())); // state check
    }
    
    public int hashCode() {
    	return blockNum.hashCode();
    }
    
}
