package unit_01_solid_design_principles;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

class Journal {
	private final List<String> entries = new ArrayList<>();

	private static int count = 0;

	public void addEntry(String text) {
		entries.add("" + (++count) + ": " + text);
	}

	public void removeEntry(int index) {
		entries.remove(index);
	}

	@Override
	public String toString() {
		return String.join(System.lineSeparator(), entries);
	}

	// here we break SRP
	public void save(String filename) throws Exception {
		try (PrintStream out = new PrintStream(filename)) {
			out.println(toString());
		}
	}

	public void load(String filename) {
	}

	public void load(URL url) {
	}
}

// handles the responsibility of persisting objects
class Persistence {
	public void saveToFile(Journal journal, String filename, boolean overwrite) throws Exception {
		if (overwrite || new File(filename).exists())
			try (PrintStream out = new PrintStream(filename)) {
				out.println(journal.toString());
			}
	}

	public void load(Journal journal, String filename) {
	}

	public void load(Journal journal, URL url) {
	}
}

class SingleResponsibilityPrincipleDemo {
	public static void main(String[] args) throws Exception {
		Journal journal = new Journal();
		journal.addEntry("I surfed today");
		journal.addEntry("I jogged today");
		System.out.println(journal);

		Persistence p = new Persistence();
		String filename = "my_journal.txt";
		p.saveToFile(journal, filename, true);

		System.out.println("Printing the content of my journal");
		BufferedReader br = new BufferedReader(new FileReader(filename));
        for (String line; (line = br.readLine()) != null;) {
            System.out.println(line);
        }
        br.close();
	}
}