package main.java.gemocServer.wrapperVisitor;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;

public class MetamodelElementWrapperVisitor {

	public MetamodelElementWrapperVisitor() {
		// TODO Auto-generated constructor stub
	}
	
	public String visit(MetamodelElementWrapper wrapper) {
		return wrapper.accept(this);
	}
	
	public String visit(MethodCallWrapper methodCall) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("{ \"receiver\" : \"%s\" ",methodCall.getReceiverName()));
		builder.append(String.format(" \"method\" : \"%s\" }",methodCall.getMethodName()));
		return builder.toString();
	}

}
