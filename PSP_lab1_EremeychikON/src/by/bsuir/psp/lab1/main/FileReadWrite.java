package by.bsuir.psp.lab1.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import by.bsuir.psp.lab1.SchoolStudent;

public class FileReadWrite {
	public void readFile(List<SchoolStudent> Pupils) throws IOException,
			ClassNotFoundException {
		String filename = "Pupils.txt";
		FileInputStream fis = null;
		ObjectInputStream in = null;
		fis = new FileInputStream(filename);
		in = new ObjectInputStream(fis);
		Pupils = (ArrayList<SchoolStudent>) in.readObject();
		in.close();
	}

	public void writeFile(List<SchoolStudent> Pupils) throws IOException {
		String filename = "Pupils.txt";
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		fos = new FileOutputStream(filename);
		out = new ObjectOutputStream(fos);
		out.writeObject(Pupils);
		out.close();
	}
}
