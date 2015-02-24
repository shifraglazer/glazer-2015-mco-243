package glazer.microprocessorsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compiler {

	private Scanner input;
	private char array[];
	private int counter;

	public Compiler(Scanner input) {
		this.input = input;
		counter = 0;
		array = new char[256];
	}

	public void compute() throws InvalidCodeError {
		String arg;
		while (input.hasNext()) {
			String code = input.next();
			code = code.toUpperCase();
			arg = null;
			switch (code) {
			case "LD": {
				array[counter++] = '0';
				arg = input.next();
				break;
			}
			case "ST": {
				array[counter++] = '1';
				arg = input.next();

				break;
			}
			case "SWP": {
				array[counter++] = '2';

				break;
			}
			case "ADD": {
				array[counter++] = '3';

				break;
			}
			case "INC": {
				array[counter++] = '4';

				break;
			}
			case "DEC": {
				array[counter++] = '5';

				break;
			}
			case "BZ": {
				array[counter++] = '6';

				arg = input.next();
				break;
			}
			case "BR": {
				array[counter++] = '7';

				arg = input.next();
				break;
			}
			case "STP": {
				array[counter++] = '8';

				break;

			}

			case "DATA": {
				int location = input.nextInt();
				Integer data = input.nextInt();
				array[location] = (char) (Integer.toHexString(data)
						.toUpperCase()).charAt(0);
				break;
			}

			default: {
				if (code.length() >= 2) {
					code = code.substring(0, 2);
					if (code.equals("\\")) {
						break;
					}
				} else {
					throw new InvalidCodeError();
				}
			}
			}
			if (arg != null) {
				if (arg.length() == 2 || arg.length() == 3) {
					arg = Integer.toHexString(Integer.valueOf(arg));
					arg = arg.toUpperCase();
					if (arg.length() == 1) {

						array[counter++] = '0';
						array[counter++] = arg.charAt(0);
					}

					else {
						array[counter++] = arg.charAt(0);
						array[counter++] = arg.charAt(1);
					}
				}

			}
			if (input.hasNext()) {
				input.nextLine();
			}
		}
	}

	public String getByteCode() {
		for (int i = 0; i < array.length; i++) {
			if (array[i] == '\0') {
				array[i] = '0';
			}
		}
		return String.valueOf(array);
	}

	public static void main(String args[]) {
		// String machineCode =
		// "LD 16\n SWP\n LD 17\n ADD\n ST 19\n SWP \n ST 18\n STP\n";
		Scanner input;
		try {
			input = new Scanner(new File("input2.txt"));
			Compiler compiler = new Compiler(input);
			compiler.compute();
			System.out.println(compiler.getByteCode());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidCodeError e) {
			System.out.println(e.getMessage());
		}

	}
}
