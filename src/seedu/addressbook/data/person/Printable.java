package seedu.addressbook.data.person;

//an interface that allows user to access data on a read-only, immutable basis
public interface Printable {
	public abstract String getPrintableString();

	public default String getPrintableString(Printable...printables) {
		StringBuilder printableString = new StringBuilder();
		for (Printable _printable : printables) {
			printableString.append(_printable.getPrintableString());
		}
		return printableString.toString();
	}
}
