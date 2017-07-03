package seedu.addressbook.data;

import java.util.ArrayList;

public class Tagging {
	private static final String ADD_COMMAND = "add";
	private static final String DEL_COMMAND = "delete";
	private ArrayList<String> allTagHistory;

	public void recordTagHistory(String command, String name, String tag) {
		if (command.equals(ADD_COMMAND)) {
			allTagHistory.add("+ " + name + " " + tag);
		} else if (command.equals(DEL_COMMAND)) {
			allTagHistory.add("- " + name + " " + tag);
		}
	}

	public String getTagHistory() {
		StringBuilder history = new StringBuilder();
		for (String tag : allTagHistory) {
			history.append(tag + "\n");
		}
		return history.toString();
	}
}
