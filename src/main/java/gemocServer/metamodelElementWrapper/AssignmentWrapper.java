package main.java.gemocServer.metamodelElementWrapper;

import org.tetrabox.minijava.model.miniJava.impl.AssignmentImpl;

public class AssignmentWrapper extends MetamodelElementWrapper {
	
	private AssignmentImpl wrappedElement;
	
	
	public AssignmentWrapper(AssignmentImpl wrappedEl) {
		this.wrappedElement = wrappedEl;
	}
	
	public String getAssignee() {
		return "";
	}
	
	public String getExpression() {
		return "";
	}

}
