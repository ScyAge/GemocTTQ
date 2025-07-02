package main.java.gemocServer.metamodelElementWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStateImpl;
import org.tetrabox.minijava.model.miniJava.Expression;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;
import org.tetrabox.minijava.model.miniJava.impl.MethodImpl;
import org.tetrabox.minijava.model.miniJava.impl.SymbolRefImpl;
import org.tetrabox.minijava.model.miniJava.impl.VariableDeclarationImpl;
import org.tetrabox.minijava.model.miniJava.semantics.impl.MethodCall2Impl;

import main.java.gemocServer.runtimeStepReader.MetamodelElementWrapperReaderVisitor;

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
		RuntimeStateImpl subState = (RuntimeStateImpl) this.runtimeStep.getSubSteps().get(0).getSourceState();
		MethodCall2Impl mCall = (MethodCall2Impl)this.getChildFrameFromRootFrame(subState).getCall();
		return mCall.getMethodcall().getReceiver();
		
	}
	public MethodImpl getMethodName() {
		/**
		MethodImpl method = (MethodImpl) this.wrappedMethodCall.getMethod();
		return method.getName();
		**/
		return (MethodImpl) this.wrappedMethodCall.getMethod();
	}
	
	public void setRuntimeStep(RuntimeStateImpl state) {
		this.runtimeState = state;
	}
	
}
