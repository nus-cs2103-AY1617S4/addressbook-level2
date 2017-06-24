package seedu.addressbook.data.person;

public class Block {
	private final String blockNumber;

	public Block(String blockNum) {
		blockNumber = blockNum;
	}

	public String getBlockNumber() {
		return blockNumber;
	}

	@Override
	public String toString() {
		return blockNumber;
	}

	@Override
	public boolean equals(Object other) {
		return other == this // short circuit if same object
				|| (other instanceof Block // instanceof handles nulls
						&& this.blockNumber.equals(((Block) other).getBlockNumber())); // state
																						// check
	}

	@Override
	public int hashCode() {
		return blockNumber.hashCode();
	}

}
