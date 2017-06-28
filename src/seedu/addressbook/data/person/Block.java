package seedu.addressbook.data.person;

public class Block {
	
	private String blockNumber;
	
	public Block(String blockNum) {
		blockNumber = blockNum;
	}
	
	public String getBlockNumber() {
		return blockNumber;
	}
	
    @Override
    public String toString() {
        return getBlockNumber();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Block // instanceof handles nulls
                && blockNumber.equals(((Block) other).getBlockNumber())); // state check
    }
    
    @Override
    public int hashCode() {
    	return blockNumber.hashCode();
    }
    
}
