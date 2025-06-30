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
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;
import main.java.runtimeStepExplorer.RuntimeStepExplorer;

public class TestTTQSelection {

	EClass methodCallClass = MiniJavaPackage.eINSTANCE.getMethodCall();
	@Test
	public void testIsMethodCall() {
	
		RuntimeStep methodCallStep = TTQTestResources.miniJavaMethodCallStepExample();
		EList<RuntimeStep> test = TTQTestResources.miniJavaRootStepsExample();
		//Assertions.assertTrue(TTQSelectionFunctions.isKindOf(methodCallClass, methodCallStep));
		Set<MetamodelElementAdapter> car = this.test();
		RuntimeStepExplorer exp = new RuntimeStepExplorer(car);
		exp.explore(methodCallStep);
		List<MetamodelElementAdapter> res = exp.getList();
		
	}
	
	@Test
	public void testAllMethodCallSelection() {
	
		EList<RuntimeStep> steps = TTQTestResources.miniJavaRootStepsSubstepsExample();
		List<RuntimeStep> selection = TTQSelectionFunctions.allOfKind(methodCallClass, steps);
		//Assertions.assertTrue(selection.stream().allMatch(step -> step.getSemanticRuleStaticTarget().eClass() == MiniJavaPackage.eINSTANCE.getMethodCall()));	
	}
	
	private Set<MetamodelElementAdapter> test(){
		Set<MetamodelElementAdapter> res = new HashSet<>();
		List<String> wrappers = Arrays.asList(
				"AndImplAdapter",
			    "ArrayAccessImplAdapter",
			    "ArrayLengthImplAdapter",
			    "ArrayTypeRefImplAdapter",
			    "AssigneeImplAdapter",
			    "AssignmentImplAdapter",
			    "BlockImplAdapter",
			    "BoolConstantImplAdapter",
			    "BooleanTypeRefImplAdapter",
			    "ClassImplAdapter",
			    "ClassRefImplAdapter",
			    "DivisionImplAdapter",
			    "EqualityImplAdapter",
			    "ExpressionImplAdapter",
			    "FieldAccessImplAdapter",
			    "FieldImplAdapter",
			    "ForStatementImplAdapter",
			    "IfStatementImplAdapter",
			    "ImportImplAdapter",
			    "InferiorImplAdapter",
			    "InferiorOrEqualImplAdapter",
			    "InequalityImplAdapter",
			    "IntConstantImplAdapter",
			    "IntegerTypeRefImplAdapter",
			    "InterfaceImplAdapter",
			    "MemberImplAdapter",
			    "MethodCallImplAdapter",
			    "MethodImplAdapter",
			    "MinusImplAdapter",
			    "MultiplicationImplAdapter",
			    "NamedElementImplAdapter",
			    "NegImplAdapter",
			    "NewArrayImplAdapter",
			    "NewObjectImplAdapter",
			    "NotImplAdapter",
			    "NullImplAdapter",
			    "OrImplAdapter",
			    "ParameterImplAdapter",
			    "PlusImplAdapter",
			    "PrintStatementImplAdapter",
			    "ProgramImplAdapter",
			    "ReturnImplAdapter",
			    "SingleTypeRefImplAdapter",
			    "StatementImplAdapter",
			    "StringConstantImplAdapter",
			    "StringTypeRefImplAdapter",
			    "SuperImplAdapter",
			    "SuperiorImplAdapter",
			    "SuperiorOrEqualImplAdapter",
			    "SymbolImplAdapter",
			    "SymbolRefImplAdapter",
			    "ThisImplAdapter",
			    "TypeDeclarationImplAdapter",
			    "TypeRefImplAdapter",
			    "TypedDeclarationImplAdapter",
			    "VariableDeclarationImplAdapter",
			    "VoidTypeRefImplAdapter",
			    "WhileStatementImplAdapter"
			);
		
		 for (String nomClasse : wrappers) {
	            Class<?> clazz;
				try {
					clazz = Class.forName("main.java.gemocServer.metamodelElementWrapper.generatedAdapter.".concat(nomClasse));
					MetamodelElementAdapter instance = (MetamodelElementAdapter) clazz.getDeclaredConstructor().newInstance();
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
