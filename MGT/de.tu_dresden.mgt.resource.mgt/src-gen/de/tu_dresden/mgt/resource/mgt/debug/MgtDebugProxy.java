/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package de.tu_dresden.mgt.resource.mgt.debug;

/**
 * The DebugProxy allows to communicate between the interpreter, which runs in a
 * separate thread or process and the Eclipse Debug framework (i.e., the
 * DebugTarget class).
 */
public class MgtDebugProxy {
	
	public static final int STARTUP_DELAY = 1000;
	
	private java.io.PrintStream output;
	
	private java.io.BufferedReader reader;
	
	private de.tu_dresden.mgt.resource.mgt.debug.MgtDebugTarget debugTarget;
	
	private de.tu_dresden.mgt.resource.mgt.debug.MgtDebugCommunicationHelper communicationHelper = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugCommunicationHelper();
	
	public MgtDebugProxy(de.tu_dresden.mgt.resource.mgt.debug.MgtDebugTarget debugTarget, int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		this.debugTarget = debugTarget;
		// give interpreter a chance to start
		try {
			Thread.sleep(STARTUP_DELAY);
		} catch (InterruptedException e) {
		}
		startSocket(requestPort);
	}
	
	private void startSocket(int requestPort) throws java.net.UnknownHostException, java.io.IOException {
		// creating client proxy socket (trying to connect)...
		java.net.Socket client = new java.net.Socket("localhost", requestPort);
		// creating client proxy socket - done. (connected)
		try {
			java.io.BufferedInputStream input = new java.io.BufferedInputStream(client.getInputStream());
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(input));
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
		try {
			output = new java.io.PrintStream(client.getOutputStream());
		} catch (java.io.IOException e) {
			System.out.println(e);
		}
	}
	
	public void resume() {
		sendCommand(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.RESUME);
	}
	
	public void stepOver() {
		sendCommand(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.STEP_OVER);
	}
	
	public void stepInto() {
		sendCommand(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.STEP_INTO);
	}
	
	public void stepReturn() {
		sendCommand(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.STEP_RETURN);
	}
	
	public void terminate() {
		sendCommand(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.EXIT);
	}
	
	public de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage getStack() {
		return sendCommandAndRead(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.GET_STACK);
	}
	
	public void addLineBreakpoint(String location, int line) {
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage message = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.ADD_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public void removeLineBreakpoint(String location, int line) {
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage message = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.REMOVE_LINE_BREAKPOINT, new String[] {location, Integer.toString(line)});
		communicationHelper.sendEvent(message, output);
	}
	
	public org.eclipse.debug.core.model.IVariable[] getStackVariables(String stackFrame) {
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage response = sendCommandAndRead(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.GET_FRAME_VARIABLES, new String[] {stackFrame});
		String[] ids = response.getArguments();
		// fetch all variables
		org.eclipse.debug.core.model.IVariable[] variables = getVariables(ids);
		return variables;
	}
	
	public org.eclipse.debug.core.model.IVariable[] getVariables(String... requestedIDs) {
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage response = sendCommandAndRead(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes.GET_VARIABLES, requestedIDs);
		String[] varStrings = response.getArguments();
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugVariable[] variables  = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugVariable[varStrings.length];
		int i = 0;
		for (String varString : varStrings) {
			java.util.Map<String, String> properties = de.tu_dresden.mgt.resource.mgt.util.MgtStringUtil.convertFromString(varString);
			
			// convert varString to variables and values
			String valueString = properties.get("!valueString");
			String valueRefType = "valueRefType";
			java.util.Map<String, Long> childVariables = new java.util.TreeMap<String, Long>(new java.util.Comparator<String>() {
				public int compare(String s1, String s2) {
					return s1.compareToIgnoreCase(s2);
				}
			});
			for (String property : properties.keySet()) {
				// ignore special properties - they are not children
				if (property.startsWith("!")) {
					continue;
				}
				childVariables.put(property, Long.parseLong(properties.get(property)));
			}
			String id = properties.get("!id");
			org.eclipse.debug.core.model.IValue value = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugValue(debugTarget, id, valueString, valueRefType, childVariables);
			
			String variableName = properties.get("!name");
			String variableRefType = properties.get("!type");
			
			de.tu_dresden.mgt.resource.mgt.debug.MgtDebugVariable variable = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugVariable(debugTarget, variableName, value, variableRefType);
			variables[i++] = variable;
		}
		return variables;
	}
	
	private void sendCommand(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes command, String... parameters) {
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage message = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage(command, parameters);
		communicationHelper.sendEvent(message, output);
	}
	
	private de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage sendCommandAndRead(de.tu_dresden.mgt.resource.mgt.debug.EMgtDebugMessageTypes command, String... parameters) {
		de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage message = new de.tu_dresden.mgt.resource.mgt.debug.MgtDebugMessage(command, parameters);
		return communicationHelper.sendAndReceive(message, output, reader);
	}
	
}
