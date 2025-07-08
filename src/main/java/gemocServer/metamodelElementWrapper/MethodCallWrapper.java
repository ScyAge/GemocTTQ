package main.java.gemocServer.metamodelElementWrapper;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStateImpl;
import org.tetrabox.minijava.model.miniJava.Expression;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;
import org.tetrabox.minijava.model.miniJava.impl.MethodImpl;


import main.java.gemocServer.metamodelElementWrapper.receiver.AbstractReceiverWrapper;
import main.java.gemocServer.metamodelElementWrapper.receiver.ThisReceiverWrapper;
import main.java.gemocServer.metamodelElementWrapper.receiver.VarReceiverWrapper;
import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;


public class MethodCallWrapper extends MetamodelElementWrapper{

	private MethodCallImpl wrappedMethodCall;
	private RuntimeStateImpl runtimeState;
	
	public MethodCallWrapper(MethodCallImpl methodCall) {
		wrappedMethodCall = methodCall;
		runtimeState = null;
	}
	public MethodCallWrapper() {
	
	}
	
	public Expression getReceiver() {
		/**
		SymbolRefImpl receiver = (SymbolRefImpl) this.wrappedMethodCall.getReceiver();
		VariableDeclarationImpl test = (VariableDeclarationImpl) receiver.basicGetSymbol();
		return test.getName();
		**/
		//RuntimeStateImpl subState = (RuntimeStateImpl) this.runtimeStep.getSubSteps().get(0).getSourceState();
		//MethodCall2Impl mCall = (MethodCall2Impl)this.getChildFrameFromRootFrame(subState).getCall();
		//return mCall.getMethodcall().getReceiver();
		return this.wrappedMethodCall.getReceiver();
		
	}
	public MethodImpl getMethod() {
		/**
		MethodImpl method = (MethodImpl) this.wrappedMethodCall.getMethod();
		return method.getName();
		**/
		return (MethodImpl) this.wrappedMethodCall.getMethod();
	}
	
	public EList<Expression> getArgs(){
		return this.wrappedMethodCall.getArgs();
	}
	
	public void setRuntimeStep(RuntimeStateImpl state) {
		this.runtimeState = state;
	}
	
	public AbstractReceiverWrapper getWrappedReceiver() {
		String n = this.getReceiver().getClass().getSimpleName();
		switch(n) {
		case "ThisImpl": return new ThisReceiverWrapper(this.getReceiver());
		case "SymbolRefImpl": return new VarReceiverWrapper(this.getReceiver());
		default: return null;
			
		}
	}
	
	public String getMethodName() {
		return this.wrappedMethodCall.getMethod().getName();
	}
	
	public String getReceiverName() {
		AbstractReceiverWrapper wrapper = this.getWrappedReceiver();
		if(wrapper != null) {
			return this.getWrappedReceiver().getReceiverName();
		}
		return "";
		
	}
	@Override
	public String accept(MetamodelElementWrapperVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);	}
	
	
}
