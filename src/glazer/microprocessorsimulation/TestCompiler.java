package glazer.microprocessorsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.junit.Assert;
import org.junit.Test;

public class TestCompiler {

	@Test
	public void test() {
		Scanner input;
		try {
			input = new Scanner(new File("input2.txt"));
			Compiler com = new Compiler(input);
			com.compute();
			String output = "040563B14004220FF31FF041320FE31FE00C2042314200032041314170080000F03000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
			Assert.assertEquals(output, com.getByteCode());
		} catch (FileNotFoundException | InvalidCodeError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
