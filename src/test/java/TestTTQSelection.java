package test.java;


import java.util.List;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.eclipse.gemoc.trace.simple.SimpleTrace;
import org.junit.jupiter.api.Test;
import org.tetrabox.minijava.model.miniJava.MiniJavaPackage;

import main.java.TTQSelectionFunctions;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;
import main.java.gemocServer.wrapperVisitor.MetamodelElementWrapperVisitor;
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
		MetamodelElementWrapperVisitor visitor = new MetamodelElementWrapperVisitor();
		exp.explore(test);
		List<MetamodelElementWrapper> res = exp.getList();
		List<String> asen = res.stream().map(s -> visitor.visit(s)).toList();
		System.out.print("sean");
		
	}
	
	@Test
	public void testAllMethodCallSelection() {
	
		EList<RuntimeStep> steps = TTQTestResources.miniJavaRootStepsSubstepsExample();
		List<RuntimeStep> selection = TTQSelectionFunctions.allOfKind(methodCallClass, steps);
		//Assertions.assertTrue(selection.stream().allMatch(step -> step.getSemanticRuleStaticTarget().eClass() == MiniJavaPackage.eINSTANCE.getMethodCall()));	
	}
	
	
		 
	
}
