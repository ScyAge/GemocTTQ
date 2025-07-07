package main.java.runtimeStepExplorer;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementAdapter;
import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;

public class MetaModelElementExplorer {
	
	private final MiniJavaVisitor visitor = new MiniJavaVisitor();
	
	
	public MetaModelElementExplorer() {
		
	}
	
	public MetamodelElementWrapper getWrapper(Object var) {
		if(var == null) {
			return null;
		}
		MetamodelElementWrapper ne = visitor.doSwitch((EObject) var);
		return ne;
		
		
	}
	/**
	private Optional<MetamodelElementAdapter> getSubWrapper(Object var, MetamodelElementWrapper wrapper) {
		List<Object> test2 = this.getSubModelElement(var);
		if(!test2.isEmpty()) {
			return Optional.of(wrapper);
		}
		return Optional.empty();
	}
	
	public Map<Class<? extends Object>, MetamodelElementAdapter> getWrappers(List<Object> listSubAttribute) {
		Map<Class<? extends Object>, MetamodelElementAdapter> res = new HashMap<>();
		for(Object attr : listSubAttribute) {
			Optional<MetamodelElementAdapter> adapter = this.getWrapper(attr);
			if(adapter.isPresent()) {
				res.put(attr.getClass(), adapter.get());
			}
		}
		return res;
	}
	
	
	public List<Object> getSubModelElement(Object var){
		//var.eClass().getEAllStructuralFeatures();
		//var.eGet();
		//
		Class<?> classT = var.getClass();
		Method[] tabMethod = classT.getDeclaredMethods();
		List<Object> res = new ArrayList<>();
        for (Method f : tabMethod) {
            if(this.isGetter(f)) {
            	try {
            		res.add(f.invoke(var));
            	}
            	catch(Exception e) {
            		System.out.println("test erreur cast");
            	}
                
            }
        }
        return res;
	}
	
	public List<Object> testMethod(EObject element){
		List<Object> te = new ArrayList<>();
		EList<EStructuralFeature> res = element.eClass().getEAllStructuralFeatures();
		res.forEach(attr -> te.add(element.eGet(attr)));
		return te;
	}
	
	private boolean isGetter(Method method) {
		//TODO: verify that the name of the method contain the name of one of the instance attribute.
		return !method.isVarArgs() && (method.getReturnType() != void.class) && method.getName().startsWith("get");
	}
	**/
	
	
}
