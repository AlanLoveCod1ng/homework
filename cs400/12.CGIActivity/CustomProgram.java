import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;

public class CustomProgram {
	public static void main(String[] args) throws Exception {
		// reads the provided customPage.html into list
		Scanner in = new Scanner(new File("customPage.html"));
		ArrayList<String> list = new ArrayList<>();
		while (in.hasNextLine())
			list.add(in.nextLine());
		// update list to reflect changes requested through command line args
		// TODO: Complete this section
		ArrayList<String> newList = new ArrayList<>();
		newList = (ArrayList<String>) list.clone();
		String name = "";
		String backgroundColor;
		boolean suppress = false;
		if (args.length > 0)
			for (String arg : args[0].split("&")) {
				String[] keyValuePair = arg.split("=");
				switch (keyValuePair[0]) {
					case "name":
						// TODO: when a greeting is selected (below), this
						// arguments's value should be displayed in that greeting
						if (keyValuePair.length > 1) {
							name = keyValuePair[1];
						}
						break;
					case "background":
						// TODO: when background="Dark", the body's color should be
						// set to white and it's background-color should be set to
						// black (the opposite of how they are set for "Light" by
						// default.
						backgroundColor = keyValuePair[1];
						if (backgroundColor.equals("Dark")) {
							newList.set(20, "background-color: black;");
							newList.set(21, "color: white;");
						}
						break;
					case "Greeting":
						// TODO: when this argument is present and =true, an <h1>
						// element containing the text "Welcome Stranger" should
						// be inserted as the first element within the body. If
						// a non-empty-string name is provided (see above), that
						// name should be used in place of the word Stranger in
						// this greeting.
						if (!keyValuePair[1].equals("true")) {
							break;
						}
						if (name.equals("")) {
							newList.set(26, "<body><h1>Welcome Stranger</h1>");
						}
						if (!name.equals("")) {
							newList.set(26, "<body><h1>Welcome " + name + "</h1>");
						}
						break;
					case "Time":
						// TODO: when this argument is present and =true, a <p>
						// element containing the text: "Page Updated: date-time"
						// should be inserted as the last element within the body.
						// Note that the date-time part of this paragraph should
						// be dynamically generated by calling
						// java.time.LocalDateTime.now()
						if (!keyValuePair[1].equals("true")) {
							break;
						}
						newList.set(45, "<p>Page Updated: " + java.time.LocalDateTime.now() + "</p></body>");
						break;
					case "SuppressOptions":
						// TODO: when this argument is present and =true, the
						// customization controls should be removed from the page.
						// Everything from and including the <h1> label through the
						// final </ul> should be omitted to accomplish this.
						if (keyValuePair[1].equals("true")) {
							suppress = true;
						}
						break;
				}
				list = newList;
				if (suppress) {
					for (int i = 27; i < 45; i++) {
						list.set(i, "");
					}
				}
			}

		// print the resulting html out to system.out (standard out)
		for (String line : list)
			System.out.println(line);
	}
}
