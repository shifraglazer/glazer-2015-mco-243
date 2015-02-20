package glazer.microprocessorsimulation;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Compiler {

	private Scanner input;
	private StringBuilder byteCode;
	private char array[];
	private int counter;
	public Compiler(Scanner input) {
		this.input = input;
		byteCode = new StringBuilder();
		counter=0;
		array=new char[256];
	}

	public void compute() throws InvalidCodeError {
		String arg;
		while (input.hasNext()) {
			String code = input.next();
			code = code.toUpperCase();
			arg = null;
			switch (code) {
			case "LD": {
				array[counter++]='0';
				//byteCode.append("0");
				arg = input.next();
				break;
			}
			case "ST": {
				array[counter++]='1';
				//byteCode.append("1");
				arg = input.next();

				break;
			}
			case "SWP": {
				array[counter++]='2';
				//byteCode.append("2");

				break;
			}
			case "ADD": {
				array[counter++]='3';
				//byteCode.append("3");

				break;
			}
			case "INC": {
				array[counter++]='4';
				//byteCode.append("4");

				break;
			}
			case "DEC": {
				array[counter++]='5';
				//byteCode.append("5");

				break;
			}
			case "BZ": {
				byteCode.append("6");
				arg = input.next();
				break;
			}
			case "BR": {
				byteCode.append("7");
				arg = input.next();
				break;
			}
			case "STP": {
				byteCode.append("8");
				break;

			}
			
			case "DATA":{
				arg=input.next();
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
				if (arg.length() == 2||arg.length()==3) {
					arg = Integer.toHexString(Integer.valueOf(arg));
					arg=arg.toUpperCase();
					if(arg.length()==1){
						byteCode.append("0");
					}
					byteCode.append(arg);
				}

			}
			if (input.hasNext()) {
				input.nextLine();
			}
		}
	}

	public String getByteCode() {
		String code=byteCode.toString();
		for (int i =code.length() ; i < 256; i++) {
			byteCode.append("0");
		}
		code=byteCode.toString();
		return code;
	}

	public static void main(String args[]) {
		//String machineCode = "LD 16\n SWP\n LD 17\n ADD\n ST 19\n SWP \n ST 18\n STP\n";
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
