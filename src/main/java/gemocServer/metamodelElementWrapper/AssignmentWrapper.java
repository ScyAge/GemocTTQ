package main.java.gemocServer.metamodelElementWrapper;

import org.tetrabox.minijava.model.miniJava.impl.AssignmentImpl;
import org.tetrabox.minijava.model.miniJava.impl.ExpressionImpl;
import org.tetrabox.minijava.model.miniJava.impl.VariableDeclarationImpl;

import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;

public class AssignmentWrapper extends MetamodelElementWrapper<AssignmentImpl> {
	
	
	
	
	public AssignmentWrapper(AssignmentImpl wrappedEl) {
		this.wrappedElement = wrappedEl;
	}
	
	public VariableDeclarationImpl getAssignee() {
		return (VariableDeclarationImpl) this.wrappedElement.getAssignee();
	}
	
	public ExpressionImpl getExpression() {
		return (ExpressionImpl) this.wrappedElement.getValue();
	}

	@Override
	public String accept(MetamodelElementWrapperVisitor visitor) {
		// TODO Auto-generated method stub
		return visitor.visit(this);
	}

}
