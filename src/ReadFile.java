import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;



public class ReadFile {
	//Container to hold all 24 courses
	static ArrayList<Course> hold = new ArrayList<Course>();


	/**
	 * This method takes an input file with all the courses scrapped from the website and puts the courses
	 * in a ArrayList<Course> container. ReadingFile() calls on parseAndInsert() to parse each line of the input file
	 * by commas and creates a Course for each line in the input file.
	 * 
	 * @param fileName - name of file 
	 */
	public static void ReadingFile (String fileName) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		File f = new File(fileName);

		try {
			Scanner scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(!line.isEmpty()) {
					parseAndInsert(line);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to locate file");
			System.exit(-1);		
		}
	}

	/**
	 * Creates a Course for each line in the input file, which contains all the courses available to students in
	 * spring 2021
	 * 
	 * @param line - each line of the file
	 */
	public static void parseAndInsert(String line) {
		if(line.contains(",")) {
			String[] dump = line.split(",");
			String courseCode = dump[0];

			//System.out.println(courseCode);
			String name = dump[1];

			//System.out.println(name);
			String section = dump[3];
			//System.out.println(section);

			String meetTime = dump[5];
			//System.out.println(meetTime);

			String instructor = dump[6];
			//System.out.println(instructor);

			//Create newCourse
			Course newCourse = new Course(name, courseCode, 
					instructor, meetTime, section);

			//Add to total courses
			hold.add(newCourse);
		}
	}

	/**
	 * This method creates and writes to the output file called "out.txt". 
	 * 
	 * @param filename - Name of file to be written to 
	 * @param arr - ArrayList of all the courses the student selected
	 * @param studentName - Student name
	 * @param studentID - Student ID
	 * @throws IOException
	 */
	public static void fileWriter(String filename, ArrayList<Course> arr, String studentName, String studentID) throws IOException {

		File file = new File (filename);
		FileWriter newFile = new FileWriter(file);
		PrintWriter test = new PrintWriter(newFile);
		SimpleDateFormat dateStruc = new SimpleDateFormat("MM/DD/YYYY HH:MM:SS");
		Date date = new Date();


		test.println("Name: " + studentName);
		test.println("Student ID: " + studentID);
		test.println("Date/Time: " + dateStruc.format(date));
		test.println();

		test.println("Courses Registered: " + arr.size());
		for (int i = 0; i < arr.size(); i++) {
			test.println(i + ": " + arr.get(i).getCourseCode()+ " " + arr.get(i).getName() + 
					"\n    Section " + arr.get(i).getSection() + " " + arr.get(i).getMeetTime() + 
					"\n    Instructor: " + arr.get(i).getInstructor());
		}
		test.println("\nComments to:");
		test.println("	Office of the University Registrar");
		test.println("	University of Pennsylvania");
		test.println("	Room 150 Franklin Building");
		test.println("	3451 Walnut Street");
		test.println("	Philadelphia, PA 19104-6291");
		test.println("	Phone: (215) 898-6636 Fax: (215) 573-2076");
		test.println("	registra@pobox.upenn.edu");
		test.close();

	}

	/**
	 * This method is just a helper to check user input is within 0 - 23
	 * Considered using correctInput2() above but using inputs as strings is significantly easier
	 * 
	 * @param a - String user input for number associated with the course
	 * @return
	 */
	boolean correctInput(String a) {
		if (a.equals("0")) {
			return true;
		}
		if (a.equals("1")) {
			return true;
		}
		if (a.equals("2")) {
			return true;
		}
		if (a.equals("3")) {
			return true;
		}
		if (a.equals("4")) {
			return true;
		}
		if (a.equals("5")) {
			return true;
		}
		if (a.equals("6")) {
			return true;
		}
		if (a.equals("7")) {
			return true;
		}
		if (a.equals("8")) {
			return true;
		}
		if (a.equals("9")) {
			return true;
		}
		if (a.equals("10")) {
			return true;
		}
		if (a.equals("11")) {
			return true;
		}
		if (a.equals("12")) {
			return true;
		}
		if (a.equals("13")) {
			return true;
		}
		if (a.equals("14")) {
			return true;
		}
		if (a.equals("15")) {
			return true;
		}
		if (a.equals("16")) {
			return true;
		}
		if (a.equals("17")) {
			return true;
		}
		if (a.equals("18")) {
			return true;
		}
		if (a.equals("19")) {
			return true;
		}
		if (a.equals("20")) {
			return true;
		}
		if (a.equals("21 ")) {
			return true;
		}
		if (a.equals("22")) {
			return true;
		}
		if (a.equals("23")) {
			return true;
		}

		else {
			return false;
		}

	}


