package remotecommand;

import java.io.Serializable;

public interface Command extends Runnable, Serializable {

	public static final String REGISTER_NAME = "RemoteCommand";

	// empty of methods - none needed
}
