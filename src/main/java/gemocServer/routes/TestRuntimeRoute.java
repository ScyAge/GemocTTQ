package main.java.gemocServer.routes;


import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;


import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;
import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;
import test.java.TTQTestResources;
import io.javalin.http.Context;



public class TestRuntimeRoute extends AbstractRoute {
	

	
	
	@Override
	public void result(Context context) {
		 
		MetamodelElementWrapperVisitor test = new MetamodelElementWrapperVisitor();
		
		RuntimeStep methodCallStep = TTQTestResources.miniJavaMethodCallStepExample();
		
		MethodCallWrapper test2 = new MethodCallWrapper((MethodCallImpl) methodCallStep.getSemanticRuleStaticTarget());
		
		context.status(200).json(test.visit(test2));
	}

}

