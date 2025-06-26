package test.java;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.eclipse.gemoc.trace.simple.SimpleTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tetrabox.minijava.model.miniJava.MiniJavaPackage;

import main.java.TTQSelectionFunctions;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;
import main.java.runtimeStepExplorer.RuntimeStepExplorer;
import main.java.gemocServer.metamodelElementWrapper.generatedWrapper.*;


public class TestTTQSelection {

	EClass methodCallClass = MiniJavaPackage.eINSTANCE.getMethodCall();
	@Test
	public void testIsMethodCall() {
	
		RuntimeStep methodCallStep = TTQTestResources.miniJavaMethodCallStepExample();
		EList<RuntimeStep> test = TTQTestResources.miniJavaRootStepsExample();
		//Assertions.assertTrue(TTQSelectionFunctions.isKindOf(methodCallClass, methodCallStep));
		Set<MetamodelElementWrapper> elements = new HashSet<>();
		elements.add(new MethodCallWrapper());
		elements.add(new MethodImplWrapper());
		elements.add(new ExpressionImplWrapper());
		RuntimeStepExplorer exp = new RuntimeStepExplorer(elements);
		exp.explore(methodCallStep);
		List<MetamodelElementWrapper> res = exp.getList();
		
	}
	
	@Test
	public void testAllMethodCallSelection() {
	
		EList<RuntimeStep> steps = TTQTestResources.miniJavaRootStepsSubstepsExample();
		List<RuntimeStep> selection = TTQSelectionFunctions.allOfKind(methodCallClass, steps);
		//Assertions.assertTrue(selection.stream().allMatch(step -> step.getSemanticRuleStaticTarget().eClass() == MiniJavaPackage.eINSTANCE.getMethodCall()));	
	}
}
