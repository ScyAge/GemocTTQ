package test.java;


import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.eclipse.gemoc.trace.simple.SimpleTrace;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.tetrabox.minijava.model.miniJava.Expression;
import org.tetrabox.minijava.model.miniJava.MiniJavaPackage;

import main.java.TTQSelectionFunctions;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.metamodelElementWrapper.MethodCallWrapper;
import main.java.runtimeStepExplorer.MetaModelElementExplorer;
import main.java.runtimeStepExplorer.RuntimeStepExplorer;

public class TestTTQSelection {

	EClass methodCallClass = MiniJavaPackage.eINSTANCE.getMethodCall();
	@Test
	public void testIsMethodCall() {
	
		RuntimeStep methodCallStep = TTQTestResources.miniJavaMethodCallStepExample();
		EList<RuntimeStep> test = TTQTestResources.miniJavaRootStepsExample();
		SimpleTrace trace = TTQTestResources.miniJavaTraceExample();
		TreeIterator<EObject> e = trace.eAllContents();
		
		//MetaModelElementExplorer n = new MetaModelElementExplorer();
		//List<Object> a = n.testMethod(methodCallStep.getSemanticRuleStaticTarget());
		
		//List<Object> b = n.testMethod((EObject)a.get(1));
		
		//Assertions.assertTrue(TTQSelectionFunctions.isKindOf(methodCallClass, methodCallStep));
		RuntimeStepExplorer exp = new RuntimeStepExplorer();
		exp.explore(methodCallStep);
		List<MetamodelElementWrapper> res = exp.getList();
		List<Expression> asen = res.stream().map(s -> {
			MethodCallWrapper co = (MethodCallWrapper) res.get(0);
			Expression n = co.getReceiver();
			return n;
		}).toList();
		
		
	}
	
	@Test
	public void testAllMethodCallSelection() {
	
		EList<RuntimeStep> steps = TTQTestResources.miniJavaRootStepsSubstepsExample();
		List<RuntimeStep> selection = TTQSelectionFunctions.allOfKind(methodCallClass, steps);
		//Assertions.assertTrue(selection.stream().allMatch(step -> step.getSemanticRuleStaticTarget().eClass() == MiniJavaPackage.eINSTANCE.getMethodCall()));	
	}
	
	
		 
	
}
