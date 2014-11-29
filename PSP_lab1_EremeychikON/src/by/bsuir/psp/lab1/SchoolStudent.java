package by.bsuir.psp.lab1;

import java.io.Serializable;

public class SchoolStudent implements InterfaceOfSchoolStudent, Serializable {
	protected String surname;
	protected String name;
	protected String middleName;
	protected long dateOfBirth;
	protected String form;
	protected String formMaster;
	protected double averageAnnualScore;

	public SchoolStudent() {
		this.surname = new String();
		this.name = new String();
		this.middleName = new String();
		this.dateOfBirth = -1;
		this.form = new String();
		this.formMaster = new String();
		this.averageAnnualScore = -1.0;
	}

	public SchoolStudent(String surname, String name, String middleName,
			long dateOfBirth, String form, String formMaster,
			double averageAnnualScore) {
		this.surname = surname;
		this.name = name;
		this.middleName = middleName;
		this.dateOfBirth = dateOfBirth;
		this.form = form;
		this.formMaster = formMaster;
		this.averageAnnualScore = averageAnnualScore;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public long getdateOfBirth() {
		return dateOfBirth;
	}

	public void setdateOfBirth(long dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getForm() {
		return form;
	}

	public void setForm(String form) {
		this.form = form;
	}

	public String getFormMaster() {
		return formMaster;
	}

	public void setFormMaster(String formMaster) {
		this.formMaster = formMaster;
	}

	public double getaverageAnnualScore() {
		return averageAnnualScore;
	}

	public void setaverageAnnualScore(double averageScore) {
		this.averageAnnualScore = averageScore;
	}

	public void viewSchoolStudent() {
		System.out.println(surname + " " + name + " " + middleName + " "
				+ dateOfBirth + " " + form + " " + formMaster + " "
				+ averageAnnualScore);
	}

}
