/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.debug;

/**
 * DebugMessages are exchanged between the debug server (the Eclipse debug
 * framework) and the debug client (a running process or interpreter). To exchange
 * messages they are serialized and sent over sockets.
 */
public class MgtDebugMessage {
	
	private static final char DELIMITER = ':';
	private de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes messageType;
	private String[] arguments;
	
	public MgtDebugMessage(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes messageType, String[] arguments) {
		super();
		this.messageType = messageType;
		this.arguments = arguments;
	}
	
	public MgtDebugMessage(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes messageType, java.util.List<String> arguments) {
		super();
		this.messageType = messageType;
		this.arguments = new String[arguments.size()];
		for (int i = 0; i < arguments.size(); i++) {
			this.arguments[i] = arguments.get(i);
		}
	}
	
	public de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes getMessageType() {
		return messageType;
	}
	
	public String[] getArguments() {
		return arguments;
	}
	
	public String serialize() {
		java.util.List<String> parts = new java.util.ArrayList<String>();
		parts.add(messageType.name());
		for (String argument : arguments) {
			parts.add(argument);
		}
		return de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.encode(DELIMITER, parts);
	}
	
	public static MgtDebugMessage deserialize(String response) {
		java.util.List<String> parts = de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.decode(response, DELIMITER);
		String messageType = parts.get(0);
		String[] arguments = new String[parts.size() - 1];
		for (int i = 1; i < parts.size(); i++) {
			arguments[i - 1] = parts.get(i);
		}
		de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes type = de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.valueOf(messageType);
		MgtDebugMessage message = new MgtDebugMessage(type, arguments);
		return message;
	}
	
	public boolean hasType(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes type) {
		return this.messageType == type;
	}
	
	public String getArgument(int index) {
		return getArguments()[index];
	}
	
	public String toString() {
		return this.getClass().getSimpleName() + "[" + messageType.name() + ": " + de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.explode(arguments, ", ") + "]";
	}
	
}
