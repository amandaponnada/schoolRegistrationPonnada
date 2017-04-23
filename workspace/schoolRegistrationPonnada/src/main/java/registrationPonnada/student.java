package registrationPonnada;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dt_student")

public class student {
	
	@Id
	@Column(name="studentId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int studentId;
	private String studentFirstName;
	private String studentLastName;
	private String studentTeacherName;
	private String studentSubject;
	
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentTeacherName() {
		return studentTeacherName;
	}
	public void setStudentTeacherName(String studentTeacherName) {
		this.studentTeacherName = studentTeacherName;
	}
	public String getStudentSubject() {
		return studentSubject;
	}
	public void setStudentSubject(String studentSubject) {
		this.studentSubject = studentSubject;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	
	
	
	


}
