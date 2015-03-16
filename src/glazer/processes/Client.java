package glazer.processes;

import java.io.IOException;

import java.io.OutputStream;

import java.io.PrintWriter;

import java.net.Socket;

import java.net.UnknownHostException;

public class Client {

	public static void main(String[] args) {

		Socket socket = null;

		try {

			socket = new Socket("localhost", 3762);

			OutputStream out = socket.getOutputStream();

			PrintWriter writer = new PrintWriter(out);

			writer.println("Do or do not, there is no try.");

			writer.println("Even in the future nothing works.");

			writer.println("Alas earwax!");

			writer.flush();

		} catch (UnknownHostException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

		finally {

			try {

				socket.close();

			} catch (IOException e) {

				e.printStackTrace();

			}

		}

	}

}
