package by.bsuir.psp.lab1.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import by.bsuir.psp.lab1.*;

public class MainMethods {
	static List<SchoolStudent> Pupils = new ArrayList<SchoolStudent>();
	private static Iterator<SchoolStudent> itr;
	static Scanner scan = new Scanner(System.in);

	public static void addRecord() {
		System.out.print("������� ������� �������: ");
		String surname = scan.next();
		System.out.print("������� ��� �������: ");
		String name = scan.next();
		System.out.print("������� �������� �������: ");
		String middleName = scan.next();
		System.out.print("������� ��� �������� �������: ");
		long dateOfBirth = scan.nextLong();
		System.out.print("������� ����� (��� �������): ");
		String form = scan.next();
		System.out.print("������� ������� ��������� ������������: ");
		String formMaster = scan.next();
		System.out.print("������� ������� ������� ����: ");
		double averageAnnualScore = scan.nextDouble();
		if ((form.indexOf("9") != -1) || (form.indexOf("11") != -1)) {
			System.out.print("������� ������ �� 4 �������� (����� ������): ");
			int examScores[] = new int[4];
			for (int i = 0; i < 4; i++)
				examScores[i] = scan.nextInt();

			SchoolStudent newPupil = new SchoolStudentTakingTheExams(surname,
					name, middleName, dateOfBirth, form, formMaster,
					averageAnnualScore, examScores);
			Pupils.add(newPupil);
		} else {
			SchoolStudent newPupil = new SchoolStudent(surname, name,
					middleName, dateOfBirth, form, formMaster,
					averageAnnualScore);
			Pupils.add(newPupil);
		}
	}

	public static void sortRecords() {
		Comparator<SchoolStudent> comp = new Comparator<SchoolStudent>() {
			public int compare(SchoolStudent obj1, SchoolStudent obj2) {
				return obj1.getSurname().compareTo(obj2.getSurname());
			}
		};
		Collections.sort(Pupils, comp);
	}

	public static void viewRecords() {
		if (Pupils.isEmpty()) {
			System.out.println("������ �� �������!");
			return;
		}
		itr = Pupils.iterator();
		int id = 0;
		while (itr.hasNext()) {
			SchoolStudent tmpPupil = itr.next();
			System.out.print(++id + ". ");
			tmpPupil.viewSchoolStudent();
		}
	}

	public static void editRecord() {
		sortRecords();
		viewRecords();

		if (Pupils.isEmpty()) {
			return;
		} else {
			int number;
			System.out
					.print("����� ������ �� ������ ���������������? ������� ����� ������: ");
			number = scan.nextInt();
			number = number - 1;
			if (number >= 0 && number < Pupils.size()) {
				System.out.print("������� ������� �������: ");
				String surname = scan.next();
				System.out.print("������� ��� �������: ");
				String name = scan.next();
				System.out.print("������� �������� �������: ");
				String middleName = scan.next();
				System.out.print("������� ��� �������� �������: ");
				long dateOfBirth = scan.nextLong();
				System.out.print("������� ����� (��� �������): ");
				String form = scan.next();
				System.out.print("������� ������� ��������� ������������: ");
				String formMaster = scan.next();
				System.out.print("������� ������� ������� ����: ");
				double averageAnnualScore = scan.nextDouble();
				if ((form.indexOf("9") != -1) || (form.indexOf("11") != -1)) {
					System.out
							.print("������� ������ �� 4 �������� (����� ������): ");
					int examScores[] = new int[4];
					for (int i = 0; i < 4; i++)
						examScores[i] = scan.nextInt();

					SchoolStudent newPupil = new SchoolStudentTakingTheExams(
							surname, name, middleName, dateOfBirth, form,
							formMaster, averageAnnualScore, examScores);
					Pupils.set(number, newPupil);
				} else {
					SchoolStudent newPupil = new SchoolStudent(surname, name,
							middleName, dateOfBirth, form, formMaster,
							averageAnnualScore);
					Pupils.set(number, newPupil);
				}
				System.out.println("������ ������� ���������������.");
			} else {
				System.out.println("������ ��� ����� ������� �� ����������!");
				return;
			}
		}
	}

	public static void deleteRecord() {
		sortRecords();
		viewRecords();

		if (Pupils.isEmpty()) {
			return;
		} else {
			int number;
			System.out
					.print("����� ������ �� ������ �������? ������� ����� ������: ");
			number = scan.nextInt();
			number = number - 1;
			if (number >= 0 && number < Pupils.size()) {
				Pupils.remove(number);
				System.out.println("������ ������� �������.");
			} else {
				System.out.println("������ ��� ����� ������� �� ����������!");
				return;
			}
		}
	}

	public static void readRecords() throws ClassNotFoundException, IOException {
		FileReadWrite frw = new FileReadWrite();
		frw.readFile(Pupils);
	}

	public static void writeRecords() throws ClassNotFoundException,
			IOException {
		FileReadWrite frw = new FileReadWrite();
		frw.writeFile(Pupils);
	}

}
