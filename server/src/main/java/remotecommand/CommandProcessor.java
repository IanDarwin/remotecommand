package remotecommand;

import java.rmi.*;

public interface CommandProcessor extends Remote {

	void submit(Command c);
}
