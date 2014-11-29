package by.bsuir.psp.lab1;

public class SchoolStudentTakingTheExams extends SchoolStudent {
	private int examScores[] = new int[4];

	public SchoolStudentTakingTheExams() {
		super();
		for (int i = 0; i < 4; i++)
			examScores[i] = -1;
	}

	public SchoolStudentTakingTheExams(String surname, String name,
			String middleName, long dateOfBirth, String form,
			String formMaster, double averageAnnualScore, int[] examScores) {
		super(surname, name, middleName, dateOfBirth, form, formMaster,
				averageAnnualScore);
		this.examScores = examScores;
	}

	public double calculateTheGeneralScore() {
		double averageExamScore;
		double generalScore;
		double sum = 0;
		for (int i = 0; i < 4; i++)
			sum = sum + examScores[i];
		averageExamScore = sum / 4;
		generalScore = (averageAnnualScore + averageExamScore) / 2;
		return generalScore;

	}

	public int[] getExamScores() {
		return examScores;
	}

	public void setExamScores(int[] examScores) {
		this.examScores = examScores;
	}

	public void viewSchoolStudent() {
		System.out.println(surname + " " + name + " " + middleName + " "
				+ dateOfBirth + " " + form + " " + formMaster + " "
				+ calculateTheGeneralScore());
	}

}
