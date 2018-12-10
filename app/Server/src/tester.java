import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class tester {
	
	private static Controller classUnderTest = new Controller();;

	
	@Test
	void T001() {
		classUnderTest.loadReservas("T001-load.xml");
		classUnderTest.loadReservas("T001-imput.xml");
		classUnderTest.saveReservas("T001-exit.xml");
		assertTrue(compareFiles("T001-exit.xml", "T001-expected_exit.xml"));
	}
	
	@Test
	void T002() {
		classUnderTest.loadReservas("T002-load.xml");
		classUnderTest.fazRelatorio("T002-imput.xml","T002-exit.txt" );
		assertTrue(compareFiles("T002-exit.txt", "T002-expected_exit.txt"));
	}
	
	
	
	private boolean compareFiles(String fileName1 , String fileName2) {
		String file1 = new String();
		String file2 = new String();
		Charset charset = Charset.forName("UTF-8");
		Path path = Paths.get("", fileName1);
		List<String> lines;
		try {
			lines = Files.readAllLines(path, charset);
		
		
		for (String line : lines) {
			file1 += line + "\n";
		}
		path = Paths.get("", fileName2);
		
		List<String> lines2 = Files.readAllLines(path, charset);
		for (String line : lines2) {
			file2 += line + "\n";
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (file1.equals(file2))
			return true;
		else
			return false;
	}

}
