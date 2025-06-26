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

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;

public class RuntimeStepExplorer {
	
	private final List<MetamodelElementWrapper> list = new ArrayList<>(); 
	private final Set<MetamodelElementWrapper> setElement; 
	private final MetaModelElementExplorer explorer;
	
	public RuntimeStepExplorer(Set<MetamodelElementWrapper> element) {
		setElement = element;
		explorer = new MetaModelElementExplorer(element);
	}
	
	public void explore(RuntimeStep aStep) {
		
		this.explorer.getWrapper(aStep.getSemanticRuleStaticTarget()).ifPresent(list::add);;
		
		if(!aStep.getSubSteps().isEmpty()) {
			this.explore(aStep.getSubSteps());
		}
		
	}
	
	
	public void explore(EList<RuntimeStep> aListOfStep) {
		aListOfStep.forEach(step -> this.explore(step));
	}
	
	
	
	public List<MetamodelElementWrapper> getList(){
		return list;
	}
	
	

	
	
}
