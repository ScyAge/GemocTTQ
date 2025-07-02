package main.java.runtimeStepExplorer;


import org.tetrabox.minijava.model.miniJava.Assignment;
import org.tetrabox.minijava.model.miniJava.MethodCall;
import org.tetrabox.minijava.model.miniJava.impl.AssignmentImpl;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;
import org.tetrabox.minijava.model.miniJava.util.MiniJavaSwitch;

import main.java.gemocServer.metamodelElementWrapper.AssignmentWrapper;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;

public class MiniJavaVisitor extends MiniJavaSwitch<MetamodelElementWrapper>{
	
	public MetamodelElementWrapper caseMethodCall(MethodCall methodCall) {
		MethodCallImpl mCall = (MethodCallImpl) methodCall;
		return new MethodCallWrapper(mCall);
		
	}
	
	public MetamodelElementWrapper caseAssignment(Assignment object) {
		AssignmentImpl assignment = (AssignmentImpl) object;
		return new AssignmentWrapper(assignment);
	}
}
