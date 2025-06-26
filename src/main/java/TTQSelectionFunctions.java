package main.java;

import java.util.List;
import java.util.function.Predicate;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.gemoc.trace.simple.RuntimeStep;

public class TTQSelectionFunctions {
	 
	
	public static boolean isKindOf(EClass eClass, RuntimeStep step) {		
		return (step.getSemanticRuleStaticTarget().eClass() == eClass);
		
	}
	
	public static List<RuntimeStep> allOfKind(EClass eClass, EList<RuntimeStep> steps) {		
		Predicate<RuntimeStep> selectionPredicate = step -> isKindOf(eClass, step);
		return steps.stream().filter(selectionPredicate).toList();	
	}

}
