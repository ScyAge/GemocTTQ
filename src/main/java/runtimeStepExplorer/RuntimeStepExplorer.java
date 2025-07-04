package main.java.runtimeStepExplorer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.tetrabox.minijava.model.miniJava.MethodCall;
import org.tetrabox.minijava.model.miniJava.impl.MethodCallImpl;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;

public class RuntimeStepExplorer {
	
	private final List<MetamodelElementAdapter> list = new ArrayList<>(); 
	private final MetaModelElementExplorer explorer;
	
	public RuntimeStepExplorer(Set<MetamodelElementAdapter> element) {
		explorer = new MetaModelElementExplorer(element);
	}
	
	public void explore(RuntimeStep aStep) {
		
		this.explorer.getWrapper(aStep.getSemanticRuleStaticTarget()).ifPresent(list::add);;
		if(aStep.getSubSteps() != null) {
			this.explore(aStep.getSubSteps());
		}
		
	}
	
	
	public void explore(EList<RuntimeStep> aListOfStep) {
		aListOfStep.forEach(step -> this.explore(step));
	}
	
	
	
	public List<MetamodelElementAdapter> getList(){
		return list;
	}
	
	

	
	
}
