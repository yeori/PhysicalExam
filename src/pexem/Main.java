package pexem;

import java.util.List;

import pexem.domain.PhysicalExam;
import pexem.domain.Student;
import pexem.domain.StudentData;
import pexem.loader.DataLoader;

public class Main {
	public static void main(String[] args) {
		
		DataLoader loader = new DataLoader();
		loader.loadStudents();
		List<StudentData> examData = loader.loadStudentData();
		
		PhysicalExam examService = new PhysicalExam("2017 Physical Exam", examData);
		
		print ( "AVR WEIGHT ALL: ", examService.getAvrWeight() );
		print ( "AVR HEIGHT ALL: ", examService.getAvrHeight() );
		
		print ( "AVR HEIGHT(GIRL) : ", examService.getAvrHeightGirl() );
		print ( "AVR HEIGHT(BOY)  : ", examService.getAvrHeightBoy() );
		
	
	}
	static void print(String title, double value) {
		System.out.println( title + value);
	}
}
