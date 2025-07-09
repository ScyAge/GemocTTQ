package main.java.gemocServer.wrapperVisitor;

import main.java.gemocServer.metamodelElementWrapper.AssignmentWrapper;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;
import main.java.gemocServer.metamodelElementWrapper.NewObjectWrapper;

public class MetamodelElementWrapperVisitor {

	public MetamodelElementWrapperVisitor() {
		// TODO Auto-generated constructor stub
	}
	
	public String visit(MetamodelElementWrapper<?> wrapper) {
		return wrapper.accept(this);
	}
	
	public String visit(MethodCallWrapper methodCall) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("{ \"messageReceiver\" : \"%s\", ",methodCall.getReceiverName()));
		builder.append(String.format(" \"messageSelector\" : \"%s\",",methodCall.getMethodName()));
		builder.append(String.format(" \"stepNumber\" : \"%s\", ",methodCall.getRuntimeStep  ().getNumber()));
		builder.append("\"programStateType\" : \"methodCall\"}");
		//builder.append(String.format(" \"elementType\" : \"%s\" } ",methodCall.getWrappedElement().eStaticClass());		
		return builder.toString();
	}
	
	//TODO
	public String visit(AssignmentWrapper assignment) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("{ \"assigneeName\" : \"%s\", ",assignment.getAssignee().getName()));
		builder.append(String.format(" \"assigneeType\" : \"%s\"} ",assignment.getAssignee().getTypeRef().getClass().getSimpleName()));
		//builder.append(String.format(" \"value\" : \"%s\", ",assignment.get));
		//builder.append(String.format(" \"valueType\" : \"%d\" }",methodCall.getRuntimeStep().getNumber()));
		return builder.toString();
	}
	
	public String visit(NewObjectWrapper newObject) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("{ \"newObjectType\" : \"%s\", ",newObject.getNewObjectType()));
		builder.append(String.format(" \"stepNumber\" : \"%s\", ",newObject.getRuntimeStep  ().getNumber()));
		builder.append("\"programStateType\" : \"newInstance\"}");
		return builder.toString();
	}

}
