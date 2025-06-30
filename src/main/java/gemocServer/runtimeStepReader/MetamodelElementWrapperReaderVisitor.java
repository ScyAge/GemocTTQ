
package main.java.gemocServer.runtimeStepReader;


import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;

public class MetamodelElementWrapperReaderVisitor {
	
	
	public String visit(MetamodelElementAdapter objectToVisit) {
		return objectToVisit.accept(this);
	}
	
	
	public String visit(MethodCallWrapper methodCallWrapper) {
		StringBuilder builder = new StringBuilder();
		builder.append(String.format("{ \"receiver\" : \"%s\" ",methodCallWrapper.getReceiver()));
		builder.append(String.format(" \"method\" : \"%s\" }",methodCallWrapper.getMethodName()));
		return builder.toString();
	}
}

