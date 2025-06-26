package main.java.gemocServer.metamodelElementWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.tetrabox.minijava.model.miniJava.Expression;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;
import org.tetrabox.minijava.model.miniJava.impl.MethodImpl;
import org.tetrabox.minijava.model.miniJava.impl.SymbolRefImpl;
import org.tetrabox.minijava.model.miniJava.impl.VariableDeclarationImpl;

import main.java.gemocServer.runtimeStepReader.MetamodelElementWrapperReaderVisitor;

public class MethodCallWrapper extends MetamodelElementWrapper{

	private MethodCallImpl wrappedMethodCall;
	private String test;
	public MethodCallWrapper(MethodCallImpl methodCall) {
		wrappedMethodCall = methodCall;
	}
	public MethodCallWrapper() {
	
	}
	public MethodCallWrapper(String test) {
		this.test = test;
	}
	
	public Expression getReceiver() {
		/**
		SymbolRefImpl receiver = (SymbolRefImpl) this.wrappedMethodCall.getReceiver();
		VariableDeclarationImpl test = (VariableDeclarationImpl) receiver.basicGetSymbol();
		return test.getName();
		**/
		return this.wrappedMethodCall.getReceiver();
		
	}
	public MethodImpl getMethodName() {
		/**
		MethodImpl method = (MethodImpl) this.wrappedMethodCall.getMethod();
		return method.getName();
		**/
		return (MethodImpl) this.wrappedMethodCall.getMethod();
	}


	@Override
	public String accept(MetamodelElementWrapperReaderVisitor visitor) {
		return visitor.visit(this);
	}
	
	public  Optional<MetamodelElementWrapper> test(EObject car) {
		if(car instanceof MethodCallImpl) {
			return Optional.of(new MethodCallWrapper((MethodCallImpl) car)) ;
		}
		
		return Optional.empty();
	}
	
	public String toString() {
		return String.format("nameMethod: %s",this.getMethodName());
		
	}
	
}
