package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="grade_dt")


public class grade {
//@id is the Primary Key which is declared for Entity
//The id will be mapped to GradeID
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="gradeId")
	
	private int gradeId;
	private String gradeName;
	private String gradeTeacherName;
	private String gradeSubTeacherName;
	private String gradeSchoolName;
	private String gradeMascot;
	
	public grade () {
	}

	public grade(String gName, String gTeacherName, String gSubTeacherName, String gSchoolName, String  gMascot) {
		this.gradeName = gName;
		this.gradeTeacherName = gTeacherName;
		this.gradeSubTeacherName = gSubTeacherName;
		this.gradeSchoolName = gSchoolName;
		this.gradeMascot = gMascot;
	}
	
	public int getgradeId() {
		return gradeId;
	}

	public void setgradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getgradeName() {
		return gradeName;
	}

	public void setgradeName(String gradeName) {
		this.gradeName = gradeName;
	}

	public String getgradeTeacherName() {
		return gradeTeacherName;
	}

	public void setgradeTeacherName(String gradeTeacherName) {
		this.gradeTeacherName = gradeTeacherName;
	}

	public String getgradeSubTeacherName() {
		return gradeSubTeacherName;
	}

	public void setgradeSubTeacherName(String gradeSubTeacherName) {
		this.gradeSubTeacherName = gradeSubTeacherName;
	}

	public String getgradeSchoolName() {
		return gradeSchoolName;
	}

	public void setgradeSchoolName(String gradeSchoolName) {
		this.gradeSchoolName = gradeSchoolName;
	}

	public String getgradeMascot() {
		return gradeMascot;
	}

	public void setgradeMascot(String gradeMascot) {
		this.gradeMascot = gradeMascot;
	}

	@Override
	public String toString() {
		return  gradeId + " - " + gradeName + " " + gradeSchoolName;
	}
	
}
