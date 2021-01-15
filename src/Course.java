import java.util.ArrayList;
import java.util.Collections;

public class Course {
	
	//Variables 
	String name;
	String instructor;
	String meetTime;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	public String getMeetTime() {
		return meetTime;
	}

	public void setMeetTime(String meetTime) {
		this.meetTime = meetTime;
	}

	public Courses(String name, String instructor, String meetTime) {

		if (name == null) {
			throw new IllegalArgumentException ("name is NULL");
		}
		if (instructor == null) {
			throw new IllegalArgumentException ("instructor is NULL");
		}
		if (meetTime == null) {
			throw new IllegalArgumentException ("meetTime is NULL");
		}
		
		this.name = name;
		this.instructor = instructor;
		this.meetTime = meetTime;
	}

	
	

}
