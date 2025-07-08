package main.java.gemocServer.routes;


import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;
import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;
import main.java.runtimeStepExplorer.RuntimeStepExplorer;
import test.java.TTQTestResources;
import io.javalin.http.Context;



public class TestRuntimeRoute extends AbstractRoute {
	

	
	
	@Override
	public void result(Context context) {
		 
		EList<RuntimeStep> ressources = TTQTestResources.miniJavaRootStepsExample();
		RuntimeStepExplorer exp = new RuntimeStepExplorer();
		
		
		exp.explore(ressources);
		List<MetamodelElementWrapper> wrappers = exp.getList();

		
		context.status(200).json(this.buildJson(wrappers));
	}
	
	private String buildJson(List<MetamodelElementWrapper> wrappers) {
		MetamodelElementWrapperVisitor visitor = new MetamodelElementWrapperVisitor();
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");

		for(int i = 0; i < wrappers.size(); i++) {
			builder.append(String.format("\"%d\" : %s", wrappers.get(i).getRuntimeStep().getNumber(),visitor.visit(wrappers.get(i))));
			if(i < (wrappers.size()-1)) {
				builder.append(",");
			}
			builder.append("\n");
		}
		builder.append("}");
		return builder.toString();
	}
	


}

