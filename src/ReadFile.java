import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;



public class ReadFile {
	//TODO read the file 

	static ArrayList<Course> hold = new ArrayList<Course>();

	public void ReadingFile (String fileName) {
		ArrayList<Course> courseList = new ArrayList<Course>();
		File f = new File(fileName);


		try {
			Scanner scanner = new Scanner(f);
			while(scanner.hasNextLine()) {
				String line = scanner.nextLine();
				if(!line.isEmpty()) {
					//line is not empty
					parseAndInsert(line);
				}
			}
		}
		catch (FileNotFoundException e) {
			System.out.println("Unable to locate file");
			System.exit(-1);		
		}
	}

	public void parseAndInsert(String line) {
		if(line.contains("*")) {
			String[] dump = line.split(",");
			String courseCode = dump[0];
			String name = dump[1];
			String section = dump[3];
			String meetTime = dump[5];
			String instructor = dump[6];

			//Create newCourse
			Course newCourse = new Course(name, courseCode, 
					instructor, meetTime, section);

			//Add to total courses
			hold.add(newCourse);
		}
	}

	public void Choose() {
		ArrayList<Course> pickedCourses = new ArrayList<Course>();

		boolean choose = false;
		Scanner a = new Scanner(System.in);

		while (!choose) {
			System.out.println("Please choose from the following courses:");
			for (int i = 1; i < hold.size() + 1; i++) {
				System.out.println(i + ": " + hold.get(i).getName() + ": Section " + hold.get(i).getSection() 
						+ " " + hold.get(i).getName() + "  - Instructor: " + hold.get(i).getInstructor());
			}

			String input = a.nextLine();

			//implement for loop for checking repeated courses 
			for (int i = 0; i < pickedCourses.size(); i++) {
				//TODO
			}


			if (input.equals("1")) {
				pickedCourses.add(hold.get(0));
			}
			if (input.equals("2")) {
				pickedCourses.add(hold.get(1));
			}
			if (input.equals("3")) {
				pickedCourses.add(hold.get(2));
			}
			if (input.equals("4")) {
				pickedCourses.add(hold.get(3));
			}
			if (input.equals("5")) {
				pickedCourses.add(hold.get(4));
			}
			if (input.equals("6")) {
				pickedCourses.add(hold.get(5));
			}
			if (input.equals("7")) {
				pickedCourses.add(hold.get(6));
			}
			if (input.equals("8")) {
				pickedCourses.add(hold.get(7));
			}
			if (input.equals("9")) {
				pickedCourses.add(hold.get(8));
			}
			if (input.equals("10")) {
				pickedCourses.add(hold.get(9));
			}
			if (input.equals("11")) {
				pickedCourses.add(hold.get(10));
			}
			if (input.equals("12")) {
				pickedCourses.add(hold.get(11));
			}
			if (input.equals("13")) {
				pickedCourses.add(hold.get(12));
			}
			if (input.equals("14")) {
				pickedCourses.add(hold.get(13));
			}
			if (input.equals("15")) {
				pickedCourses.add(hold.get(14));
			}
			if (input.equals("16")) {
				pickedCourses.add(hold.get(15));
			}
			if (input.equals("17")) {
				pickedCourses.add(hold.get(16));
			}
			if (input.equals("18")) {
				pickedCourses.add(hold.get(17));
			}
			if (input.equals("19")) {
				pickedCourses.add(hold.get(18));
			}
			if (input.equals("20")) {
				pickedCourses.add(hold.get(19));
			}
			if (input.equals("21")) {
				pickedCourses.add(hold.get(20));
			}
			if (input.equals("22")) {
				pickedCourses.add(hold.get(21));
			}			
			if (input.equals("23")) {
				pickedCourses.add(hold.get(22));
			}		
			if (input.equals("24")) {
				pickedCourses.add(hold.get(23));
			}

		}



	}

}

