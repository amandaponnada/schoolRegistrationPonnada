package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="student_dt")

public class student {

	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int studentId;
	private String studentName;
	private int studentAge;
	private int studentGradeId;
	private String studentMajorSub;
	private String studentElective;
	
	public student() {
		
	}
	
	public student(String sName, int sAge, int sGradeId, String sMajorSub, String sElective) {
			this.studentName = sName;
			this.studentAge = sAge;
			this.studentGradeId = sGradeId;
			this.studentMajorSub = sMajorSub;
			this.studentElective  = sElective;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentAge() {
		return studentAge;
	}
	public void setStudentAge(int studentAge) {
		this.studentAge = studentAge;
	}
	public int getStudentGradeId() {
		return studentGradeId;
	}
	public void setStudentGradeId(int studentGradeId) {
		this.studentGradeId = studentGradeId;
	}
	public String getStudentMajorSub() {
		return studentMajorSub;
	}
	public void setStudentMajorSub(String studentMajorSub) {
		this.studentMajorSub = studentMajorSub;
	}
	public String getStudentElective() {
		return studentElective;
	}
	public void setStudentElective(String studentElective) {
		this.studentElective = studentElective;
	}

	@Override
	public String toString() {
		return studentId + "  " + studentName;
	}
	

}
