package main.java.runtimeStepExplorer;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import main.java.gemocServer.metamodelElementWrapper.MetamodelElementWrapper;

public class MetaModelElementExplorer {
	
	private Set<MetamodelElementWrapper> setElement;
	
	
	public MetaModelElementExplorer(Set<MetamodelElementWrapper> element) {
		setElement = element;
	}
	
	public Optional<MetamodelElementWrapper> getWrapper(Object var) {
		if(var == null) {
			return Optional.empty();
		}
		Iterator<MetamodelElementWrapper> s = setElement.iterator();
		Optional<MetamodelElementWrapper> found = Optional.empty();
		while(s.hasNext() && !found.isPresent()) {
			found = s.next().test(var);
		}
		if(found.isPresent()) {
			return this.getSubWrapper(var, found.get());
		}
		return Optional.empty();
		
		
	}

	private Optional<MetamodelElementWrapper> getSubWrapper(Object var, MetamodelElementWrapper wrapper) {
		List<Object> test2 = this.getSubModelElement(var);
		if(!test2.isEmpty()) {
			List<MetamodelElementWrapper> res = this.getWrappers(test2);
			wrapper.addAllAttribute(res);
			return Optional.of(wrapper);
		}
		return Optional.empty();
	}
	
	public List<MetamodelElementWrapper> getWrappers(List<Object> var) {
		
		List<MetamodelElementWrapper> test = var.stream().map(el -> this.getWrapper(el)).filter(el -> el.isPresent()).map(el -> el.get()).toList();
		return test;
	}
	
	public List<Object> getSubModelElement(Object var){
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
	
	private boolean isGetter(Method method) {
		//TODO: verify that the name of the method contain the name of one of the instance attribute.
		return !method.isVarArgs() && (method.getReturnType() != void.class) && method.getName().startsWith("get");
	}
	
	
}
