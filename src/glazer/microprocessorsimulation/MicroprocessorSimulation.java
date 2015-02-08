package glazer.microprocessorsimulation;

public class MicroprocessorSimulation {

	private String input;
	private String a;
	private String b;
	private int counter;
	private char[] array;

	public MicroprocessorSimulation(String input) {
		this.array = input.toCharArray();
		this.input = input;
		this.a = "0";
		this.b = "0";
		this.counter = 0;
	}

	public void compute() {
		char next = array[0];
		while (array[counter] != '8') {

			next = array[counter];
			counter++;
			process(next);
		}
		addNewLine();
	}

	public void process(char next) {

		switch (next) {

		case '0': {
			a = memoryAt(array[counter], array[counter + 1]);
			counter += 2;
			break;
		}
		case '1': {
			writeTo(array[counter], array[counter + 1]);
			counter += 2;
			break;
		}
		case '2': {
			String temp;
			temp = a;
			a = b;
			b = temp;
			break;
		}
		case '3': {

			Integer sum = Integer.parseInt(a, 16) + Integer.parseInt(b, 16);
			String hex = Integer.toHexString(sum);

			if (hex.length() == 2) {
				a = hex.substring(1);
				b = hex.substring(0, 1);
			} else {
				a = hex;
				b = "0";
			}
			break;
		}
		case '4': {
			int hex = Integer.parseInt(a, 16);
			if (hex == 15) {
				hex = 0;
			} else {
				hex++;
			}
			a = Integer.toHexString(hex);
			break;
		}
		case '5': {
			int hex = Integer.parseInt(a, 16);
			if (hex == 0) {
				hex = 15;
			} else {
				hex--;
			}
			a = Integer.toHexString(hex);
			break;
		}
		case '6': {
			if (a.equals("0")) {

				int loc = Integer.parseInt(
						String.join("", String.valueOf(array[counter]), String.valueOf(array[counter + 1])), 16);
				counter = loc;
				process(array[loc]);
			} else {
				counter += 2;
			}
			break;
		}
		case '7': {
			int loc = Integer.parseInt(
					String.join("", String.valueOf(array[counter]), String.valueOf(array[counter + 1])), 16);
			counter = loc;
			counter++;
			process(array[loc]);

			break;
		}
		case '8': {
			break;

		}
		}
	}

	public void addNewLine() {

		input = String.join("", input, "\n");

	}

	public String printMemory() {
		return input;
	}

	public void writeTo(char c, char b) {
		String loc = String.join("", String.valueOf(c), String.valueOf(b));
		a = a.toUpperCase();
		array[Integer.parseInt(loc, 16)] = a.charAt(0);
		input = String.valueOf(array);
	}

	public String memoryAt(char a, char b) {
		String loc = String.join("", String.valueOf(a), String.valueOf(b));
		return String.valueOf(array[Integer.parseInt(loc, 16)]);
	}

	public static void main(String[] args) {

		String input = "040563B14004220FF31FF041320FE31FE00C2042314200032041314170080000F03000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000001";
		MicroprocessorSimulation sim = new MicroprocessorSimulation(input);
		sim.compute();
		System.out.print(sim.printMemory());
		String input2 = "0102011311321128FF0000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000";
		MicroprocessorSimulation sim2 = new MicroprocessorSimulation(input2);
		sim2.compute();
		System.out.print(sim2.printMemory());

	}

}
