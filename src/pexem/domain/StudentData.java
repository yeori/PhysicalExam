package pexem.domain;
/**
 * 각 학생의 키와 몸무게를 나타냅니다. 
 *
 */
public class StudentData {

	private Student student;
	private double height;
	private double weight;
	
	public StudentData(Student student, double height, double weight) {
		super();
		this.student = student;
		this.height = height;
		this.weight = weight;
	}

	public Student getStudent() {
		return student;
	}

	public double getHeight() {
		return height;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "@SID=" + student.getSid() + "," + student.getName() + ": " + height + "CM, " + weight + "KG";
	}
	
	
}
