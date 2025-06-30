package main.java.gemocServer.metamodelElementWrapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;

import main.java.gemocServer.runtimeStepReader.MetamodelElementWrapperReaderVisitor;

public abstract class MetamodelElementAdapter{
	
	private final Map<Class<? extends Object>, MetamodelElementAdapter> attributes = new HashMap<>();
	
	public abstract String accept(MetamodelElementWrapperReaderVisitor visitor);
	
	public abstract Optional<MetamodelElementAdapter> createAdapterIfInstanceOf(Object var);

	public Map<Class<? extends Object>, MetamodelElementAdapter> getAttributes() {
		return attributes;
	}
		
	public void addAllAttribute(Map<Class<? extends Object>, MetamodelElementAdapter> map) {
		attributes.putAll(map);
	}
}
;