import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateFileRunner {
	
	public static void main(String[] args) throws IOException {
		ReadFile a = new ReadFile();
		a.ReadingFile("new_file.txt");
		a.Choose();
	}

}
