package remotecommand.server;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.concurrent.*;

import remotecommand.*;

/*
 * Server that accepts client Command objects and runs them.
 */
public class Server extends UnicastRemoteObject implements CommandProcessor {

	protected final static String host = "localhost";

	protected final Executor threadPool = Executors.newSingleThreadExecutor();

	/** No-argument constructor required as we are a Remote Object */
	public Server() throws RemoteException {
		// Empty
	}

	/** This is the main program, just to get things started. */
	public static void main(String[] argv) throws IOException, NotBoundException {

		// Instantiate and register the service object
		new Server().runServer();

		// We don't want the arbitrary code to be too arbitrary...
		System.setSecurityManager(new RMISecurityManager());
	}

	/** This is the server setup part -- bind into the RMI registry */
	private void runServer() throws IOException, NotBoundException {

		System.out.println("Server instance starting");

		// First, register us with the RMI registry
		Naming.rebind(Command.REGISTER_NAME, this);
	
		System.out.println("Server program bound.");
	}

	/** The main body of the server implementation - called when a client comes alone */
	public void submit(Command cmd) {
		System.out.println("Processing command " + cmd);
		threadPool.execute(cmd);
	}
}
