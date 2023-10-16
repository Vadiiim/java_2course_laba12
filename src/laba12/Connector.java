package laba12;
import java.io.*;
public class Connector {
	private File file;

	public File getFile() {
		return file;
	}

	public Connector(String filename) {
		this.file = new File(filename);
	}

	public Connector(File file) {
		this.file = file;
	}

	public void write(Library[] lib) throws IOException {
		FileOutputStream fos = new FileOutputStream(file);
		try (ObjectOutputStream oos = new ObjectOutputStream(fos)) {
			oos.writeInt(lib.length);
			for (int i = 0; i < lib.length; i++) {
				oos.writeObject(lib[i]);
			}
			oos.flush();
		}
	}

	public Library [] read() throws IOException, ClassNotFoundException {
		FileInputStream fis = new FileInputStream(file);
		try (ObjectInputStream oin = new ObjectInputStream(fis)) {
			int length = oin.readInt();
			Library [] result = new Library [length];
			for (int i = 0; i < length; i++) {
				result[i] = (Library) oin.readObject();
			}
			return result;
		}
	}

}
