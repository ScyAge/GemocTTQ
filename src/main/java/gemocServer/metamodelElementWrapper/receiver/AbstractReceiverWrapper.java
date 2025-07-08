package main.java.gemocServer.metamodelElementWrapper.receiver;

import org.tetrabox.minijava.model.miniJava.Expression;
import org.tetrabox.minijava.model.miniJava.impl.ExpressionImpl;

public abstract class AbstractReceiverWrapper {
	
	protected ExpressionImpl receiver;
	
	public AbstractReceiverWrapper(Expression receiver) {
		this.receiver = (ExpressionImpl) receiver;
	}
	
	
	public abstract String getReceiverName();
}
