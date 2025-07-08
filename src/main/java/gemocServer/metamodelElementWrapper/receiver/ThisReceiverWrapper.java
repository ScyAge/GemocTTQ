package main.java.gemocServer.metamodelElementWrapper.receiver;

import org.tetrabox.minijava.model.miniJava.Expression;

public class ThisReceiverWrapper extends AbstractReceiverWrapper {
	
	
	
	
	public ThisReceiverWrapper(Expression receiver) {
		super(receiver);
	}

	@Override
	public String getReceiverName() {
		return "this";
	}

}
