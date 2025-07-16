package main.java.gemocServer.routes;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gemoc.trace.simple.RuntimeStep;

import io.javalin.http.Context;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;
import main.java.runtimeStepExplorer.RuntimeStepExplorer;
import test.java.TTQTestResources;

public class GetChoosenTrace extends AbstractRoute {
	
	private TraceNameContainer cont;
	
	
	
	public GetChoosenTrace(TraceNameContainer cont) {
		super();
		this.cont = cont;
	}



	@Override
	public void result(Context context) {
		String trace = cont.getTraceName();
		if(trace != null) {
			//TODO take the trace from the folder and not the generic one 
			EList<RuntimeStep> ressources = TTQTestResources.miniJavaRootStepsExample();
			RuntimeStepExplorer exp = new RuntimeStepExplorer();
		
		
			exp.explore(ressources);
			List<MetamodelElementWrapper<?>> wrappers = exp.getList();

		
			context.status(200).json(this.buildJson(wrappers));
		}
		else {
			context.status(400).json(Map.of("error", "Trace name has not been loaded"));
		}
		System.out.println("test");
	}
	
	private String buildJson(List<MetamodelElementWrapper<?>> wrappers) {
		MetamodelElementWrapperVisitor visitor = new MetamodelElementWrapperVisitor();
		StringBuilder builder = new StringBuilder();
		builder.append("{\n");

		for(int i = 0; i < wrappers.size(); i++) {
			builder.append(String.format("\"%d\" : %s", i,visitor.visit(wrappers.get(i))));
			if(i < (wrappers.size()-1)) {
				builder.append(",");
			}
			builder.append("\n");
		}
		builder.append("}");
		return builder.toString();
	}

}
