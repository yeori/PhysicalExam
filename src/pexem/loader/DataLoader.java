package pexem.loader;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import pexem.domain.Student;
import pexem.domain.StudentData;
/**
 * csv 파일 읽어서 인스턴스들을 생성합니다.
 *
 */
public class DataLoader {

	private List<Student> students;
	
	private List<StudentData> studentData;
	/**
	 * student.csv에서 학생 정보를 읽어들여서 list로 반환합니다.
	 * @return
	 */
	public List<Student> loadStudents () {
		students = new ArrayList<>();
		InputStream in = DataLoader.class.getResourceAsStream("students.csv");
		Scanner sc = new Scanner( in );
		
		String eachLine ;
		while ( sc.hasNextLine() ) {
			eachLine = sc.nextLine();
			String [] params = eachLine.split(",");// [sid, name, sex, email]
			Student s = new Student(
					Integer.parseInt(params[0].trim()),
					params[1].trim(),
					params[2].trim(),
					params[3].trim()
			);
			students.add(s);
		}
		sc.close();
		return students;
	}
	
	public List<StudentData> loadStudentData ( ) {
		studentData = new ArrayList<>();
		
		InputStream in = DataLoader.class.getResourceAsStream("pexam2017.csv");
		Scanner sc = new Scanner( in );
		String eachLine ;
		
		while ( sc.hasNextLine() ) {
			eachLine = sc.nextLine();
			String [] params = eachLine.split(",");// [sid, height, weight]
			
			int sid = Integer.parseInt(params[0].trim());
			Student student = findStudent(sid);
			double height = Double.parseDouble(params[1].trim());
			double weight = Double.parseDouble(params[2].trim());
			
			StudentData sd = new StudentData(student, height, weight);
			studentData.add(sd);
		}
		
		sc.close();
		return studentData;
	}
	/**
	 * 주어진 학번(sid)에 해당하는 학생 인스턴스를 반환합니다.
	 * @param sid
	 * @return
	 */
	Student findStudent(int sid) {
		for ( Student s :  students ) {
			if ( s.getSid().equals(sid)){
				return s;
			}
		}
		throw new RuntimeException("no such student id : " + sid );
	}
}