	/**
	 * This method prompts the user to enter Name/StudentID and finally shows a list of available courses for spring 2021.
	 * This method repeatedly prompts the user to add classes and only exits when either (1) user wishes to "Exit" 
	 * or (2) the user selected 4 courses - maximum number of courses to take per semester. Finally, this method calls
	 * fileWriter() to out the user's course schedule to a .txt file. 
	 * 
	 * @throws IOException
	 */
	public void Choose() throws IOException {
		ArrayList<Course> pickedCourses = new ArrayList<Course>();
		boolean donePicking = false;
		Scanner a = new Scanner(System.in);
		String check;
		String studentName;
		String studentID;


		System.out.println("Please enter your name");
		studentName = a.nextLine();

		System.out.println("Please enter your student ID");
		studentID = a.nextLine();

		while (!donePicking) {
			int b = 0;
			if (pickedCourses.size() > 0) {
				if (pickedCourses.size() == 4) {
					System.out.println("\nYou have 4 courses in your schedule");
					System.out.println("Your course schedule is complete \n");
					System.out.println("The following is your course selection(s): \n");

					for (int i = 0; i < pickedCourses.size(); i++) {
						System.out.println((i) + ": " + pickedCourses.get(i).getCourseCode()+ " " + pickedCourses.get(i).getName() + 
								"\n    Section " + pickedCourses.get(i).getSection() + " " + pickedCourses.get(i).getMeetTime() + 
								"\n    Instructor: " + pickedCourses.get(i).getInstructor());
					}
					break;

					//Can implement more complex method of editing course selection here in the future
				}
				else {
					System.out.println("\nYou have " + pickedCourses.size() + " course(s) in your schedule");
					System.out.println("           Max 4 courses \n");
					System.out.println("==Enter one of the following options==");
					System.out.println("\"Exit\" to end your registration");
					System.out.println("\"Show\" to show your course selection(s)");
					System.out.println("\"Undo\" to remove your previous selection");
					System.out.println("\nor Enter anything else to select additional courses");

				}

				String split = a.nextLine(); 
				if(split.equals("Show") || split.equals("show")) {
					System.out.println();
					System.out.println("Your current selection(s)");
					for (int i = 0; i < pickedCourses.size(); i++) {
						System.out.println((i) + ": " + pickedCourses.get(i).getCourseCode()+ " " + pickedCourses.get(i).getName() + 
								"\n    Section " + pickedCourses.get(i).getSection() + " " + pickedCourses.get(i).getMeetTime() + 
								"\n    Instructor: " + pickedCourses.get(i).getInstructor());
					}
					System.out.println();
					System.out.println("==Enter one of the following options==");
					System.out.println("\"Exit\" to end your registration");
					System.out.println("\"Undo\" to remove your previous selection");
					System.out.println("\nor Enter anything to continue");
					
					String split2 = a.nextLine();
					if (split2.equals("Exit")) {
						break;
					}
					if (split2.equals("Undo") || split2.equals("undo")) {
						System.out.println();
						System.out.println(pickedCourses.get(pickedCourses.size() - 1).getCourseCode() + ": " + pickedCourses.get(pickedCourses.size() - 1).getName() + " has been removed");
						pickedCourses.remove(pickedCourses.size() - 1);
					}
				}
				if (split.equals("Exit") || split.equals("exit")) {
					break;

				}
				if (split.equals("Undo") || split.equals("undo")) {
					System.out.println();
					System.out.println(pickedCourses.get(pickedCourses.size() - 1).getCourseCode() + ": " + pickedCourses.get(pickedCourses.size() - 1).getName() + " has been removed");
					pickedCourses.remove(pickedCourses.size() - 1);
				}

				//Can implement more complex method of editing course selection here in the future
			}
			System.out.println("\nPlease choose one of the following courses below \n  by entering the number proceeding the course "
					+ "\n           (only numbers 0 => 23) \n");
			System.out.println("=================================================");
			System.out.println("==You currently have " + pickedCourses.size() + " courses in your schedule==");
			System.out.println("==Students may only enroll in 4 courses maximum==");
			System.out.println("================================================= \n");
			for (int i = 0; i < hold.size(); i++) {
				System.out.println(i + ": " + hold.get(i).getCourseCode()+ " " + hold.get(i).getName() + 
						"\n    Section " + hold.get(i).getSection() + " " + hold.get(i).getMeetTime() + 
						"\n    Instructor: " + hold.get(i).getInstructor());
			}

			String input = a.nextLine();
			while (correctInput(input) != true) {
				System.out.println("Please enter an number from 0 to 23");
				input = a.nextLine();
			}

			//Ifbranches below checks if course already exists
			if (input.equals("0")) {
				check = hold.get(0).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(0));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("1")) {
				check = hold.get(1).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(1));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("2")) {
				check = hold.get(2).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(2));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("3")) {
				check = hold.get(3).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(3));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("4")) {
				check = hold.get(4).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(4));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("5")) {
				check = hold.get(5).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(5));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("6")) {
				check = hold.get(6).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(6));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("7")) {
				check = hold.get(7).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(7));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("8")) {
				check = hold.get(8).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(8));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("9")) {
				check = hold.get(9).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(9));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("10")) {
				check = hold.get(10).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(10));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("11")) {
				check = hold.get(11).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(11));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("12")) {
				check = hold.get(12).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(12));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("13")) {
				check = hold.get(13).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(13));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("14")) {
				check = hold.get(14).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(14));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("15")) {
				check = hold.get(15).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(15));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("16")) {
				check = hold.get(16).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(16));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("17")) {
				check = hold.get(17).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(17));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("18")) {
				check = hold.get(18).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(18));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("19")) {
				check = hold.get(19).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(19));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}

			if (input.equals("20")) {
				check = hold.get(20).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(20));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("21")) {
				check = hold.get(21).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(21));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("22")) {
				check = hold.get(0).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(22));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}
			if (input.equals("23")) {
				check = hold.get(23).getName();

				for (int i = 0; i < pickedCourses.size(); i++) {
					if (pickedCourses.get(i).getName().equals(check)) {
						b++;	
					}
				}
				if (b == 0) {
					pickedCourses.add(hold.get(23));
				}
				else {
					System.out.println("\n ERROR: The course you selected already exists in your schedule \n");
				}
			}

		}
		fileWriter("out.txt", pickedCourses, studentName, studentID);
		System.out.println("Thank you "  + studentName + " for using Team2 course registering app!"
				+ "\n Your course schedule is exported as a .txt file. ");

	}

}

