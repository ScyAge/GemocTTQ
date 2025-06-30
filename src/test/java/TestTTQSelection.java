package test.java;


import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
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
		Set<MetamodelElementWrapper> car = this.test();
		RuntimeStepExplorer exp = new RuntimeStepExplorer(car);
		exp.explore(methodCallStep);
		List<MetamodelElementWrapper> res = exp.getList();
		
	}
	
	@Test
	public void testAllMethodCallSelection() {
	
		EList<RuntimeStep> steps = TTQTestResources.miniJavaRootStepsSubstepsExample();
		List<RuntimeStep> selection = TTQSelectionFunctions.allOfKind(methodCallClass, steps);
		//Assertions.assertTrue(selection.stream().allMatch(step -> step.getSemanticRuleStaticTarget().eClass() == MiniJavaPackage.eINSTANCE.getMethodCall()));	
	}
	
	private Set<MetamodelElementWrapper> test(){
		Set<MetamodelElementWrapper> res = new HashSet<>();
		List<String> wrappers = Arrays.asList(
			    "AssigneeImplWrapper",
			    "AssignmentImplWrapper",
			    "BlockImplWrapper",
			    "ImportImplWrapper",
			    "MethodImplWrapper",
			    "MethodCallImplWrapper",
			    "NamedElementImplWrapper",
			    "PrintStatementImplWrapper",
			    "ProgramImplWrapper",
			    "StatementImplWrapper",
			    "TypeRefImplWrapper",
			    "TypeDeclarationImplWrapper",
			    "TypedDeclarationImplWrapper",
			    "ExpressionImplWrapper",
			    "ForStatementImplWrapper",
			    "IfStatementImplWrapper",
			    "ReturnImplWrapper",
			    "WhileStatementImplWrapper",
			    "ArrayTypeRefImplWrapper",
			    "SingleTypeRefImplWrapper",
			    "ClassImplWrapper",
			    "InterfaceImplWrapper",
			    "MemberImplWrapper",
			    "SymbolImplWrapper",
			    "ArrayAccessImplWrapper",
			    "ArrayLengthImplWrapper",
			    "BoolConstantImplWrapper",
			    "DivisionImplWrapper",
			    "FieldAccessImplWrapper",
			    "IntConstantImplWrapper",
			    "NegImplWrapper",
			    "NewArrayImplWrapper",
			    "NewObjectImplWrapper",
			    "NotImplWrapper",
			    "NullImplWrapper",
			    "StringConstantImplWrapper",
			    "SuperImplWrapper",
			    "SymbolRefImplWrapper",
			    "ThisImplWrapper",
			    "BooleanTypeRefImplWrapper",
			    "ClassRefImplWrapper",
			    "IntegerTypeRefImplWrapper",
			    "StringTypeRefImplWrapper",
			    "VoidTypeRefImplWrapper",
			    "FieldImplWrapper",
			    "ParameterImplWrapper",
			    "VariableDeclarationImplWrapper",
			    "AndImplWrapper",
			    "EqualityImplWrapper",
			    "InequalityImplWrapper",
			    "InferiorImplWrapper",
			    "InferiorOrEqualImplWrapper",
			    "MinusImplWrapper",
			    "MultiplicationImplWrapper",
			    "OrImplWrapper",
			    "PlusImplWrapper",
			    "SuperiorImplWrapper",
			    "SuperiorOrEqualImplWrapper"
			);
		
		 for (String nomClasse : wrappers) {
	            Class<?> clazz;
				try {
					clazz = Class.forName("main.java.gemocServer.metamodelElementWrapper.generatedWrapper.".concat(nomClasse));
					MetamodelElementWrapper instance = (MetamodelElementWrapper) clazz.getDeclaredConstructor().newInstance();
		            res.add(instance);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchMethodException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SecurityException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	            
	        }
		 return res;
		 
	}
}
