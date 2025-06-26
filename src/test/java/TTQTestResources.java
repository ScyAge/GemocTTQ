package test.java;


import java.nio.file.Paths;


import org.eclipse.gemoc.trace.simple.RuntimeStep;
import org.eclipse.gemoc.trace.simple.SimpleTrace;
import org.eclipse.gemoc.trace.simple.impl.SimpleFactoryImpl;
import org.eclipse.gemoc.trace.simple.util.SimpleAdapterFactory;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;


public final class TTQTestResources {
	private static SimpleTrace trace;
	
	public static SimpleTrace miniJavaTraceExample() {
		if (trace == null) {
			Resource r = TTQTestResources.miniJavaTraceResource();
			EcoreUtil.resolveAll(r.getResourceSet());
			trace = (SimpleTrace) r.getContents().get(0);
		}
		return trace;
	}
	
	private static Resource miniJavaTraceResource() {
		ResourceSet rs = new ResourceSetImpl();
		//rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("simpletrace", new SimpleFactoryImpl());
		//rs.getPackageRegistry().put(yourPackage.getNsURI(), yourPackage);
		// Local path ?
		
		//URI uri = URI.createFileURI("src/tests/minijava-example.simpletrace");
		//String path = Paths.get(".").toAbsolutePath().toString();
		return rs.getResource(URI.createFileURI("src/test/java/minijava-example.simpletrace"), true);
		
	
	}
	
	public static RuntimeStep miniJavaMethodCallStepExample() {
		return TTQTestResources.miniJavaRootStepsExample().get(1).getSubSteps().get(9);
	}
	
	public static EList<RuntimeStep> miniJavaRootStepsExample() {
		return TTQTestResources.miniJavaTraceExample().getRootSteps();		
	}
	
	public static EList<RuntimeStep> miniJavaRootStepsSubstepsExample() {
		return TTQTestResources.miniJavaTraceExample().getRootSteps().get(1).getSubSteps();		
	}
	
}
