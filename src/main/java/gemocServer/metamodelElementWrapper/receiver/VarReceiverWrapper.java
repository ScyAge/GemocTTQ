package main.java.gemocServer.metamodelElementWrapper.receiver;

import org.tetrabox.minijava.model.miniJava.Expression;
import org.tetrabox.minijava.model.miniJava.impl.SymbolRefImpl;

public class VarReceiverWrapper extends AbstractReceiverWrapper {

	public VarReceiverWrapper(Expression receiver) {
		super(receiver);
	}

	@Override
	public String getReceiverName() {
		SymbolRefImpl var = (SymbolRefImpl) this.receiver;
		return var.getSymbol().getName();
	}

}
