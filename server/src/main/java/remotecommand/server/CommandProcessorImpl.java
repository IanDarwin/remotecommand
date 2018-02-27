package remotecommand.server;

import java.io.*;
import java.rmi.*;
import java.rmi.server.*;
import java.util.concurrent.*;

import remotecommand.*;

/** The work part of the server implementation - called when a client comes along */
public class CommandProcessorImpl implements CommandProcessor, Serializable {

	protected static final Executor threadPool = Executors.newSingleThreadExecutor();

	public void submit(Command cmd) {
		System.out.println("Processing command " + cmd);
		threadPool.execute(cmd);
	}
}
