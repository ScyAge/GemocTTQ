package main.java.runtimeStepExplorer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.eclipse.gemoc.trace.simple.impl.RuntimeStepImpl;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;

public class RuntimeStepExplorer {
	
	private final List<MetamodelElementWrapper<?>> list = new ArrayList<>(); 
	private final MetaModelElementExplorer explorer;
	
	public RuntimeStepExplorer() {
		explorer = new MetaModelElementExplorer();
	}
	
	
	/**
	 * This method explores a RuntimeStep and wraps the SemanticRuleStaticTarget and recursively explores the substeps 
	 * of this step 
	 * @param aStep
	 */
	public void explore(RuntimeStep aStep) {
		
		MetamodelElementWrapper<?> wrapper = this.explorer.getWrapper(aStep.getSemanticRuleStaticTarget());
		if(wrapper != null) {
			wrapper.setRuntimeStep((RuntimeStepImpl)aStep);
			list.add(wrapper);
		}
		if(aStep.getSubSteps() != null) {
			this.explore(aStep.getSubSteps());
		}
		
	}
	
	/**
	 * This method explores a list of RuntimeStep and explore each of the step of the list
	 * @param aListOfStep
	 */
	public void explore(EList<RuntimeStep> aListOfStep) {
		aListOfStep.forEach(step -> this.explore(step));
	}
	
	
	
	public List<MetamodelElementWrapper<?>> getList(){
		return list;
	}
	
	

	
	
}
