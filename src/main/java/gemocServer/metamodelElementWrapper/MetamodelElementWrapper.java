package main.java.gemocServer.metamodelElementWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

import main.java.gemocServer.runtimeStepReader.MetamodelElementWrapperReaderVisitor;

public abstract class MetamodelElementWrapper{
	
	private final List<MetamodelElementWrapper> attributes = new ArrayList<>();
	
	public abstract String accept(MetamodelElementWrapperReaderVisitor visitor);
	
	public abstract Optional<MetamodelElementWrapper> test(Object var);

	public List<MetamodelElementWrapper> getAttributes() {
		return attributes;
	}
		
	public void addAllAttribute(List<MetamodelElementWrapper> list) {
		attributes.addAll(list);
	}
}
;