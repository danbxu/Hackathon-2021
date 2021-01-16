import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;



public class ReadFile {
	//Container to hold all 24 courses
	static ArrayList<Course> hold = new ArrayList<Course>();

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


	//included/ needed to discuss
	boolean correctInput2(int a) {
		if (a >= 0 && a <= 23) {
			return true;
		}
		else {
			return false;
		}
	}

	//Not sure if to use string or int 
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

	public void Choose() {
		ArrayList<Course> pickedCourses = new ArrayList<Course>();
		boolean donePicking = false;
		Scanner a = new Scanner(System.in);
		String check;


		while (!donePicking) {
			int b = 0;
			if (pickedCourses.size() > 0) {
				if (pickedCourses.size() == 4) {
					System.out.println("You have 4 courses in your schedule" );
					System.out.println("If you are done registering, enter \"Exit\"");
					if (a.nextLine().equals("Exit")) {
						break;
					}				
				}
				else {
					System.out.println("You have " + pickedCourses.size() + " course(s) in your schedule");
					System.out.println("You can have a maximum of 4 courses");
					System.out.println();
					System.out.println("If you are done registering, enter \"Exit\" or enter anything to continue");
					if (a.nextLine().equals("Exit")) {
						break;
					}
				}

			}

			System.out.println("Please choose one of the following courses below by entering the number proceeding the course (only numbers 0 => 23)");
			System.out.println();
			System.out.println("You currently have " + pickedCourses.size() + " courses in your schedule.");
			System.out.println("(Students may only enroll in 4 courses maximum)");
			System.out.println();
			for (int i = 0; i < hold.size(); i++) {
				System.out.println(i + ": " + hold.get(i).getCourseCode()+ " " + hold.get(i).getName() + 
						"\n    Section " + hold.get(i).getSection() + " " + hold.get(i).getMeetTime() + 
						"\n    Instructor: " + hold.get(i).getInstructor());
			}

			String input = a.nextLine();
			//Checking if courses exist

			while (correctInput(input) != true) {
				System.out.println("Please enter an number from 0 to 23");
				input = a.nextLine();
			}

			//Need to implement way to input into file while checking if the course already exists
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
			}
		}
	}


	public static void main(String[] args) {
		ReadingFile("new_file.txt");
		ReadFile a = new ReadFile();
		a.Choose();
	}

}

