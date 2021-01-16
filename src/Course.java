import java.util.ArrayList;
import java.util.Collections;

public class Course {
	
	String name;
	String instructor;
	String meetTime;
	String courseCode;
	String section;
	
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


	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}
	
	/**
	 * Course constructor. Each Course will have information such as the course's name, course ID/code, instructor name, 
	 * meeting time, and course section number. 
	 * 
	 * @param name
	 * @param courseCode
	 * @param instructor
	 * @param meetTime
	 * @param section
	 */
	public Course(String name, String courseCode, String instructor, String meetTime, String section) {

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
		this.courseCode = courseCode;
		this.section = section;
	}

}
