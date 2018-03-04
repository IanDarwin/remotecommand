package remotecommand.server;

import java.io.Serializable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import remotecommand.Command;
import remotecommand.CommandProcessor;

/** The work part of the server implementation - called when a client comes along */
public class CommandProcessorImpl implements CommandProcessor, Serializable {
	private static final long serialVersionUID = 1L;

	protected static final Executor threadPool = Executors.newSingleThreadExecutor();

	public void submit(Command cmd) {
		System.out.println("Processing command " + cmd);
		threadPool.execute(cmd);
	}
}
