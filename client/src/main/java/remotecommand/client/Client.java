package remotecommand.client;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;

import remotecommand.*;

/**
 *	Main program to run the client.
 */
public class Client {

	protected final static String host = "localhost";

	/** This is the main program, just to get things started. */
	public static void main(String[] argv) throws IOException, NotBoundException {
		new Client().do_the_work();
	}

	/** This is the client program part */
	private void do_the_work() throws IOException, NotBoundException {

		System.out.println("Client starting");

		// Find the server, and register with it
		System.out.println("Finding server");
		CommandProcessor server = 
			(CommandProcessor)Naming.lookup("rmi://" + host + "/" +
			Command.REGISTER_NAME);

		// Create a Command and send it to the server
		System.out.println("Connecting to server");
		server.submit(() -> System.out.println("Hello world"));

		System.out.println("Command sent to server; look for output in server log.");
	}

	/** This is the client callback */
	public void alert(String message) throws RemoteException {
		System.out.println(message);
	}
}
// END main
