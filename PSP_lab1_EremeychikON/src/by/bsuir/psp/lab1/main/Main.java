package by.bsuir.psp.lab1.main;

import java.io.IOException;
import java.util.Scanner;

public class Main extends MainMethods {

	public static void main(String[] args) throws ClassNotFoundException,
			IOException {
		Scanner scan = new Scanner(System.in);
		while (true) {
			System.out.println("1 - Добавить новую запись");
			System.out.println("2 - Просмотреть все записи");
			System.out.println("3 - Редактировать запись");
			System.out.println("4 - Удалить запись");
			System.out.println("0 - Выход");
			System.out.println("-----------------------------");
			System.out.print("Ваш выбор: ");
			int choice = scan.nextInt();
			switch (choice) {
			case 1: {
				// readRecords();
				addRecord();
				writeRecords();
				break;
			}
			case 2: {
				readRecords();
				sortRecords();
				viewRecords();
				writeRecords();
				break;
			}
			case 3: {
				readRecords();
				editRecord();
				writeRecords();
				break;
			}
			case 4: {
				readRecords();
				deleteRecord();
				writeRecords();
				break;
			}
			case 0:
				return;
			default: {
				System.out
						.println("Ошибка ввода! Повторите ввод, пожалуйста.\n");
			}
			}
		}

	}

}
