import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Implements the user interface and it contains the main method
 * 
 * @author Mingpei Dou 251056543 CS2210A Coding Assignment 2
 *
 */
public class TextInterface {
	/**
	 * method main
	 * 
	 * @return constructor for class
	 */
	public static void main(String[] args) throws Exception {
		// Instance Variables
		String[] args1 = new String[4], rec1 = new String[2]; // array to store input args or for string concatenation
		String cmd = "", var1, var2, var3, var4, recKey;
		OrderedDictionary dict = new OrderedDictionary(); // create new dictionary object
		DataItem record; // new dataitem object to store obj of nodes
		DataList list = new DataList(); // new list for list traversal
		SoundPlayer sound = new SoundPlayer(); // new soundplayer object to play midi and wave files
		PictureViewer pic = new PictureViewer(); // new pictureviewer object to open jpg files and gifs
		ShowHTML web = new ShowHTML(); // new showhtml object to open html links
		RunCommand prog = new RunCommand(); // new runcommand object to run executables

		while (!cmd.equals("end")) { // probe for user input until input "end"
			StringReader keyboard = new StringReader();
			String line = keyboard.read("Enter next command: "); // prompts user input
			cmd = line;
			args1 = cmd.split(" "); // fills array with separate command arguments (couldn't get args[] working rip)
			if (args1.length == 1 && cmd.equals("end"))
				System.out.println("Terminating Program");
			else if (args1.length == 1 && !cmd.equals("end")) {
				var1 = args1[0];
				if (var1.equals("first")) { // if command is "first"
					if (dict.smallest() == null) // if smallest does not exist
						System.out.println("Null"); // return null
					else
						System.out.println(dict.smallest().getKey().getName()); // else return smallest
				} else if (var1.equals("last")) { // if command is "last"
					if (dict.largest() == null) // if largest does not exist
						System.out.println("Null"); // return null
					else
						System.out.println(dict.largest().getKey().getName()); // else return largest
				} else
					System.out.println("Unrecognized Command");
			} else if (args1.length == 2) {
				var1 = args1[0];
				var2 = args1[1];
				if (var1.equals("get")) { // if command is "get"
					if (dict.get(new Key(var2, "")) == null) { // return message if node is not in dictionary
						System.out.println("The word: " + var2 + " is not in the ordered dictionary");
						if (dict.successor(new Key(var2, "")) != null)
							System.out.println(
									"Preceding Word: " + dict.predecessor(new Key(var2, "")).getKey().getName());
						else
							System.out.println("Preceding Word: Null");
						if (dict.predecessor(new Key(var2, "")) != null)
							System.out
									.println("Following Word: " + dict.successor(new Key(var2, "")).getKey().getName());
						else
							System.out.println("Following Word: Null");
					} else { // if node is in dictionary
						record = dict.get(new Key(var2, ""));
						recKey = record.getKey().getKind();
						rec1 = record.getContent().split("\\."); // populates rec1 with filetypes
						if (recKey.equals("definition")) { // if file is text
							BufferedReader input = new BufferedReader(new FileReader(record.getContent())); // read file
							String word = input.readLine(); // read each line
							String definition;
							while (word != null) {
								try {
									definition = input.readLine(); // read each word
									System.out.println(definition + " "); // concatenate and print
									word = input.readLine(); // read next word
								} catch (Exception e) {
									System.out.println("Error: " + e);
								}
							}
						} else if (recKey.equals("sound")) { // if file is sound
							if (rec1[1] == null) // if no extension
								System.out.println("Unsupported Filetype");
							else if (rec1[1].equals("wav") || rec1[1].equals("mid")) { // if correct file extension
								try {
									sound.play(record.getContent()); // play sound
								} catch (Exception e) { // if file is not in folder
									System.out.println("File does not exist");
								}
							} else
								System.out.println("Unsupported Filetype"); // return error if incorrect extension
						} else if (recKey.equals("picture")) { // if file is picture
							if (rec1[1] == null)
								System.out.println("Unsupported Filetype"); // if no extension
							else if (rec1[1].equals("jpg") || rec1[1].equals("gif")) { // if correct file extension
								try {
									pic.show(record.getContent()); // open image
								} catch (Exception e) { // if file is not in folder
									System.out.println("File does not exist");
								}
							} else
								System.out.println("Unsupported Filetype"); // return error if incorrect extension
						} else if (recKey.equals("url")) {
							if (rec1[1] == null)
								System.out.println("Unsupported Filetype"); // if no extension
							else if (rec1[1].equals("html")) { // if correct file extension
								try {
									web.show(record.getContent()); // open website
								} catch (Exception e) { // if file is not in folder
									System.out.println("File does not exist");
								}
							} else
								System.out.println("Unsupported Filetype"); // return error if incorrect extension
						} else if (recKey.equals("program")) {
							if (rec1[1] == null) // if no extension
								System.out.println("Unsupported Filetype"); // return error message
							else if (rec1[1].equals("exe")) { // if correct file extension
								try {
									prog.run(record.getContent()); // open executable
								} catch (Exception e) { // if file is not in folder
									System.out.println("File does not exist");
								}
							} else
								System.out.println("Unsupported Filetype"); // return error if incorrect extension
						} else // if filetype does not match any of the above, return error message
							System.out.println("Filetype not supported");
					}

				} else if (var1.equals("list")) { // if command is "list"
					DataNode curr = list.getHead();
					while (curr != null) { // iterate through all stored args and return values that match the prefix
						if (curr.getElem().getKey().getName().startsWith(var2))
							System.out.println(curr.getElem().getKey().getName());
						curr = curr.getNext();
					}
				} else
					System.out.println("Unrecognized Command");
			} else if (args1.length == 3) {
				var1 = args1[0];
				var2 = args1[1];
				var3 = args1[2];
				if (var1.equals("remove")) { // if command is "remove"
					try {
						list.remove(new Key(var2, var3)); // remove node from linkedlist
						dict.remove(new Key(var2, var3)); // remove node from actual dictionary
					} catch (Exception e) { // if node not in dictionary return error message
						System.out.println("File not found");
					}
				} else
					System.out.println("Unrecognized Command"); // if command is unknown or incorrect
			} else if (args1.length == 4) {
				var1 = args1[0];
				var2 = args1[1];
				var3 = args1[2];
				var4 = args1[3];
				if (var1.equals("add")) { // if command is "add"
					if (var4.contains(".")) {
						rec1 = var4.split("\\.");
						if (!rec1[1].equals("html") && !rec1[1].equals("exe") && !rec1[1].equals("jpg")
								&& !rec1[1].equals("gif") && !rec1[1].equals("wav") && !rec1[1].equals("mid")
								&& !rec1[1].equals("txt"))
							System.out.println("Filetype not supported");
						else {
							try {
								dict.put(new DataItem(new Key(var2, var3), var4)); // store input in list for traversal
								list.add(new DataItem(new Key(var2, var3), var4)); // store input in dictionary
							} catch (Exception e) { // if duplicated node
								list.remove(new Key(var2, var3)); // remove node from list and return error message
								System.out.println("File is already in dictionary");
							}
						}
					} else
						System.out.println("Filetype not supported");
				} else // else if command does not exist, return error message
					System.out.println("Unrecognized Command");
			} else // else command does not exist or is incorrect
				System.out.println("Invalid Command");
		}
	}
}
